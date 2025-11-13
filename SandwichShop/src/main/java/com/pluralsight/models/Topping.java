package com.pluralsight.models;

public class Topping {

    private String name;
    private String category;
    private int isExtraCount;

    public Topping(String name, String category, int isExtraCount) {
        this.name = name;
        this.category = category;
        this.isExtraCount = isExtraCount;
    }

    public Topping(String name, String category) {
        this(name, category, 0);

    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getIsExtraCount() {
        return isExtraCount;
    }


    //returns total price for this toppings of sandwich
    //Regular toppings and sauces are free
//    public double getPriceForSize(int length) {
//        String cat = category == null ? "" : category.toLowerCase();
//
//        switch (cat) {
//            case "meat": {
//                double base = switch (length) {
//                    case 4 -> 1.00;
//                    case 8 -> 2.00;
//                    case 12 -> 3.00;
//                    default -> 0.0;
//                };
//                double extra = switch (length) {
//                    case 4 -> 0.50;
//                    case 8 -> 1.00;
//                    case 12 -> 1.50;
//                    default -> 0.0;
//                };
//                return base + extra * Math.max(0, isExtraCount);
//            }
//            case "cheese": {
//                double base = switch (length) {
//                    case 4 -> 0.75;
//                    case 8 -> 1.50;
//                    case 12 -> 2.25;
//                    default -> 0.0;
//                };
//                double extra = switch (length) {
//                    case 4 -> 0.30;
//                    case 8 -> 0.60;
//                    case 12 -> 0.90;
//                    default -> 0.0;
//                };
//                return base + extra * Math.max(0, isExtraCount);
//            }
//            // regular toppings, sauces, sides are included
//            default:
//                return 0.0;
//        }

    public double getPriceForSize(int length) {
        String cat = category == null ? "" : category.toLowerCase();
        switch (cat) {
            case "meat": {
                double base = length == 4 ? 1.00 : length == 8 ? 2.00 : 3.00;
                double extra = length == 4 ? 0.50 : length == 8 ? 1.00 : 1.50;
                return base + extra * Math.max(0, isExtraCount);
            }
            case "cheese": {
                double base = length == 4 ? 0.75 : length == 8 ? 1.50 : 2.25;
                double extra = length == 4 ? 0.30 : length == 8 ? 0.60 : 0.90;
                return base + extra * Math.max(0, isExtraCount);
            }
            default:
                return 0.0;
        }
    }

    @Override
    public String toString() {
        String extra = isExtraCount > 0 ? " (extra x" + isExtraCount + ")" : "";
        return name + " [" + category + "]" + extra;
    }
}
