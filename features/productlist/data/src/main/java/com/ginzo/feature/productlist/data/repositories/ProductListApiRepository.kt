package com.ginzo.feature.productlist.data.repositories

import arrow.core.Either
import com.ginzo.feature.productlist.data.api.ProductListApiRest
import com.ginzo.features.productlist.domain.entities.Product
import com.ginzo.remote.ResponseTransformer
import io.reactivex.Single
import javax.inject.Inject

class ProductListApiRepository @Inject constructor(
	private val apiRest: ProductListApiRest,
	private val responseTransformer: ResponseTransformer
) {
	fun products(): Single<Either<Throwable, List<Product>>> {
		return apiRest.getProducts()
			.compose(responseTransformer.responseToEither { productList ->
				productList.map { it.toDomain() }
			})
	}
}