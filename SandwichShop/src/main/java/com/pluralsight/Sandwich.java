package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends ProdcutOrder{
    private String bread;
    private int length;
    private boolean toasted;
//    private double pricee;
    private List<Topping> toppings = new ArrayList<>();


    public Sandwich(String name, String bread, int length, boolean toasted) {
        super(name);
        this.bread = bread;
        this.length = length;
        this.toasted = toasted;
//        this.pricee = calculate_size_price(length); //calculates price based on sizes
        this.setPrice(calculatePrice());
    }

//    @Override
//    public double calculatePrice() {
//        double basePrice = switch (length) {
//            case 4 -> 5.50;
//            case 8 -> 7.00;
//            case 12 -> 8.50;
//            default -> 0.0;
//        };
//
//        for(Topping topping : toppings){
//            basePrice += topping.getPriceForSize(length);
//
//        }
//
//        //set the compound price on object
//        this.setPrice(basePrice);
//        return basePrice;
//    }

    private double basePriceBySize(int len) {
        return switch (len) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };
    }
    private double meatPriceBySize(int len) {
        return switch (len) {
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 0.0;
        };
    }
    private double extraMeatBySize(int len) {
        return switch (len) {
            case 4 -> 0.50;
            case 8 -> 1.00;
            case 12 -> 1.50;
            default -> 0.0;
        };
    }
    private double cheesePriceBySize(int len) {
        return switch (len) {
            case 4 -> 0.75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0.0;
        };
    }
    private double extraCheeseBySize(int len) {
        return switch (len) {
            case 4 -> 0.30;
            case 8 -> 0.60;
            case 12 -> 0.90;
            default -> 0.0;
        };
    }

    @Override
    public double calculatePrice() {
        double total = basePriceBySize(length);
        // Regular toppings/sauces/sides are included ($0)
        // Meats & cheeses are premium; extras add a surcharge
        for (Topping t : toppings) {
            String cat = t.getCategory().toLowerCase();

            if (cat.equals("meat")) {
                total += meatPriceBySize(length);
                if (t.getIsExtraCount() > 0) {
                    total += extraMeatBySize(length) * t.getIsExtraCount();
                }
            } else if (cat.equals("cheese")) {
                total += cheesePriceBySize(length);
                if (t.getIsExtraCount() > 0) {
                    total += extraCheeseBySize(length) * t.getIsExtraCount();
                }
            }
            // "regular", "sauce", "side" => included, no charge
        }
        return total;
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

    public void addTopping(Topping topping){
        toppings.add(topping);
    }

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
