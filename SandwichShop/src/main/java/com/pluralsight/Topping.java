package com.pluralsight;

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
        String cat = (category == null) ? "" : category.toLowerCase();

        switch (cat) {
            case "meat": {
                double base;
                double extra;

                if (length == 4) {
                    base = 1.00;
                    extra = 0.50;
                } else if (length == 8) {
                    base = 2.00;
                    extra = 1.00;
                } else {
                    base = 3.00;
                    extra = 1.50;
                }

                return base + extra * Math.max(0, isExtraCount);
            }

            case "cheese": {
                double base;
                double extra;

                if (length == 4) {
                    base = 0.75;
                    extra = 0.30;
                } else if (length == 8) {
                    base = 1.50;
                    extra = 0.60;
                } else {
                    base = 2.25;
                    extra = 0.90;
                }

                return base + extra * Math.max(0, isExtraCount);
            }

            default:
                return 0.0;
        }

}

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", isExtraCount=" + isExtraCount +
                '}';
    }
}
