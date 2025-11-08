package com.pluralsight;

public class Drink extends ProdcutOrder{
    private String size;
    private String flavor;

    public Drink(String name, double price, String size, String flavor) {
//        super(name, price);
        super(name);
        this.size = size;
        this.flavor = flavor;
        this.setPrice(calculatePrice());  //compute price based on drink size
    }

    @Override
    public String getDescription() {
        return size + " " + flavor + " drink";
    }

    @Override
    public double calculatePrice() {
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
        setPrice(calculatePrice());
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
