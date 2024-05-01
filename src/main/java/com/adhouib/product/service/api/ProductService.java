package com.adhouib.product.service.api;

import com.adhouib.product.domain.Product;
import com.adhouib.product.exception.TechnicalException;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product createProduct(Product product) throws TechnicalException;

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Optional<Product> updateProduct(Long id, Product productToUpdate);

    void deleteProduct(Long id) throws TechnicalException;
}
