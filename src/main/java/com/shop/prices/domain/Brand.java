package com.shop.prices.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Brand {
    private static final Map<Integer, String> brandMap = new HashMap<>();

    static {
        brandMap.put(1, "ZARA");
        brandMap.put(2, "Pull&Bear");
        brandMap.put(3, "Massimo Dutti");
        brandMap.put(4, "Bershka");
        brandMap.put(5, "Stradivarius");
        brandMap.put(6, "Oysho");
        brandMap.put(7, "Zara Home");
        brandMap.put(8, "Uterqüe");
    }

    private final Integer id;
    private final String name;

    private Brand(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(id, brand.id) && Objects.equals(name, brand.name);
    }

    public static Brand create(Integer brandId) {
        String name = brandMap.get(brandId);
        return new Brand(brandId, name);
    }
}
