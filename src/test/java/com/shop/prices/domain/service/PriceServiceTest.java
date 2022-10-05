package com.shop.prices.domain.service;

import com.shop.prices.domain.Brand;
import com.shop.prices.domain.Price;
import com.shop.prices.domain.ProductId;
import com.shop.prices.domain.exception.PriceNotFoundException;
import com.shop.prices.domain.repository.PriceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static com.shop.prices.domain.Brand.*;
import static com.shop.prices.utils.PriceUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PriceServiceTest {

    @InjectMocks
    private PriceService priceService;

    @Mock
    private PriceRepository priceRepository;

    private AutoCloseable closeable;

    @BeforeEach
    void initService() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("When look for price in a date for branch and product then return the unique price")
    void testOnePrice() {
        when(priceRepository.findPriceBetweenDates(any(Brand.class),any(ProductId.class),any(LocalDateTime.class)))
                .thenReturn(Collections.singletonList(Price.builder().build()));
        priceService.findPriceWithMaxPriority(ZARA, PRODUCT_ID, LocalDateTime.now());
        verify(priceRepository).findPriceBetweenDates(any(Brand.class),any(ProductId.class),any(LocalDateTime.class));
    }

    @Test
    @DisplayName("When look for price in a date for branch and product then return the price with max priority")
    void testManyPrices() {
        when(priceRepository.findPriceBetweenDates(any(Brand.class),any(ProductId.class),any(LocalDateTime.class)))
                .thenReturn(Arrays.asList(PRICE_PRIORITY_ZERO, PRICE_PRIORITY_ONE));
        Price price = priceService.findPriceWithMaxPriority(ZARA, PRODUCT_ID, LocalDateTime.now());
        verify(priceRepository).findPriceBetweenDates(any(Brand.class),any(ProductId.class),any(LocalDateTime.class));
        assertEquals(1, price.getPriority());
    }

    @Test
    @DisplayName("When look for price in a date for branch and product then throw PriceNotFoundException")
    void testNoPrice() {
        when(priceRepository.findPriceBetweenDates(any(Brand.class),any(ProductId.class),any(LocalDateTime.class)))
                .thenReturn(Collections.emptyList());
        var exception = assertThrows(PriceNotFoundException.class, () ->
                priceService.findPriceWithMaxPriority(ZARA, PRODUCT_ID, LocalDateTime.now()));
        assertEquals("Price not found", exception.getMessage());
    }
}