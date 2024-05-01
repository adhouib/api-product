package com.adhouib.product.converter.domain;

import com.adhouib.product.converter.ConverterApi;
import com.adhouib.product.domain.Product;
import com.adhouib.product.dto.ProductDTO;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductDTOToDomainConverterTest {

    @Inject
    ConverterApi<ProductDTO, Product> productDTOToDomainConverter;

    @BeforeEach
    void setUp() {
        productDTOToDomainConverter = new ProductDTOToDomainConverter();
    }

    @Test
    public void testConvert() {
        ProductDTO productDTO = new ProductDTO(1L, "Product Name", 100, new BigDecimal(12));

        Product product = productDTOToDomainConverter.convert(productDTO);

        Assertions.assertNotNull(product);
        Assertions.assertEquals(productDTO.name(), product.getName());
        Assertions.assertEquals(productDTO.quantity(), product.getQuantity());
        Assertions.assertEquals(productDTO.price(), product.getPrice());
        Assertions.assertEquals(productDTO.id(), product.getId());
    }

}
