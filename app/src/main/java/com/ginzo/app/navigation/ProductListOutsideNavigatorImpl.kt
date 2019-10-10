package com.ginzo.app.navigation

import androidx.appcompat.app.AppCompatActivity
import com.ginzo.feature.productlist.presentation.navigation.ProductListOutsideNavigator
import javax.inject.Inject

class ProductListOutsideNavigatorImpl constructor(
  private val navigator: Navigator
) : ProductListOutsideNavigator {
  override fun productDetails() {
    navigator.productDetail()
  }

  class Factory @Inject constructor(
    private val factory: AppNavigator.Factory
  ) : ProductListOutsideNavigator.Factory {

    override fun create(activity: AppCompatActivity): ProductListOutsideNavigator {
      return ProductListOutsideNavigatorImpl(factory.create(activity))
    }
  }

}