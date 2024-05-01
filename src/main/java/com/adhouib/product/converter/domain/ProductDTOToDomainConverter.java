package com.adhouib.product.converter.domain;

import com.adhouib.product.converter.ConverterApi;
import com.adhouib.product.domain.Product;
import com.adhouib.product.dto.ProductDTO;
import org.springframework.stereotype.Component;

/**
 * Convert ProductDTO  Object to a Product domain object
 */
@Component
public class ProductDTOToDomainConverter implements ConverterApi<ProductDTO, Product> {
    public Product convert(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDTO.id());
        product.setName(productDTO.name());
        product.setQuantity(productDTO.quantity());
        product.setPrice(productDTO.price());
        return product;
    }
}
