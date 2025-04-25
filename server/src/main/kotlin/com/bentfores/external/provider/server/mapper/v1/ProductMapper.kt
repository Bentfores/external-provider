package com.bentfores.external.provider.server.mapper.v1

import com.bentfores.external.provider.server.external.model.ExternalProductsInfo
import com.bentfores.external.provider.ProductInfo.ProductsInfo
import org.springframework.stereotype.Component

@Component
class ProductMapper {

  fun mapToProductsInfo(externalList: List<ExternalProductsInfo>): ProductsInfo {
    val products = externalList.map {
      ProductsInfo.Product.newBuilder()
        .setArticle(it.article)
        .setName(it.name)
        .setImageUrl(it.imageUrl)
        .setProfitPlace(it.profitPlace.toString())
        .build()
    }
    return ProductsInfo.newBuilder().addAllProducts(products).build()
  }
}