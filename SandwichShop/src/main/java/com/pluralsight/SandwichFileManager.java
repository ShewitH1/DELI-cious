package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SandwichFileManager {

    public void SaveSandwichReceipt(Order order) {
        try {
            // Create receipts folder if it doesn’t exist
            File directory = new File("receipts");
            if (!directory.exists()) {
                directory.mkdir();
            }

            // Write receipt text to file
            FileWriter writer = new FileWriter(order.getReceiptFileName());
            writer.write(order.getReceiptContent());
            writer.close();

            System.out.println("Receipt saved to: " + order.getReceiptFileName());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error! Could not save/create receipt file.");
        }
    }
}
