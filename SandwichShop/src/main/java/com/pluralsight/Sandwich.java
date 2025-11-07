package com.pluralsight;

public class Sandwich extends ProdcutOrder{
    private String bread;
    private int length;
    private boolean toasted;
//    private double pricee;

    public Sandwich(String name, double price, String bread, int length, boolean toasted, double pricee) {
        super(name);
        this.bread = bread;
        this.length = length;
        this.toasted = toasted;
//        this.pricee = calculate_size_price(length); //calculates price based on sizes
        this.setPrice(calculatePrice());
    }

    @Override
    public double calculatePrice() {
        return switch (length) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };
    }


//    private double calculate_size_price(int length){
//        if(length == 4){
//            return 5.50;
//        }
//        else if ( length == 8) {
//            return 7.00;
//        }
//        else if(length == 12){
//            return 8.50;
//        }
//        else{
//            return 0.0;
//        }
//    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
        setPrice(calculatePrice());
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
        setPrice(calculatePrice());
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public String getDescription() {
        return length + " inch " + bread + " sandwich" + (toasted ? " (toasted)" : "");
    }
}
