package com.pluralsight.userinterface;

import com.pluralsight.userinterface.ConsoleHelper;

import com.pluralsight.models.Drink;

import java.util.Arrays;

public class AddDrinkScreen {
    public static Drink drink_screen(){

        //make sure I add initializing  data - reservation
        String size = " ";
        String flavor = " ";

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
                    //size for small
                    size = processSelectSize("small");

                    break;
                case 2:
                    //size for medium
                    size = processSelectSize("medium");

                    break;
                case 3:
                    //size for large
                    size = processSelectSize("large");
                    break;
                case 4:
                    // Choose Drink Flavor
                    flavor = processSelectFlavor();
                    break;
                case 5:
                    // Confirm Drink
                    Drink drink = processConfirmDrink(size, flavor);
                    if(drink != null){
                        return drink;
                    }
                    else{
                        break;
                    }
                case 0:
                    processCancel();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        return null;
    }

    //I added helper methods here
    private static String processSelectSize(String sizeChoice){
        System.out.println("Size selected: " + sizeChoice);

        return sizeChoice;
    }

    //add actual soda options
    private static String processSelectFlavor(){

        String[] flavors = {"coke", "sprite", "root beer", "dr pepper", "lemonade", "water"};

        System.out.println("Available Drink Flavors: ");
        for(int i = 0; i<flavors.length; i++){
            System.out.println(" - " + flavors[i]);
        }

        String flavor = " ";

        while(true){
            flavor = ConsoleHelper.promptForString("Enter drink flavor (or 'cancel' to go back)").toLowerCase();

            if(flavor.equals("cancel")){
                System.out.println("Returning to Add Drink Menu...");
                return "";
            }

            if(Arrays.asList(flavors).contains(flavor)){
                System.out.println("Flavor selected: " + flavor);
                return flavor;
            }
            else{
                System.out.println("Invalid flavor. Please choose from the list above.");
            }
        }

    }

    private static Drink processConfirmDrink(String size, String flavor){
        if (size == null || size.trim().isEmpty() || flavor == null || flavor.trim().isEmpty()) {
            System.out.println("Please select both size and flavor before confirming!");
            return null;
        }
        Drink drink = new Drink("Drink", size, flavor);
//        System.out.println("Drink added: " + drink);
        System.out.println(drink);
        return drink;
    }

    private static void processCancel(){
        System.out.println("Returning to Order Screen...");

    }
}
