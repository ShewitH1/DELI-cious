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

//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }

    //Each subclass - Sandwich, Drink, Chips - will override this
    public abstract String getDescription();

    //create abstract for calculate
//    public abstract double calculatePrice();

    public abstract double getPrice();

}
