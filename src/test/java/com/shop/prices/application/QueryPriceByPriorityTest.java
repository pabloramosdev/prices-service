package com.shop.prices.application;

import com.shop.prices.domain.service.PriceService;
import com.shop.prices.infrastructure.rest.PriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static com.shop.prices.utils.PriceUtils.PRICE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class QueryPriceByPriorityTest {

    @InjectMocks
    private QueryPriceByPriority queryPriceByPriority;

    @Mock
    private PriceService priceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("when find price by priority return price response")
    void findPriceByPriority() {
        when(priceService.findPriceWithMaxPriority(anyInt(), anyInt(), any())).thenReturn(PRICE);
        PriceResponse priceResponse = queryPriceByPriority.findPriceByPriority(1, 2, LocalDateTime.now());
        assertEquals(PRICE.getPriceList(), priceResponse.getPriceList());
        assertEquals(PRICE.getProductId(), priceResponse.getProductId());
        assertEquals(PRICE.getBrandId(), priceResponse.getBrandId());
        assertEquals(PRICE.getPrice(), priceResponse.getPrice());
    }
}