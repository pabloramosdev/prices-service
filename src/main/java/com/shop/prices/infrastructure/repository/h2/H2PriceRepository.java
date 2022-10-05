package com.shop.prices.infrastructure.repository.h2;

import com.shop.prices.domain.Brand;
import com.shop.prices.domain.Price;
import com.shop.prices.domain.ProductId;
import com.shop.prices.domain.repository.PriceRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class H2PriceRepository implements PriceRepository {

    private final SpringDataH2PriceRepository springDataH2PriceRepository;

    public H2PriceRepository(SpringDataH2PriceRepository springDataH2PriceRepository) {
        this.springDataH2PriceRepository = springDataH2PriceRepository;
    }

    @Override
    public List<Price> findPriceBetweenDates(Brand brand, ProductId productId, LocalDateTime applicationDate) {
        return springDataH2PriceRepository.findPriceBetweenDates(brand.getId(), productId.getId(), applicationDate)
                .stream()
                .map(PriceEntity::toDomain)
                .collect(Collectors.toList());
    }
}
