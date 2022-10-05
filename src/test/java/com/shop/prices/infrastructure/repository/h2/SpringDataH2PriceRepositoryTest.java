package com.shop.prices.infrastructure.repository.h2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static com.shop.prices.utils.PriceUtils.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class SpringDataH2PriceRepositoryTest {

    @Autowired
    private SpringDataH2PriceRepository springDataH2PriceRepository;

    @BeforeEach
    public void setUp() {
        springDataH2PriceRepository.save(PRICE_ENTITY);
    }

    @Test
    void findPriceBetweenDates() {
        List<PriceEntity> prices = springDataH2PriceRepository.findPriceBetweenDates(ZARA, PRODUCT_ID, LocalDateTime.now());
        assertNotNull(prices);
        assertEquals(1, prices.size());
        assertEqualsPriceEntity(PRICE_ENTITY, prices.get(0));
    }
}