package com.shop.prices.infrastructure.repository.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SpringDataH2PriceRepository extends JpaRepository<PriceEntity, Integer> {

    @Query("select price from PriceEntity price where price.brandId = :brand AND price.productId = :product AND " +
            "price.startDate <= :date AND  price.endDate >= :date")
    List<PriceEntity> findPriceBetweenDates(@Param("brand") Integer brandId, @Param("product") Integer productId, @Param("date") LocalDateTime applicationDate);

}
