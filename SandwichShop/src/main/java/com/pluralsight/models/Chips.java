package com.pluralsight.models;

public class Chips extends ProductOrder {
    private String flavor;

    public Chips(String name,  String flavor) {
        super(name);
        this.flavor = flavor;

    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }


    @Override
    public String getDescription() {
        return flavor + " Chips";
    }

    //chips price is always 1.50
    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        if (getDescription() == null || getDescription().trim().isEmpty()) {
            return "Invalid chips: missing flavor. Please select before confirming.";
        }

        return getDescription() + String.format(" | $%.2f", getPrice());
    }
}
