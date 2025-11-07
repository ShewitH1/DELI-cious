package com.pluralsight;

public class OrderMenu {
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
                        AddSandwich.sandwich_screen();
                        break;

                    case 2:
                        //Add Drink
                        System.out.println();
                        AddDrink.drink_screen();
                        break;

                    case 3:
                        //Add Chips
                        System.out.println();
                        AddChips.chips_screen();
                        break;

                    case 4:
                        //Checkout

                        break;
                    case 0:
                        System.out.println("Cancel Order...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            }

        }

        //Adding Sandwich method
        public void addSandwich(){

        }

        //Adding Drink method
        public void addDrink(){

        }

        //Adding Chips method
        public void addChips(){

        }

        //Checkout method
        public void checkout(){

        }
    }
