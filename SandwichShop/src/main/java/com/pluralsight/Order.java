package com.pluralsight;

import java.util.ArrayList;

public class Order {
    private ArrayList<ProdcutOrder> products = new ArrayList<>();

    public void addProduct(ProdcutOrder product){
        products.add(product);
    }

    //get total method
    public double getTotal() {
        double total = 0.0;
        for (ProdcutOrder p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("Your Order:");
        for (ProdcutOrder p : products) {
            System.out.println("- " + p.getDescription() + " ($" + p.getPrice() + ")");
        }
        System.out.println("Total: $" + getTotal());
    }
}
