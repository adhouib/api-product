package com.adhouib.product.converter;

public interface ConverterApi <S, T> {
    T convert(S source);
}
