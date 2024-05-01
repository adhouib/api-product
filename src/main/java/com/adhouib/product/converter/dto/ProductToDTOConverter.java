package com.adhouib.product.converter.dto;

import com.adhouib.product.converter.ConverterApi;
import com.adhouib.product.domain.Product;
import com.adhouib.product.dto.ProductDTO;
import org.springframework.stereotype.Component;

/**
 * Convert Product  Object to a Product DTO object
 */
@Component
public class ProductToDTOConverter implements ConverterApi<Product, ProductDTO> {
    @Override
    public ProductDTO convert(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductDTO(product.getId(), product.getName(), product.getQuantity(), product.getPrice());
    }
}
