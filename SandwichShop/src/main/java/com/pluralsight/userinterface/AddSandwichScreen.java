package com.pluralsight.userinterface;

import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;
import com.pluralsight.userinterface.ConsoleHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class AddSandwichScreen {

    public static Sandwich sandwich_screen(){
        //make sure I add initializing - default data - reservation
        String bread = " ";
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
                    bread = selectBread();
                    break;
                case 2:
                    // Select Sandwich Size
                    length = selectSize();
                    break;
                case 3:
                    // Add Toppings
                    addToppings(toppings);
                    break;
                case 4:
                    // Add Sauces
                    addSauces(sauces);
                    break;
                case 5:
                    // Toasted?
                    toasted = toastedOption();
                    break;
                case 6:
                    // Confirm Sandwich
                    sandwich = confirmSandwich(bread, length, toasted, toppings, sauces);
                    if (sandwich != null){
                        return  sandwich;
                    }
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

    //corrected the user errors here -     //good to go
    private static String selectBread(){
//        String bread = ConsoleHelper.promptForString("Choose bread (White / Wheat / Rye / Wrap)").toLowerCase();
//        System.out.println("Bread selected: " + bread);
//
//        return bread;

        //ask should i add it into array or not
        //made a loop instead - teacher recommendation
        String bread;
        while(true){
            bread = ConsoleHelper.promptForString("Choose bread (White / Wheat / Rye / Wrap)").toLowerCase();

            String[] breadOptions = { "White", "Wheat", "Rye", "Wrap"};
            String finalBread = bread;
            boolean isBreadInBreadOptions =  Arrays.stream(breadOptions).anyMatch(option -> option.equalsIgnoreCase(finalBread));
            if (isBreadInBreadOptions){
                System.out.println("Bread Selected: " + bread);
                return bread;
            }
            else {
                System.out.println("Invalid choice. Please choose from White, Wheat, Rye, or Wrap.");
            }
        }
    }

    //corrected the user errors here -    good to go
    private static int selectSize(){
//        int size = ConsoleHelper.promptForInt("Choose sandwich size (4, 8, or 12 inches)");
//        if (size != 4 && size != 8 && size != 12) {
//            System.out.println("Invalid size. Please choose 4, 8, or 12.");
//            return selectSize(); //ask professor about this
//        }
//        System.out.println("Size selected: " + size + " inch");
//        return size;

        //made a loop instead - teacher recommendation
        int size;

        while(true) {
            size = ConsoleHelper.promptForInt("Choose sandwich size (4, 8, or 12 inches)");

            if (size == 4 || size == 8 || size == 12) {
                System.out.println("Size selcted: " + size + " inch");
                return size;
            } else {
                System.out.println("Invalid size. Please choose 4, 8, or 12.");
            }
        }
    }

    //good to go
    private static void addToppings(ArrayList<Topping> toppings){
//        System.out.println("Meats: steak, ham, salami, roast beef, chicken, bacon");
//        System.out.println("Cheeses: american, provolone, cheddar, swiss");
//        System.out.println("Regular: lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, mushrooms, guacamole\n");
//
//        while(true){
//            String toppingName = ConsoleHelper.promptForString("Enter topping (or 'done' to finish)");
//            if (toppingName.equalsIgnoreCase("done")) {
//                break;
//            }
//
//            String category = ConsoleHelper.promptForString("Enter category (meat / cheese / regular)").toLowerCase();
//            int extra = 0;
//            if (category.equals("meat") || category.equals("cheese")) {
//                extra = ConsoleHelper.promptForInt("Extra portions? (0 for none)");
//            }
//
//            Topping topping = new Topping(toppingName, category, extra);
//            toppings.add(topping);
//            System.out.println("Added: " + toppingName + " (" + category + ")");
//        }

        //added arrays instead - similar functionality
        String[] meats = {"steak", "ham", "salami", "roast beef", "chicken", "bacon"};
        String[] cheeses = {"american", "provolone", "cheddar", "swiss"};
        String[] regulars = {"lettuce", "peppers", "onions", "tomatoes", "jalapeños", "cucumbers", "pickles", "mushrooms", "guacamole"};

        System.out.println("Available toppings:");
        System.out.println("Meats: " + String.join(", ", meats));
        System.out.println("Cheeses: " + String.join(", ", cheeses));
        System.out.println("Regular: " + String.join(", ", regulars));
        System.out.println();

        while (true) {
            String toppingName = ConsoleHelper.promptForString("Enter topping (or 'done' to finish)").toLowerCase();
            if (toppingName.equals("done")) {
                break;
            }

            // Check which category it belongs to
            String category = null;
            if (Arrays.asList(meats).contains(toppingName)) {
                category = "meat";
            } else if (Arrays.asList(cheeses).contains(toppingName)) {
                category = "cheese";
            } else if (Arrays.asList(regulars).contains(toppingName)) {
                category = "regular";
            } else {
                System.out.println("Invalid topping. Please choose from the available list.");
                continue; // ask again
            }

            int extra = 0;
            if (category.equals("meat") || category.equals("cheese")) {
                extra = ConsoleHelper.promptForInt("Extra portions? (0 for none)");
            }

            Topping topping = new Topping(toppingName, category, extra);
            toppings.add(topping);
            //ask matt to see if I can use instance of to distinguish extra for meats and toppings
            System.out.println("Added: " + toppingName + " (" + category + ")" + " - " + "Extra Portions" + " (" + extra + ")");
        }
    }

    //good to go
    private static void addSauces(ArrayList<Topping> sauces){
//        System.out.println("Sauces: mayo, mustard, ketchup, ranch, thousand island, vinaigrette\n");
//
//        while(true){
//            String sauce = ConsoleHelper.promptForString("Enter sauce (or 'done' to finish ");
//
//            if (sauce.equalsIgnoreCase("done")){
//                break;
//            }
//            Topping sauce_item = new Topping(sauce, "sauce");
//            sauces.add(sauce_item);
//
//            System.out.println("Added sauce: " + sauce);
//
//        }

        String[] sauce = {"mayo", "mustard", "ketchup", "ranch", "thousand island", "vinaigrette"};

        System.out.println("Available Sauces");
        System.out.println("Sauces: " + String.join(", ", sauce));

        while(true){
            String sauce_name = ConsoleHelper.promptForString("Enter sauce (or 'done' to finish");
            if(sauce_name.equalsIgnoreCase("done")){
                break;
            }

            if(Arrays.asList(sauce).contains(sauce_name)){
                System.out.println("Added sauce: " + sauce_name);
            }
            else{
                System.out.println("Invalid sauce. Please choose from the list above.");
            }
        }
    }


    //added consoler helper Y/N prompt with loop in console file - good to go
    private static boolean toastedOption(){
//        String input = ConsoleHelper.promptForString("Toasted? (y/n)");
//        boolean toasted = input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
//        System.out.println("Sandwich will be " + (toasted ? "toasted." : "untoasted."));
//
//        return toasted;

        boolean toasted = ConsoleHelper.promptForYesNo("Toasted?");
        System.out.println("Sandwich will be " + (toasted ? "toasted." : "untoasted."));
        return toasted;
    }

    //add the toppics here
    private static Sandwich confirmSandwich(String bread, int size, boolean toasted, ArrayList<Topping> toppings,
                                            ArrayList<Topping> sauces){
        if (bread.isEmpty() || size == 0){
            System.out.println("Please select bread and the size before confirming!");
            return null;
        }

        Sandwich sandwich = new Sandwich("Custom Sandwich", bread, size, toasted);
        for(Topping t : toppings){
            sandwich.addTopping(t);
        }
        for (Topping s : sauces) {
            sandwich.addTopping(s);
        }

        System.out.println("\n--- Confirm Sandwich ---");
        System.out.println("Bread: " + bread);
        System.out.println("Size: " + size + " inch");
        //add toppings print line as well
        System.out.println("Toppings: " + toppings);
        System.out.println("Toasted: " + (toasted ? "Yes" : "No"));
        System.out.println("Price: $" + String.format("%.2f", sandwich.getPrice()));

        String confirm = ConsoleHelper.promptForString("Confirm sandwich? (y/n)");
        if (confirm.equalsIgnoreCase("y")) {
            System.out.println("Sandwich added!");
            return sandwich;
        }

        System.out.println("Sandwich not added.");
        return null;
    }
}

