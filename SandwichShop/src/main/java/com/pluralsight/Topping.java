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

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", isExtraCount=" + isExtraCount +
                '}';
    }
}
