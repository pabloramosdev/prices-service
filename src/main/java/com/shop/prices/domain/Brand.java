package com.shop.prices.domain;

public enum Brand {
    ZARA(1, "ZARA"),
    PULL_AND_BEAR(2, "Pull&Bear"),
    MASSIMO_DUTTI(3, "Massimo Dutti"),
    BERSHKA(4, "Bershka"),
    STRADIVARIUS(5, "Stradivarius"),
    OYSHO(6, "Oysho"),
    ZARA_HOME(7, "Zara Home"),
    UTERQUE(8, "Uterqüe");

    private final Integer id;
    private final String name;

    Brand(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Brand findById(Integer id) {
        Brand brand;
        switch (id) {
            case 2:
                brand = PULL_AND_BEAR;
                break;
            case 3:
                brand = MASSIMO_DUTTI;
                break;
            case 4:
                brand = BERSHKA;
                break;
            case 5:
                brand = STRADIVARIUS;
                break;
            case 6:
                brand = OYSHO;
                break;
            case 7:
                brand = ZARA_HOME;
                break;
            case 8:
                brand = UTERQUE;
                break;
            default:
                brand = ZARA;
        }
        return brand;
    }
    
}
