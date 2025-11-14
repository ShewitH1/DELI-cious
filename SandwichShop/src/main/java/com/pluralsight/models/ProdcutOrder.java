package com.pluralsight.models;

public abstract class ProdcutOrder {
    private String name;

    public ProdcutOrder(String name) {
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
