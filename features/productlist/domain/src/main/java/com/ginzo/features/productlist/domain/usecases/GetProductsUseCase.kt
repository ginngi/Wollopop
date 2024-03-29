package com.ginzo.features.productlist.domain.usecases

import arrow.core.Either
import com.ginzo.commons.feature_commons.test.OpenClass
import com.ginzo.features.productlist.domain.repositories.ProductListRepository
import io.reactivex.Single
import javax.inject.Inject

@OpenClass
class GetProductsUseCase @Inject constructor(
  private val repository: ProductListRepository
) {

  fun getProducts(): Single<Either<Throwable, List<com.ginzo.commons.entities.Product>>> {
    return repository.getProducts()
  }
}