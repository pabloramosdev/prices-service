package com.shop.prices.infrastructure.configuration;

import com.shop.prices.application.QueryPriceByPriority;
import com.shop.prices.domain.repository.PriceRepository;
import com.shop.prices.domain.service.PriceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanDeclaration {

    @Bean
    public QueryPriceByPriority queryPriceByPriority(final PriceService priceService) {
        return new QueryPriceByPriority(priceService);
    }
    @Bean
    public PriceService priceService(final PriceRepository priceRepository) {
        return new PriceService(priceRepository);
    }

}
