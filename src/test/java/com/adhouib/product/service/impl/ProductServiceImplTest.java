package com.adhouib.product.service.impl;

import com.adhouib.product.converter.ConverterApi;
import com.adhouib.product.converter.domain.ProductEntityToDomainConverter;
import com.adhouib.product.converter.entity.ProductToEntityConverter;
import com.adhouib.product.domain.Product;
import com.adhouib.product.entity.ProductEntity;
import com.adhouib.product.exception.TechnicalException;
import com.adhouib.product.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    private final ConverterApi<Product, ProductEntity> productEntityConverter = new ProductToEntityConverter();

    private final ConverterApi<ProductEntity, Product> productDomainConverter = new ProductEntityToDomainConverter();

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(productService, "productEntityConverter", productEntityConverter);
        ReflectionTestUtils.setField(productService, "productDomainConverter", productDomainConverter );
    }

    @Test
    public void testCreateProduct() throws TechnicalException {
        // Given
        Product product = new Product();
        product.setId(101L);
        product.setName("Product name");
        product.setPrice(new BigDecimal("130.00"));
        product.setQuantity(200);

        ProductEntity productEntity = new ProductEntity();

        BeanUtils.copyProperties(product, productEntity);
        when(productRepository.save(any(ProductEntity.class))).thenReturn(productEntity);

        // When
        Product result = productService.createProduct(product);

        // Then
        verify(productRepository).save(productEntity);
        // Add additional assertions based on your business logic
        Assertions.assertEquals(101L, result.getId());
    }

    @Test
    public void testCreateProduct_Exception() {
        Product product = null;
        Assertions.assertThrows(TechnicalException.class , () -> productService.createProduct(product));
    }

    @Test
    public void testGetAllProducts() {
        List<ProductEntity> productEntityList = new LinkedList<>();
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(101L);
        productEntity.setName("Product name");
        productEntity.setPrice(new BigDecimal("130.00"));
        productEntity.setQuantity(200);
        productEntityList.add(productEntity);

        ProductEntity productEntity1 = new ProductEntity();
        productEntity1.setId(102L);
        productEntity1.setName("Product name");
        productEntity1.setPrice(new BigDecimal("160.00"));
        productEntity1.setQuantity(120);
        productEntityList.add(productEntity1);

        when(productRepository.findAll()).thenReturn(productEntityList);

        List<Product> result = productService.getAllProducts();

        verify(productRepository).findAll();
        Assertions.assertEquals(productEntityList.size(), result.size());
        Assertions.assertEquals(productEntityList.get(0).getId(), result.get(0).getId());
    }
}
