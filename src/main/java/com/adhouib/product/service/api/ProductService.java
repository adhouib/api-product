package com.adhouib.product.service.api;

import com.adhouib.product.domain.Product;
import com.adhouib.product.exception.TechnicalException;

public interface ProductService {

    Product createProduct(Product product) throws TechnicalException;
}
