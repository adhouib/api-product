package com.adhouib.product.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private long id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
}
