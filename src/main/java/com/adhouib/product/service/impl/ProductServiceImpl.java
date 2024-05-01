package com.adhouib.product.service.impl;

import com.adhouib.product.converter.ConverterApi;
import com.adhouib.product.domain.Product;
import com.adhouib.product.entity.ProductEntity;
import com.adhouib.product.exception.TechnicalException;
import com.adhouib.product.repository.ProductRepository;
import com.adhouib.product.service.api.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service to manage Product Object
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ConverterApi<Product, ProductEntity> productEntityConverter;
    private final ConverterApi<ProductEntity, Product> productDomainConverter;


    public ProductServiceImpl(ProductRepository productRepository, ConverterApi<Product, ProductEntity> productEntityConverterApi, ConverterApi<ProductEntity, Product> productDomainConverter) {
        this.productRepository = productRepository;
        this.productEntityConverter = productEntityConverterApi;
        this.productDomainConverter = productDomainConverter;
    }

    @Override
    public Product createProduct(Product product) throws TechnicalException {
        if (product == null) {
            throw new TechnicalException("Product can't be null");
        }
        ProductEntity productEntity = productEntityConverter.convert(product);
        productEntity = productRepository.save(productEntity);
        log.info("Product {} created", productEntity.getId());
        return productDomainConverter.convert(productEntity);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productDomainConverter::convert).toList();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id).map(productDomainConverter::convert);
    }

    /**
     * Perform an update on existing product
     * @param id the product to update
     * @param productToUpdate new version of product to update
     * @return an Optional Product
     */
    @Override
    public Optional<Product> updateProduct(Long id, Product productToUpdate) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (productEntity.isPresent()) {
           productEntity.get().setName(productToUpdate.getName());
           productEntity.get().setPrice(productToUpdate.getPrice());
           productEntity.get().setQuantity(productToUpdate.getQuantity());
           ProductEntity updatedProductEntity = productRepository.save(productEntity.get());
           log.info("Product {} updated", id);
           return Optional.of(updatedProductEntity).map(productDomainConverter::convert);
        }
        return Optional.empty();
    }

}
