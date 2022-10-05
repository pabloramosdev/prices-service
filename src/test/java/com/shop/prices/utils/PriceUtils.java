package com.shop.prices.utils;

import com.shop.prices.domain.Price;
import com.shop.prices.infrastructure.repository.h2.PriceEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceUtils {
    public static final Integer ZARA = 1;
    public static final Integer PRODUCT_ID = 35455;
    public static final PriceEntity PRICE_ENTITY = price();

    public static final Price PRICE_PRIORITY_ZERO = Price.builder().priority(0).build();
    public static final Price PRICE_PRIORITY_ONE = Price.builder().priority(1).build();
    public static final Price PRICE = Price.builder()
            .id(1L)
            .brandId(ZARA)
            .productId(PRODUCT_ID)
            .priceList(1)
            .price(BigDecimal.valueOf(50.45))
            .priority(1)
            .startDate(LocalDateTime.now().minusMonths(1L))
            .endDate(LocalDateTime.now().plusMonths(1L))
            .currency("EUR")
            .build();

    private static PriceEntity price() {
        PriceEntity price = new PriceEntity();
        price.setBrandId(ZARA);
        price.setProductId(PRODUCT_ID);
        price.setPriceList(1);
        price.setPriority(1);
        price.setPrice(BigDecimal.valueOf(50.45));
        price.setStartDate(LocalDateTime.now().minusMonths(1L));
        price.setEndDate(LocalDateTime.now().plusMonths(1L));
        price.setCurrency("EUR");
        return price;
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
        assertEquals(expected.getBrandId(), actual.getBrandId());
        assertEquals(expected.getProductId(), actual.getProductId());
        assertEquals(expected.getPriceList(), actual.getPriceList());
        assertEquals(expected.getPrice(), actual.getPrice());
        assertEquals(expected.getPriority(), actual.getPriority());
        assertEquals(expected.getCurrency(), actual.getCurrency());
    }

}
