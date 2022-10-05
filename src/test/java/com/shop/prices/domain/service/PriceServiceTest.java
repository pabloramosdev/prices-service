package com.shop.prices.domain.service;

import com.shop.prices.domain.Price;
import com.shop.prices.domain.exception.PriceNotFoundException;
import com.shop.prices.domain.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static com.shop.prices.utils.PriceUtils.PRICE_PRIORITY_ONE;
import static com.shop.prices.utils.PriceUtils.PRICE_PRIORITY_ZERO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PriceServiceTest {

    @InjectMocks
    private PriceService priceService;

    @Mock
    private PriceRepository priceRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("When look for price in a date for branch and product then return the unique price")
    void testOnePrice() {
        when(priceRepository.findPriceBetweenDates(anyInt(),anyInt(),any(LocalDateTime.class)))
                .thenReturn(Collections.singletonList(Price.builder().build()));
        priceService.findPriceWithMaxPriority(1, 35455, LocalDateTime.now());
        verify(priceRepository).findPriceBetweenDates(anyInt(),anyInt(),any(LocalDateTime.class));
    }

    @Test
    @DisplayName("When look for price in a date for branch and product then return the price with max priority")
    void testManyPrices() {
        when(priceRepository.findPriceBetweenDates(anyInt(),anyInt(),any(LocalDateTime.class)))
                .thenReturn(Arrays.asList(PRICE_PRIORITY_ZERO, PRICE_PRIORITY_ONE));
        Price price = priceService.findPriceWithMaxPriority(1, 35455, LocalDateTime.now());
        verify(priceRepository).findPriceBetweenDates(anyInt(),anyInt(),any(LocalDateTime.class));
        assertEquals(1, price.getPriority());
    }

    @Test
    @DisplayName("When look for price in a date for branch and product then throw PriceNotFoundException")
    void testNoPrice() {
        when(priceRepository.findPriceBetweenDates(anyInt(),anyInt(),any(LocalDateTime.class)))
                .thenReturn(Collections.emptyList());
        var exception = assertThrows(PriceNotFoundException.class, () ->
                priceService.findPriceWithMaxPriority(1, 35455, LocalDateTime.now()));
        assertEquals("Price not found", exception.getMessage());
    }
}