package com.shop.prices.application;

import com.shop.prices.domain.Price;
import com.shop.prices.domain.service.PriceService;
import com.shop.prices.infrastructure.rest.PriceResponse;

import java.time.LocalDateTime;

public class QueryPriceByPriority {

    private final PriceService priceService;

    public QueryPriceByPriority(PriceService priceService) {
        this.priceService = priceService;
    }

    public PriceResponse findPriceByPriority(Integer brandId, Integer productId, LocalDateTime applicationDate) {
        Price price = priceService.findPriceWithMaxPriority(brandId, productId, applicationDate);
        return PriceResponse.builder().price(price.getPrice()).productId(price.getProductId())
                .brandId(price.getBrandId()).priceList(price.getPriceList()).applicationDate(applicationDate).build();
    }

}
