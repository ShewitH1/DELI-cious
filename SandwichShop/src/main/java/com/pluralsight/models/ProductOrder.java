package com.pluralsight.models;

public abstract class ProductOrder {
    private String name;

    public ProductOrder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Each subclass - Sandwich, Drink, Chips - will override this
    public abstract String getDescription();

    public abstract double getPrice();

}
