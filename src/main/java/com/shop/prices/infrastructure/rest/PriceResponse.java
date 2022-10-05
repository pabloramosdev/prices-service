package com.shop.prices.infrastructure.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class PriceResponse {
    private Integer productId;
    private Integer brandId;
    private LocalDateTime applicationDate;
    private Integer priceList;
    private BigDecimal price;
}
