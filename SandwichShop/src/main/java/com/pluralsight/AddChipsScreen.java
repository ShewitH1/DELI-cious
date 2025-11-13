package com.pluralsight;

public class AddChipsScreen {
    public static Chips chips_screen(){
        //make sure I add initializing  data - reservation
        String flavor = " ";

//        Chips chips = null;

        String chips_screen_options = """
                *-------- DELICIOUS sandwiches --------*
                --------------Add Chips Menu------------
                ~ Select Chip Type                     -
                 1 ) Classic                           -
                 2 ) BBQ                               -
                 3 ) Sour Cream & Onion                -
                 4 ) Confirm Chips                     -
                 0 ) Cancel and Return to Order Screen -
                ----------------------------------------
                """;

        int command = -1;
        while(command != 0){
            System.out.println(chips_screen_options);
            command = ConsoleHelper.promptForInt("Choose an option: ");

            switch (command) {
                case 1:
                    //flavor for classic
                    flavor = processSelectFlavor("Classic");
                    break;

                case 2:
                    //flavor for BBQ
                    flavor = processSelectFlavor("BBQ");
                    break;

                case 3:
                    //flavor for sour
                    flavor = processSelectFlavor("Sour Cream and Onion");
                    break;
                case 4:
                    Chips chips = processConfirmChips(flavor);
                    if(chips != null){
                        return chips;
                    }
                    break;
                case 0:
                    processCancel();
                    System.out.println("Returning to Order Screen...");

                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        return null;
    }

    //make sure I put helper methods
    private static String processSelectFlavor(String flavorChoice ){
        System.out.println("Selected flavor: " + flavorChoice);
        return flavorChoice;
    }

    //add error catching with this
    private static Chips processConfirmChips(String flavor) {
        if(flavor.trim().isEmpty() || flavor == null){
            System.out.println("Please select a chip flavor before confirming");
            return null;
        }

        //make object
//        Chips chips = new Chips("Chips", 1.50, flavor);
        Chips chips = new Chips(flavor + " Chips", flavor);
        System.out.println("Chips added: " + chips);
        return chips;


    }

    private static void processCancel(){
        System.out.println("Returning to Order Screen...");
    }
}
