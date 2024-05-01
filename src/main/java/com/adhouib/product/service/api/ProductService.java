package com.adhouib.product.service.api;

import com.adhouib.product.domain.Product;
import com.adhouib.product.exception.TechnicalException;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product) throws TechnicalException;

    List<Product> getAllProducts();
}
