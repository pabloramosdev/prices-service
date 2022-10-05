package com.shop.prices.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.shop.prices.domain.Brand.*;
import static org.junit.jupiter.api.Assertions.*;

class BrandTest {
    @Test
    @DisplayName("when look brand by id then return the name of the brand")
    void findById() {
        assertEquals(ZARA, Brand.findById(1));
        assertEquals(PULL_AND_BEAR, Brand.findById(2));
        assertEquals(MASSIMO_DUTTI, Brand.findById(3));
        assertEquals(BERSHKA, Brand.findById(4));
        assertEquals(STRADIVARIUS, Brand.findById(5));
        assertEquals(OYSHO, Brand.findById(6));
        assertEquals(ZARA_HOME, Brand.findById(7));
        assertEquals(UTERQUE, Brand.findById(8));
    }

    @Test
    void getName() {
        assertEquals("ZARA", ZARA.getName());
        assertEquals("Pull&Bear", PULL_AND_BEAR.getName());
        assertEquals("Massimo Dutti", MASSIMO_DUTTI.getName());
        assertEquals("Bershka", BERSHKA.getName());
        assertEquals("Stradivarius", STRADIVARIUS.getName());
        assertEquals("Oysho", OYSHO.getName());
        assertEquals("Zara Home", ZARA_HOME.getName());
        assertEquals("Uterqüe", UTERQUE.getName());
    }
}