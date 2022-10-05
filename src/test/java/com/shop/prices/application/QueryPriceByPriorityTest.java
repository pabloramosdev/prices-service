package com.shop.prices.application;

import com.shop.prices.domain.Brand;
import com.shop.prices.domain.ProductId;
import com.shop.prices.domain.service.PriceService;
import com.shop.prices.infrastructure.rest.PriceResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.shop.prices.utils.PriceUtils.PRICE;
import static com.shop.prices.utils.PriceUtils.dateTime;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class QueryPriceByPriorityTest {

    @InjectMocks
    private QueryPriceByPriority queryPriceByPriority;

    @Mock
    private PriceService priceService;

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
    @DisplayName("when find price by priority return price response")
    void findPriceByPriority() {
        when(priceService.findPriceWithMaxPriority(any(Brand.class), any(ProductId.class), any())).thenReturn(PRICE);
        PriceResponse priceResponse = queryPriceByPriority.findPriceByPriority(1, 2, dateTime);
        verify(priceService).findPriceWithMaxPriority(any(Brand.class), any(ProductId.class), any());
        assertEquals(PRICE.getPriceList(), priceResponse.getPriceList());
        assertEquals(PRICE.getProductId().getId(), priceResponse.getProductId());
        assertEquals(PRICE.getBrand().getId(), priceResponse.getBrandId());
        assertEquals(PRICE.getPrice(), priceResponse.getPrice());
    }
}