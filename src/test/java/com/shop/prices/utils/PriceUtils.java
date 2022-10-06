package com.shop.prices.utils;

import com.shop.prices.domain.Brand;
import com.shop.prices.domain.Price;
import com.shop.prices.domain.ProductId;
import com.shop.prices.infrastructure.repository.h2.PriceEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.shop.prices.domain.Currency.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceUtils {
    public static final LocalDateTime dateTime = LocalDateTime.of(2022, 8, 20, 10, 0, 0);
    public static final LocalDateTime lastMonth = dateTime.minusMonths(1L);
    public static final LocalDateTime nextMonth = dateTime.plusMonths(1L);
    public static final Brand ZARA = Brand.create(1);
    public static final ProductId PRODUCT_ID = new ProductId(55);
    public static final PriceEntity PRICE_ENTITY = priceEntity();
    public static final Price PRICE_PRIORITY_ZERO = Price.builder().priority(0).build();
    public static final Price PRICE_PRIORITY_ONE = Price.builder().priority(1).build();

    public static final Price PRICE = Price.builder()
            .id(5L)
            .brand(ZARA)
            .productId(PRODUCT_ID)
            .priceList(1)
            .price(BigDecimal.valueOf(50.45))
            .priority(1)
            .startDate(lastMonth)
            .endDate(nextMonth)
            .currency(EUR)
            .build();

    private static PriceEntity priceEntity() {
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setId(5L);
        priceEntity.setBrandId(ZARA.getId());
        priceEntity.setProductId(PRODUCT_ID.getId());
        priceEntity.setPriceList(1);
        priceEntity.setPriority(1);
        priceEntity.setPrice(BigDecimal.valueOf(50.45));
        priceEntity.setStartDate(lastMonth);
        priceEntity.setEndDate(nextMonth);
        priceEntity.setCurrency(EUR.name());
        return priceEntity;
    }

    public static void assertEqualsPriceEntity(PriceEntity expected, PriceEntity actual) {
        assertEquals(expected.getBrandId(), actual.getBrandId());
        assertEquals(expected.getProductId(), actual.getProductId());
        assertEquals(expected.getPriceList(), actual.getPriceList());
        assertEquals(expected.getPrice(), actual.getPrice());
        assertEquals(expected.getPriority(), actual.getPriority());
        assertEquals(actual.getStartDate(), expected.getStartDate());
        assertEquals(actual.getEndDate(), expected.getEndDate());
        assertEquals(expected.getCurrency(), actual.getCurrency());
    }

    public static void assertEqualsPrice(Price expected, Price actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getBrand(), actual.getBrand());
        assertEquals(expected.getProductId().getId(), actual.getProductId().getId());
        assertEquals(expected.getPriceList(), actual.getPriceList());
        assertEquals(expected.getPrice(), actual.getPrice());
        assertEquals(expected.getPriority(), actual.getPriority());
        assertEquals(actual.getStartDate(), expected.getStartDate());
        assertEquals(actual.getEndDate(), expected.getEndDate());
        assertEquals(expected.getCurrency(), actual.getCurrency());
    }

}
