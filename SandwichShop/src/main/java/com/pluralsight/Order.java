package com.pluralsight;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Order {

    private ArrayList<ProdcutOrder> products = new ArrayList<>();
    private LocalDateTime orderTime;
    private String receiptFileName;
    private static int orderCounter = 0;

    public Order() {
        this.orderTime = LocalDateTime.now();
        orderCounter++;
        // Create folder name and timestamped filename
        this.receiptFileName = "receipts/" + orderTime.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-")) + orderCounter + ".txt";
    }

    //Add products
    public void addProduct(ProdcutOrder product) {
        products.add(product);
    }

    //Calculate total price
    public double getTotal() {
        double total = 0.0;
        for (ProdcutOrder p : products) {
            total += p.getPrice();
        }
        return total;
    }

    //generate receipt text
    public String getReceiptContent() {
        StringBuilder receipt = new StringBuilder("🧾━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🧾\n");
        receipt.append("Date: ").append(orderTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n\n");

        // Sandwiches
        boolean hasSandwiches = false;
        for (ProdcutOrder p : products) {
            if (p instanceof Sandwich) {
                if (!hasSandwiches) {
                    receipt.append("Sandwiches:\n");
                    hasSandwiches = true;
                }
                receipt.append("  - ").append(p).append("\n");
            }
        }

        // Drinks
        boolean hasDrinks = false;
        for (ProdcutOrder p : products) {
            if (p instanceof Drink) {
                if (!hasDrinks) {
                    receipt.append("Drinks:\n");
                    hasDrinks = true;
                }
                receipt.append("  - ").append(p).append("\n");
            }
        }

        // Chips
        boolean hasChips = false;
        for (ProdcutOrder p : products) {
            if (p instanceof Chips) {
                if (!hasChips) {
                    receipt.append("Chips:\n");
                    hasChips = true;
                }
                receipt.append("  - ").append(p).append("\n");
            }
        }

        // Total section
        receipt.append(String.format("\nTotal: $%.2f\n", getTotal()));
        receipt.append("🧾━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━🧾\n");

        return receipt.toString();
    }

    //This will print receipt to console
    public void printReceipt() {
        System.out.println(getReceiptContent());
    }


    public ArrayList<ProdcutOrder> getProducts() {
        return products;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public String getReceiptFileName() {
        return receiptFileName;
    }
}

