package com.pluralsight;

public class AddDrink {
    //make sure I add empty data
    String size = " ";
    String flavor = " ";

    public static Drink drink_screen(){
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

                    break;
                case 2:

                    break;
                case 3:
                    // Set Drink Size
                    break;
                case 4:
                    // Choose Drink Flavor
                    break;
                case 5:
                    // Confirm Drink
                    System.out.println("Drink added successfully!");
                    break;
                case 0:
                    System.out.println("Returning to Order Screen...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        return null;
    }

    //Add helper methods
    private static String processSelectSize(){

        return null;
    }

    private static String processSelectFlavor(){

        return null;
    }

    private static Drink processConfirmDrink(){

        return null;
    }

    private static void processCancel(){


    }


}
