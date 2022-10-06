package com.shop.prices.application;

import com.shop.prices.domain.Brand;
import com.shop.prices.domain.Price;
import com.shop.prices.domain.ProductId;
import com.shop.prices.domain.service.PriceService;
import com.shop.prices.infrastructure.rest.PriceResponse;

import java.time.LocalDateTime;

public class QueryPriceByPriority {

    private final PriceService priceService;

    public QueryPriceByPriority(PriceService priceService) {
        this.priceService = priceService;
    }

    public PriceResponse findPriceByPriority(Integer brandId, Integer productId, LocalDateTime applicationDate) {
        Price price = priceService.findPriceWithMaxPriority(Brand.create(brandId), new ProductId(productId), applicationDate);
        return PriceResponse.builder().price(price.getPrice()).productId(price.getProductId().getId())
                .brandId(price.getBrand().getId()).priceList(price.getPriceList()).applicationDate(applicationDate).build();
    }

}
