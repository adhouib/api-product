package com.adhouib.product.converter.entity;

import com.adhouib.product.converter.ConverterApi;
import com.adhouib.product.domain.Product;
import com.adhouib.product.entity.ProductEntity;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductToProductEntityConverterTest {

    @Inject
    ConverterApi<Product, ProductEntity> productToEntityConverter;

    @BeforeEach
    void setUp() {
        productToEntityConverter = new ProductToEntityConverter();
    }

    @Test
    public void convert() {
        Product product = new Product();
        product.setId(23L);
        product.setName("test");
        product.setPrice(new BigDecimal("12.34"));
        product.setQuantity(10);

        ProductEntity productEntity = productToEntityConverter.convert(product);

        Assertions.assertNotNull(productEntity);
        Assertions.assertEquals(product.getId(), productEntity.getId());
        Assertions.assertEquals(product.getName(), productEntity.getName());
        Assertions.assertEquals(product.getPrice(), productEntity.getPrice());
        Assertions.assertEquals(product.getQuantity(), productEntity.getQuantity());
    }
}