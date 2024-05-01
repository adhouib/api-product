package com.adhouib.product.converter.domain;

import com.adhouib.product.converter.ConverterApi;
import com.adhouib.product.domain.Product;
import com.adhouib.product.entity.ProductEntity;
import org.springframework.stereotype.Component;

/**
 * Convert ProductEntity  Object to a Product domain object
 */
@Component
public class ProductEntityToDomainConverter implements ConverterApi<ProductEntity, Product> {

    @Override
    public Product convert(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        product.setQuantity(productEntity.getQuantity());
        return product;
    }
}
