package com.pluralsight;

public class Chips extends ProdcutOrder {
    private String flavor;

    public Chips(String name, double price, String flavor) {
        super(name, price);
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
}
