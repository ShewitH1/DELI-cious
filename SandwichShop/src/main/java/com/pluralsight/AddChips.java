package com.pluralsight;

public class AddChips {
    public static void chips_screen(){
        String chips_screen_options = """
                *-------- DELICIOUS sandwiches --------*
                --------------Add Chips Menu------------
                ~ Select Chip Type                     -
                 1 ) Classic                           -
                 2 ) BBQ                               -
                 3 ) Sour Cream & Onion                -
                 4 ) Confirm Chips                     -
                 0 ) Cancel and Return to Order Screen -
                ----------------------------------------
                """;

        int command = -1;
        while(command != 0){
            System.out.println(chips_screen_options);
            command = ConsoleHelper.promptForInt("Choose an option: ");

            switch (command) {
                case 1:
                case 2:
                case 3:
                    // Set Chip Type
                    break;
                case 4:
                    // Confirm Chips
                    System.out.println("Chips added successfully!");
                    return;
                case 0:
                    System.out.println("Returning to Order Screen...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
