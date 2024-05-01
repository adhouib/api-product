package com.adhouib.product.converter.entity;

import com.adhouib.product.converter.ConverterApi;
import com.adhouib.product.domain.Product;
import com.adhouib.product.entity.ProductEntity;
import org.springframework.stereotype.Component;

/**
 * Convert Product  Object to a Product entity object
 */
@Component
public class ProductToEntityConverter implements ConverterApi<Product, ProductEntity> {
    @Override
    public ProductEntity convert(Product product) {
        if (product == null) {
            return null;
        }
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantity(product.getQuantity());
        return productEntity;
    }
}
