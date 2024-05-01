package com.adhouib.product.converter.dto;

import com.adhouib.product.converter.ConverterApi;
import com.adhouib.product.domain.Product;
import com.adhouib.product.dto.ProductDTO;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductToDTOConverterTest {

    @Inject
    ConverterApi<Product, ProductDTO> productToDTOConverter;

    @BeforeEach
    void setUp() {
        productToDTOConverter = new ProductToDTOConverter();
    }

    @Test
    public void convert() {
        Product product = new Product();
        product.setId(23L);
        product.setName("test");
        product.setPrice(new BigDecimal("12.34"));
        product.setQuantity(10);

        ProductDTO productDTO = productToDTOConverter.convert(product);

        Assertions.assertNotNull(productDTO);
        Assertions.assertEquals(product.getId(), productDTO.id());
        Assertions.assertEquals(product.getName(), productDTO.name());
        Assertions.assertEquals(product.getPrice(), productDTO.price());
        Assertions.assertEquals(product.getQuantity(), productDTO.quantity());
    }
}
