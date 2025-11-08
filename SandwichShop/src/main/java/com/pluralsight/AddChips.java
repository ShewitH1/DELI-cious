package com.pluralsight;

public class AddChips {
    public static Chips chips_screen(){
        //empty flavor
        String flavor = " ";

        //make sure to make chips empty - null
        Chips chips = null;

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

                case 2:
                    //flavor for BBQ

                case 3:
                    //flavor for sour

                    break;
                case 4:

                    System.out.println("Chips added successfully!");

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

    //make sure I put helper methods
    private static String processSelectFlavor(String flavorChoice ){
        System.out.println("Selected flavor: " + flavorChoice);
        return flavorChoice;
    }

    private static  Chips processConfirmChips(String flavor){
        if(flavor.isEmpty()){
            System.out.println("Please select a chip flavor before confirmingQ ");
            return null;
        }

        //make object
        Chips chips = new Chips("Chips", 1.50, flavor);
        System.out.println("Chips added: " + chips);
        return chips;
    }

    private static void processCancel(){
        System.out.println("Returning to Order Screen...");
    }
}
