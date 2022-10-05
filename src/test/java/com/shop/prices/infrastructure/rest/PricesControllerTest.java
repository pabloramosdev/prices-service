package com.shop.prices.infrastructure.rest;

import com.shop.prices.application.QueryPriceByPriority;
import com.shop.prices.domain.exception.PriceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PricesControllerTest {

    private MockMvc mvc;

    private PricesController pricesController;

    @Mock
    private QueryPriceByPriority queryPriceByPriority;

    @BeforeEach
    public void setUp() throws Exception {
        this.pricesController = new PricesController(queryPriceByPriority);
        mvc = MockMvcBuilders.standaloneSetup(pricesController).setCustomArgumentResolvers().build();
    }

    @Test
    public void getPricesTest_Ok() throws Exception {
        when(queryPriceByPriority.findPriceByPriority(anyInt(),anyInt(), any())).thenReturn(PriceResponse.builder().build());
        mvc.perform(get("/prices?product_id=35455&brand_id=1&application_date=2020-06-14 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(queryPriceByPriority).findPriceByPriority(anyInt(),anyInt(),any());
    }

    @Test
    public void getPricesTest_NoFound() throws Exception {
        when(queryPriceByPriority.findPriceByPriority(anyInt(),anyInt(),any())).thenThrow(PriceNotFoundException.class);
        mvc.perform(get("/prices?product_id=35455&brand_id=1&application_date=2050-06-14 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(queryPriceByPriority).findPriceByPriority(anyInt(),anyInt(),any());
    }
}