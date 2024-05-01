package com.adhouib.product.converter.domain;

import com.adhouib.product.converter.ConverterApi;
import com.adhouib.product.domain.Product;
import com.adhouib.product.entity.ProductEntity;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductEntityToDomainConverterTest {

    @Inject
    ConverterApi<ProductEntity, Product> productORToDomainConverter;

    @BeforeEach
    void setUp() {
        productORToDomainConverter = new ProductEntityToDomainConverter();
    }

    @Test
    public void convert() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setName("Product Name");
        productEntity.setPrice(new BigDecimal("12.34"));
        productEntity.setQuantity(10);

        Product product = productORToDomainConverter.convert(productEntity);

        Assertions.assertNotNull(product);
        Assertions.assertEquals(product.getId(), productEntity.getId());
        Assertions.assertEquals(product.getName(), productEntity.getName());
        Assertions.assertEquals(product.getPrice(), productEntity.getPrice());
        Assertions.assertEquals(product.getQuantity(), productEntity.getQuantity());
    }

}
