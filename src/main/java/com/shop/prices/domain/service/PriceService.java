package com.shop.prices.domain.service;

import com.shop.prices.domain.Price;
import com.shop.prices.domain.exception.PriceNotFoundException;
import com.shop.prices.domain.repository.PriceRepository;

import java.time.LocalDateTime;
import java.util.Comparator;

public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price findPriceWithMaxPriority(Integer brandId, Integer productId, LocalDateTime applicationDate) {
        return priceRepository.findPriceBetweenDates(brandId, productId, applicationDate)
                .stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(() -> new PriceNotFoundException("Price not found"));
    }

}
