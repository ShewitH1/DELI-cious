package com.pluralsight;

public class AddSandwich {

    public static void sandwich_screen(){
        String sandwich_screen_options = """
                *-------- DELICIOUS sandwiches --------*
                -----------Add Sandwich Menu------------
                ~ Select your options below             -
                 1 ) Select Bread Type                 -
                 2 ) Select Sandwich Size              -
                 3 ) Add Toppings                      -
                 4 ) Add Sauces                        -
                 5 ) Toasted?                          -
                 6 ) Confirm Sandwich                  -
                 0 ) Cancel and Return to Order Screen -
                ----------------------------------------
                """;

        int command = -1;
        while(command != 0){
            System.out.println(sandwich_screen_options);
            command = ConsoleHelper.promptForInt("Choose an option: ");

            switch (command) {
                case 1:
                    // Select Bread Type
                    break;
                case 2:
                    // Select Sandwich Size
                    break;
                case 3:
                    // Add Toppings
                    break;
                case 4:
                    // Add Sauces
                    break;
                case 5:
                    // Toasted?
                    break;
                case 6:
                    // Confirm Sandwich
                    System.out.println("Sandwich added successfully!");
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
