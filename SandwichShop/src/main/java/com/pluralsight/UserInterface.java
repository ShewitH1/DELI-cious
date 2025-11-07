package com.pluralsight;

public class UserInterface {

    public void HomeScreen(){

        String Home_screen_options = """
                 *-------- DELICIOUS sandwiches --------*
                    -----------------Home-------------------
                     ~ Enter                              -
                      1 ) New Order                       -
                      0 ) To exit                         -
                     ---------------------------------------
                 """;

        int command = -1;
        while (command != 0) {
            System.out.println(Home_screen_options);
            command = ConsoleHelper.promptForInt("Choose an option: ");

            switch (command) {
                case 1:
                    //Order Screen - New Order
                    OrderMenu.Order_Screen();

                    break;

                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;


                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
