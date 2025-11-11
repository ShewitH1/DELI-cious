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
//            total += p.getPrice();
            total += p.calculatePrice();
        }
        return total;
    }


//    public void printReceipt() {
//        System.out.println("Your Order:");
//        for (ProdcutOrder p : products) {
//            System.out.println("- " + p.getDescription() +  " ($" + String.format("%.2f", p.getPrice()) + ")");
//        }
//        System.out.println("Total: $" + String.format("%.2f", getTotal()));
//    }

    //might add toppings and sauces to reciept
    public void printReceipt(){
        System.out.println("Your Order: ");
//        for(ProdcutOrder p : products){
//            if (p instanceof Sandwich){
//                System.out.println(p.getDescription() + " ($" + String.format("%.2f", p.calculatePrice()) + ")");
//            } else if (p instanceof Drink) {
//                System.out.println(p.getDescription() + " ($" + String.format("%.2f", p.calculatePrice()) + ")");
//            }
//            else if (p instanceof Chips){
//                System.out.println(p.getDescription() + " ($" + String.format("%.2f", p.calculatePrice()) + ")");
//            }
//        }

// matt's version...
        for(ProdcutOrder p : products){
            System.out.println(p.getDescription() + " ($" + String.format("%.2f", p.calculatePrice()) + ")");
        }

        System.out.println("Total: $" + String.format("%.2f", getTotal()));
    }

    public ArrayList<ProdcutOrder> getProducts() {
        return products;
    }

    public boolean isEmpty(){
        return products.isEmpty();
    }
}
