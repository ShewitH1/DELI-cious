package com.pluralsight.userinterface;

import com.pluralsight.models.Order;
import com.pluralsight.data.SandwichFileManager;
import com.pluralsight.models.*;

public class OrderMenu {

    private static Order current_order = new Order();
    public static void Order_Screen(){

        String Order_screen_options = """
                *-------- DELICIOUS sandwiches --------*
                -----------Order Screen Menu-----------
                ~ Enter                              -
                 1 ) Add Sandwich                    -
                 2 ) Add Drink                       -
                 3 ) Add Chips                       -
                 4 ) Add Custom Sandwich             -
                 5 ) Checkout                        -
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
                        //custom sandwich
                        custom_sandwich();
                        break;

                    case 5:
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
        private static void custom_sandwich(){
            System.out.println("1) BLT\n2) Philly Cheese Steak\n3) Custom Sandwich");
            int custom = ConsoleHelper.promptForInt("Choose a signature sandwich");
            Sandwich sandwich = null;
            switch (custom){
                case 1:
                    sandwich = new BLT();
                    break;
                case 2:
                    sandwich = new PhillyCheeseSteak();
                    break;

                case 3:
                    sandwich = AddSandwichScreen.sandwich_screen();
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
                    return;
            }

            //this is for if users want to customize their signature sandwich
            if(sandwich instanceof SignatureSandwich signature){
                if(ConsoleHelper.promptForYesNo("Do you want to customize your toppings?")){
                    signature.customize_toppings();
                }
            }

            if(sandwich != null){
                current_order.addProduct(sandwich);
                System.out.println(sandwich.custom_des() + " added!");
            }
        }



        private static void AddSandwich(){
            Sandwich sandwich = AddSandwichScreen.sandwich_screen();
            if(sandwich != null){
                current_order.addProduct(sandwich);
            }
        }

        //Adding Drink method
        private static void addDrink(){
            Drink drink = AddDrinkScreen.drink_screen();
            if(drink != null){
                current_order.addProduct(drink);
            }

        }

        //Adding Chips method
        public static void addChips(){
            Chips chips = AddChipsScreen.chips_screen();
            if(chips != null){
                current_order.addProduct(chips);
            }

        }

        //Checkout method
        public static void checkout() {
            if (current_order.isEmpty()) {
                System.out.println("Your order is empty! Please add items before checkout!");
            } else {
//                System.out.println("\n ------Summary of Order-------");
//                current_order.printReceipt();
//
//                String confirm = ConsoleHelper.promptForString("Confirm checkout? (y/n)");
//                if (confirm.equalsIgnoreCase("y")) {
//                    System.out.println("Order confirmed!");
//                    current_order = new Order(); // reset
//                } else {
//                    System.out.println("Returning to Order Menu.");
//                }


                System.out.println("\n------ Summary of Order ------");
                current_order.printReceipt();

                String confirm = ConsoleHelper.promptForString("Confirm checkout? (y/n)");
                if (confirm.equalsIgnoreCase("y")) {
                    System.out.println("\n Order confirmed!");
                    System.out.println("Saving receipt...");

                    // Create file manager and save receipt
                    SandwichFileManager fileManager = new SandwichFileManager();
                    fileManager.SaveSandwichReceipt(current_order);

                    // Reset order after saving
                    current_order = new Order();
                    System.out.println("\nReturning to Order Menu...\n");

                } else {
                    System.out.println("Returning to Order Menu...");
                }
            }
        }

//            System.out.println("\n ------Summary of Order-------");
//            current_order.printReceipt();
//
//            //this is already in my printReceipt() method
////            System.out.println("Total: $" + String.format("%.2f", current_order.getTotal()));
//
//
//            String confirm = ConsoleHelper.promptForString("Confirm checkout? (y/n)");
//            if (confirm.equalsIgnoreCase("y")) {
//                System.out.println("Order confirmed!");
//                current_order = new Order(); // reset
//            } else {
//                System.out.println("Returning to Order Menu.");
//            }


        //not sure if i want to make a method for this functionality
        public static void cancelOrder(){

        }
    }
