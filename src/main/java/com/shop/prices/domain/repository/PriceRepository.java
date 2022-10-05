package com.shop.prices.domain.repository;

import com.shop.prices.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findPriceBetweenDates(Integer brandId, Integer productId, LocalDateTime applicationDate);
}
