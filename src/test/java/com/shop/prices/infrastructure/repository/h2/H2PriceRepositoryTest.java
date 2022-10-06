package com.shop.prices.infrastructure.repository.h2;

import com.shop.prices.domain.Price;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.shop.prices.utils.PriceUtils.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackageClasses = H2PriceRepository.class)
class H2PriceRepositoryTest {

    @Autowired
    private H2PriceRepository h2PriceRepository;

    @Autowired
    private SpringDataH2PriceRepository springDataH2PriceRepository;

    @BeforeEach
    public void setUp() {
        springDataH2PriceRepository.save(PRICE_ENTITY);
    }
    @AfterEach
    public void tearOff() {
        springDataH2PriceRepository.delete(PRICE_ENTITY);
    }

    @Test
    void findPriceBetweenDates() {
        List<Price> prices = h2PriceRepository.findPriceBetweenDates(ZARA, PRODUCT_ID, dateTime);
        assertNotNull(prices);
        assertEquals(1, prices.size());
        assertEqualsPrice(PRICE, prices.get(0));
    }
}