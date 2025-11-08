package com.pluralsight;

public class Chips extends ProdcutOrder {
    private String flavor;

    public Chips(String name, double price, String flavor) {
//        super(name, price);
        super(name);
        this.flavor = flavor;
        this.setPrice(calculatePrice());
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
    public double calculatePrice() {
        return 1.50;
    }
}
