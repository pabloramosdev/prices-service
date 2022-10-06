package com.shop.prices.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandTest {
    @Test
    @DisplayName("when create brand with id = 1 then return ZARA Brand")
    void createZaraTest() {
        Brand brand = Brand.create(1);
        assertEquals(1, brand.getId());
        assertEquals("ZARA", brand.getName());
    }

    @Test
    @DisplayName("when create brand with id = 2 then return Pull&Bear Brand")
    void createPullAndBearTest() {
        Brand brand = Brand.create(2);
        assertEquals(2, brand.getId());
        assertEquals("Pull&Bear", brand.getName());
    }

   @Test
    @DisplayName("when create brand with id = 3 then return Massimo Dutti Brand")
    void createMassimoDuttiTest() {
        Brand brand = Brand.create(3);
        assertEquals(3, brand.getId());
        assertEquals("Massimo Dutti", brand.getName());
    }

    @Test
    @DisplayName("when create brand with id = 4 then return Bershka Brand")
    void createBershkaTest() {
        Brand brand = Brand.create(4);
        assertEquals(4, brand.getId());
        assertEquals("Bershka", brand.getName());
    }

    @Test
    @DisplayName("when create brand with id = 5 then return Stradivarius Brand")
    void createStradivariusTest() {
        Brand brand = Brand.create(5);
        assertEquals(5, brand.getId());
        assertEquals("Stradivarius", brand.getName());
    }

    @Test
    @DisplayName("when create brand with id = 6 then return Oysho Brand")
    void createOyshoTest() {
        Brand brand = Brand.create(6);
        assertEquals(6, brand.getId());
        assertEquals("Oysho", brand.getName());
    }

    @Test
    @DisplayName("when create brand with id = 7 then return Zara Home Brand")
    void createZaraHomeTest() {
        Brand brand = Brand.create(7);
        assertEquals(7, brand.getId());
        assertEquals("Zara Home", brand.getName());
    }

    @Test
    @DisplayName("when create brand with id = 8 then return Uterqüe Brand")
    void createUterqüeTest() {
        Brand brand = Brand.create(8);
        assertEquals(8, brand.getId());
        assertEquals("Uterqüe", brand.getName());
    }

}