package com.adhouib.product.controller;

import com.adhouib.product.converter.ConverterApi;
import com.adhouib.product.domain.Product;
import com.adhouib.product.dto.ProductDTO;
import com.adhouib.product.exception.TechnicalException;
import com.adhouib.product.service.api.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;
    private final ConverterApi<ProductDTO, Product> productConverter;
    private final ConverterApi<Product, ProductDTO> productDTOConverter;

    public ProductController(ProductService productService, ConverterApi<ProductDTO, Product> productConverter, ConverterApi<Product, ProductDTO> productDTOConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
        this.productDTOConverter = productDTOConverter;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) throws TechnicalException {
        if (productDTO == null) {
          throw new TechnicalException("ProductDTO can't be null");
        }
        Product product = productConverter.convert(productDTO);
        product = productService.createProduct(product);
        return productDTOConverter.convert(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> listProducts() {
        return productService.getAllProducts().stream().map(productDTOConverter::convert).toList();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProductById(@PathVariable("id") Long id) throws TechnicalException {
        if (id == null) {
            throw new TechnicalException("id can't be null");
        }
        return productService.getProductById(id).map(productDTOConverter::convert)
                .orElseThrow(() -> new TechnicalException("Object not found"));
    }

}
