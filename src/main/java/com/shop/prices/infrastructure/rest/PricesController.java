package com.shop.prices.infrastructure.rest;

import com.shop.prices.application.QueryPriceByPriority;
import com.shop.prices.domain.exception.PriceNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@RestController
public class PricesController {

    private final QueryPriceByPriority queryPriceByPriority;

    public PricesController(QueryPriceByPriority queryPriceByPriority) {
        this.queryPriceByPriority = queryPriceByPriority;
    }

    @GetMapping(value = "/prices")
    public ResponseEntity<PriceResponse> getPricesByPriority(@RequestParam("brand_id") @Positive Integer brandId,
                                                   @RequestParam("product_id") @Positive Integer productId,
                                                   @RequestParam("application_date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applicationDate) {
        return ResponseEntity.ok(queryPriceByPriority.findPriceByPriority(brandId, productId, applicationDate));
    }

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Void> handleNotFound() {
        return ResponseEntity.notFound().build();
    }

}
