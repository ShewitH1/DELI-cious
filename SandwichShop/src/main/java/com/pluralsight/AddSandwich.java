package com.pluralsight;

import java.util.ArrayList;

public class AddSandwich {

    public static Sandwich sandwich_screen(){
        //empty - default data
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

        while(true){
            String toppingName = ConsoleHelper.promptForString("Enter topping (or 'done' to finish)");
            if (toppingName.equalsIgnoreCase("done")) {
                break;
            }

            String category = ConsoleHelper.promptForString("Enter category (meat / cheese / regular)").toLowerCase();
            int extra = 0;
            if (category.equals("meat") || category.equals("cheese")) {
                extra = ConsoleHelper.promptForInt("Extra portions? (0 for none)");
            }

            Topping topping = new Topping(toppingName, category, extra);
            toppings.add(topping);
            System.out.println("Added: " + toppingName + " (" + category + ")");
        }
    }

    private static void addSauces(ArrayList<Topping> sauces){
        System.out.println("\n Sauces: mayo, mustard, ketchup, ranch, thousand island, vinaigrette\n");

        while(true){
            String sauce = ConsoleHelper.promptForString("Enter sauce (or 'done' to finish ");

            if (sauce.equalsIgnoreCase("done")){
                break;
            }
            Topping sauce_item = new Topping(sauce, "sauce");
            sauces.add(sauce_item);

            System.out.println("Added sauce: " + sauce);

        }
    }

    private static boolean toastedOption(){
        String input = ConsoleHelper.promptForString("Toasted? (y/n)");
        boolean toasted = input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
        System.out.println("Sandwich will be " + (toasted ? "toasted." : "untoasted."));

        return toasted;
    }

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
        System.out.println("Toasted: " + (toasted ? "Yes" : "No"));
        System.out.println("Price: $" + String.format("%.2f", sandwich.calculatePrice()));

        String confirm = ConsoleHelper.promptForString("Confirm sandwich? (y/n)");
        if (confirm.equalsIgnoreCase("y")) {
            System.out.println("Sandwich added!");
            return sandwich;
        }

        System.out.println("Sandwich not added.");
        return null;
    }
}

