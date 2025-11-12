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


    public String getReceiptContent() {
        StringBuilder receipt = new StringBuilder();

        // === HEADER ===
        receipt.append("\n=================  DELICIOUS SANDWICHES  =================\n");
        receipt.append("Date: ").append(orderTime.format(DateTimeFormatter.ofPattern("MMM dd, yyyy  hh:mm a"))).append("\n");
        receipt.append("-----------------------------------------------------------\n");

        // for the sandwiches
        boolean hasSandwiches = false;
        for (ProdcutOrder p : products) {
            if (p instanceof Sandwich) {
                if (!hasSandwiches) {
                    receipt.append("Sandwiches:\n");
                    receipt.append("-----------------------------------------------------------\n");
                    hasSandwiches = true;
                }
                receipt.append(String.format("  %-35s $%5.2f\n", p.getDescription(), p.getPrice()));
            }
        }



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

