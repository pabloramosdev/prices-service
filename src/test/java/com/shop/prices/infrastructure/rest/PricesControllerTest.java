package com.shop.prices.infrastructure.rest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PricesControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Get Prices for ZARA product at 2020-06-14 10:00:00")
    public void testOne() throws Exception {
        mvc.perform(get("/prices?product_id=35455&brand_id=1&application_date=2020-06-14 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.applicationDate").value("2020-06-14 10:00:00"))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.5));
    }

    @Test
    @DisplayName("Get Prices for ZARA product at 2020-06-14 16:00:00")
    public void testTwo() throws Exception {
        mvc.perform(get("/prices?product_id=35455&brand_id=1&application_date=2020-06-14 16:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.applicationDate").value("2020-06-14 16:00:00"))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    @DisplayName("Get Prices for ZARA product at 2020-06-14 21:00:00")
    public void testThree() throws Exception {
        mvc.perform(get("/prices?product_id=35455&brand_id=1&application_date=2020-06-14 21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.applicationDate").value("2020-06-14 21:00:00"))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.5));
    }
    @Test
    @DisplayName("Get Prices for ZARA product at 2020-06-15 10:00:00")
    public void testFour() throws Exception {
        mvc.perform(get("/prices?product_id=35455&brand_id=1&application_date=2020-06-15 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.applicationDate").value("2020-06-15 10:00:00"))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.price").value(30.5));
    }

    @Test
    @DisplayName("Get Prices for ZARA product at 2020-06-16 21:00:00")
    public void testFive() throws Exception {
        mvc.perform(get("/prices?product_id=35455&brand_id=1&application_date=2020-06-16 21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.applicationDate").value("2020-06-16 21:00:00"))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.price").value(38.95));
    }

    @Test
    @DisplayName("when look for prices for brand id 2 return not found")
    public void testNotFound() throws Exception {
        mvc.perform(get("/prices?product_id=35455&brand_id=2&application_date=2020-06-14 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}