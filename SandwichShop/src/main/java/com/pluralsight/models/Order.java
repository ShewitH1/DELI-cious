package com.pluralsight.models;

import com.pluralsight.data.ReceiptBuilder;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class Order {

    private ArrayList<ProductOrder> products = new ArrayList<>();
    private LocalDateTime orderTime;
    private String receiptFileName;
    private static int orderCounter = 0;

    public Order() {
        orderCounter++;
        this.orderTime = LocalDateTime.now();
        // Create folder name and timestamped filename
        this.receiptFileName = "receipts/" + orderTime.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-")) + orderCounter + ".txt";
    }

    //Add products
    public void addProduct(ProductOrder product) {
        products.add(product);
    }

    //Calculate total price
    public double getTotal() {
        double total = 0.0;
        for (ProductOrder p : products) {
            total += p.getPrice();
        }
        return total;
    }

    //This will print receipt to console
    public void printReceipt() {
        System.out.println(ReceiptBuilder.getReceiptContent(this));
    }


    public ArrayList<ProductOrder> getProducts() {
        return products;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }


    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public String getReceiptFileName() {
        return receiptFileName;
    }
}

