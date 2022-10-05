package com.shop.prices.domain.repository;

import com.shop.prices.domain.Brand;
import com.shop.prices.domain.Price;
import com.shop.prices.domain.ProductId;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findPriceBetweenDates(Brand brand, ProductId productId, LocalDateTime applicationDate);
}
