package com.pluralsight;

import java.sql.SQLOutput;

public class OrderMenu {

    private static Order current_order = new Order();
    public static void Order_Screen(){

        String Order_screen_options = """
                *-------- DELICIOUS sandwiches --------*
                -----------Order Screen Menu-----------
                ~ Enter                               -
                 1 ) Add Sandwich                    -
                 2 ) Add Drink                       -
                 3 ) Add Chips                       -
                 4 ) Checkout                        -
                 0 ) Cancel Order                    -
                ---------------------------------------
                """;


            int command = -1;
            while (command != 0) {
                System.out.println(Order_screen_options);
                command = ConsoleHelper.promptForInt("Choose an option: ");

                switch (command) {
                    case 1:
                        //Add Sandwich
                        System.out.println();
                        AddSandwich();
                        break;
                    case 2:
                        //Add Drink
                        System.out.println();
                        addDrink();

                        break;
                    case 3:
                        //Add Chips
                        System.out.println();
                        addChips();
                        break;

                    case 4:
                        //Checkout
                        checkout();
                        break;
                    case 0:
                        System.out.println("Cancel Order...");
                        System.exit(0);

                        //not sure to make method for this or not
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            }

        }

        //Adding Sandwich method
        private static void AddSandwich(){
            Sandwich sandwich = AddSandwich.sandwich_screen();
            if(sandwich != null){
                current_order.addProduct(sandwich);
            }
        }

        //Adding Drink method
        private static void addDrink(){
            Drink drink = AddDrink.drink_screen();
            if(drink != null){
                current_order.addProduct(drink);
            }

        }

        //Adding Chips method
        public static void addChips(){
            Chips chips = AddChips.chips_screen();
            if(chips != null){
                current_order.addProduct(chips);
            }

        }

        //Checkout method
        public static void checkout(){
            if(current_order.isEmpty()){
                System.out.println("Your order is empty! Please add items before checkout!");
            }

            System.out.println("\n ------Summary of Order-------");
            current_order.printReceipt();
            System.out.println("Total: $" + String.format("%.2f", current_order.getTotal()));


            String confirm = ConsoleHelper.promptForString("Confirm checkout? (y/n)");
            if (confirm.equalsIgnoreCase("y")) {
                System.out.println("Order confirmed!");
                current_order = new Order(); // reset
            } else {
                System.out.println("Returning to Order Menu.");
            }


        }

        //not sure if i want to make a method for this functionality
        public static void cancelOrder(){

        }
    }
