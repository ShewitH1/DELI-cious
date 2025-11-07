package com.pluralsight;

public class AddDrink {
    public static void drink_screen(){
        String drink_screen_option = """
                *-------- DELICIOUS sandwiches --------*
                -------------Add Drink Menu-------------
                ~ Select Drink Size and Flavor         -
                 1 ) Small  ($2.00)                   -
                 2 ) Medium ($2.50)                   -
                 3 ) Large  ($3.00)                   -
                 4 ) Choose Drink Flavor              -
                 5 ) Confirm Drink                    -
                 0 ) Cancel and Return to Order Screen -
                ----------------------------------------
                """;

        int command = -1;
        while(command != 0){
            System.out.println(drink_screen_option);
            command = ConsoleHelper.promptForInt("Choose an option: ");

            switch (command) {
                case 1:
                case 2:
                case 3:
                    // Set Drink Size
                    break;
                case 4:
                    // Choose Drink Flavor
                    break;
                case 5:
                    // Confirm Drink
                    System.out.println("Drink added successfully!");
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
