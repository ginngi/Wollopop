package com.ginzo.feature.productlist.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.ginzo.commons.entities.Product
import com.ginzo.commons.feature_commons.view.bindView
import com.ginzo.feature.productlist.presentation.R
import com.google.android.material.card.MaterialCardView

class ConsumerGoodsViewHolder(
  private val view: View,
  private val requestManager: RequestManager,
  private val onClickProductListener: (Product) -> Unit
) : RecyclerView.ViewHolder(view) {

  private val card: MaterialCardView by bindView(R.id.mcv_consumer_good_container)
  private val image: ImageView by bindView(R.id.iv_consumer_good_image)
  private val name: TextView by bindView(R.id.tv_consumer_good_name)
  private val distance: TextView by bindView(R.id.tv_consumer_good_distance)
  private val category: TextView by bindView(R.id.tv_consumer_good_category)
  private val price: TextView by bindView(R.id.tv_consumer_good_price)

  fun bind(product: Product.ConsumerGoods) {
    card.setOnClickListener { onClickProductListener(product) }

    requestManager.load(product.image)
      .transform(CenterCrop(), RoundedCorners(8))
      .into(image)

    name.text = product.name
    category.text = product.category
    distance.text = view.context.getString(R.string.distance, product.distanceInMeters)
    price.text = product.price
  }
}