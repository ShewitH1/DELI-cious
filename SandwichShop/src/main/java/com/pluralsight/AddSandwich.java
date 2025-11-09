package com.pluralsight;

import java.util.ArrayList;

public class AddSandwich {

    public static Sandwich sandwich_screen(){
        //empty - default data
        String bred = " ";
        int length = 0;
        boolean toasted = false;

        //add arraylists here
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<Topping> sauces = new ArrayList<>();

        //empty - null sandwich object
        Sandwich sandwich = null;

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
                    break;
                case 0:
                    System.out.println("Returning to Order Screen...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        return sandwich;
    }

    private static String selectBread(){
        String bread = ConsoleHelper.promptForString("Choose bread (White / Wheat / Rye / Wrap)").toLowerCase();
        System.out.println("Bread selected: " + bread);

        return bread;
    }

    private static int selectSize(){
        int size = ConsoleHelper.promptForInt("Choose sandwich size (4, 8, or 12 inches)");
        if (size != 4 && size != 8 && size != 12) {
            System.out.println("Invalid size. Please choose 4, 8, or 12.");
            return 0;
        }
        System.out.println("Size selected: " + size + " inch");
        return size;
    }

    private static void addToppings(ArrayList<Topping> toppings){
        System.out.println("\n Meats: steak, ham, salami, roast beef, chicken, bacon");
        System.out.println("Cheeses: american, provolone, cheddar, swiss");
        System.out.println("Regular: lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, mushrooms, guacamole\n");

    }

    private static void addSauces(ArrayList<Topping> sauces){

    }

    private static boolean toastedOption(){

        return true;
    }

    private static Sandwich confirmSandwich(){
        return null;
    }

}

