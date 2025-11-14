package com.pluralsight.data;

import com.pluralsight.models.*;

import java.time.format.DateTimeFormatter;

public class ReceiptBuilder {

    public static String getReceiptContent(Order order) {
        StringBuilder receipt = new StringBuilder();

        // this is header
        receipt.append("\n=================  DELICIOUS SANDWICHES  =================\n");
        receipt.append("Date: ").append(order.getOrderTime().format(DateTimeFormatter.ofPattern("MMM dd, yyyy  hh:mm a"))).append("\n");
        receipt.append("-----------------------------------------------------------\n");

        // for the sandwiches
        boolean hasSandwiches_value = false;
        for (int i = 0; i < order.getProducts().size(); i++) {
            ProductOrder p = order.getProducts().get(i);
            if (!hasSandwiches_value) {
                receipt.append("Sandwiches:\n");
                receipt.append("-----------------------------------------------------------\n");
                hasSandwiches_value = true;
            }
            receipt.append(String.format("  %-35s $%5.2f\n", p.getDescription(), p.getPrice()));

                //this is for toppings
                Sandwich s = (Sandwich) p;
                if (!s.getToppings().isEmpty()) {
                    receipt.append("   Toppings: ");
                    for (Topping t : s.getToppings()) {
                        receipt.append(t.getName()).append(", ");
                    }
                    // remove last comma and space
                    receipt.setLength(receipt.length() - 2);
                    receipt.append("\n");

                }

        }// for the drinks
        boolean hasDrinks_value = false;
        for(int i = 0; i<order.getProducts().size(); i++){
            ProductOrder p = order.getProducts().get(i);
            if (p instanceof Drink) {
                if (!hasDrinks_value) {
                    receipt.append("\nDrinks:\n");
                    receipt.append("-----------------------------------------------------------\n");
                    hasDrinks_value = true;
                }
                receipt.append(String.format("  %-35s $%5.2f\n", p.getDescription(), p.getPrice()));
            }
        }

        // for the chips
        boolean hasChips = false;

        for(int i = 0; i<order.getProducts().size(); i++){
            ProductOrder p = order.getProducts().get(i);
            if (p instanceof Chips) {
                if (!hasChips) {
                    receipt.append("\nChips:\n");
                    receipt.append("-----------------------------------------------------------\n");
                    hasChips = true;
                }
                receipt.append(String.format("  %-35s $%5.2f\n", p.getDescription(), p.getPrice()));
            }
        }

        //just give a summary nothing else lol
        double total_value = order.getTotal();

        receipt.append("-----------------------------------------------------------\n");
        receipt.append(String.format("%-40s $%5.2f\n", "Total:", total_value));
        receipt.append("-----------------------------------------------------------\n");

        //this is for the footer
        receipt.append("Thank you for visiting Delicious Sandwiches!\n");
        receipt.append("We appreciate your business — come back soon!\n");
        receipt.append("===========================================================\n");


        return receipt.toString();
    }

}
