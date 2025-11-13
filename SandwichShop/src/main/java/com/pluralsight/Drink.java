package com.pluralsight;

public class Drink extends ProdcutOrder{
    private String size;
    private String flavor;

    public Drink(String name, String size, String flavor) {
        super(name);
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public String getDescription() {
        return size + " " + flavor + " drink";
    }

    @Override
    public double getPrice() {
        switch (size.toLowerCase()){
            case "small": return 2.00;
            case "medium": return 2.50;
            case "large": return 3.00;
            default: return 0.0;
        }
    }


//    private double getSizePrice(String size){
//        return switch(size.toLowerCase()) {
//            case "small" -> 2.00;
//            case "medium" -> 2.50;
//            case "large" -> 3.00;
//            default -> 0.0;
//        };
//    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
//        setPrice(getPrice());
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        if (getDescription() == null || getDescription().trim().isEmpty() || getPrice() == 0.0) {
            return "Invalid drink: missing size or flavor. Please select both before confirming.";
        }

        return getDescription() + String.format(" | $%.2f", getPrice());
    }

}
