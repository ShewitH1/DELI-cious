package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class SignatureSandwich extends Sandwich{
    private String signature_name;
    public SignatureSandwich(String name, String bread, int length, boolean toasted) {
        super(name, bread, length, toasted);
        this.signature_name = name;
        signatureToppings();

    }

    public abstract void signatureToppings();

    public void customize_toppings(){
        while(true){
            System.out.println("-------Customize Toppings for " + getName() + "------");

            for(Topping topping : getToppings()){
                System.out.println("- " + topping.getName() + " (" + topping.getCategory() + ")");
            }

            System.out.println("1) Add Topping");
            System.out.println("2) Remove Topping");
            System.out.println("0) Done");

            int choice = ConsoleHelper.promptForInt("Choose an option: ");

            if (choice == 0){
                System.out.println("Finished Customizing!");
                return; //this will return to the order screen menu
            }

            if (choice == 1) {
                add_toppings();
            } else if (choice == 2) {
                remove_toppings();
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }


    public void remove_toppings() {

        String name = ConsoleHelper.promptForString("Enter topping name to remove: ");

        Topping remove_topping = null;

        for(Topping topping : getToppings()){
            if(topping.getName().equalsIgnoreCase(name)){
                remove_topping = topping;
                break;
            }
        }

        //this is if topping name is found
        if(remove_topping!=null){
            getToppings().remove(remove_topping);
            System.out.println(name + " removed from your special sandwich");
        }
        else{
            System.out.println(name + " is not on this special sandwich");
        }
    }


    public void add_toppings() {
        String name = ConsoleHelper.promptForString("Enter topping name: ");

        //this is if name exists
        for(Topping topping : getToppings()){
            if(topping.getName().equalsIgnoreCase(name)){
                System.out.println(name + " is already included.");
                return;
            }
        }

        //this is for interactive user topping type
        System.out.println("What type of topping is " + name + "?");
        System.out.println("1) Meat\n2) Cheese\n3) Regular\n4) Sauce");

        int choice = ConsoleHelper.promptForInt("Choose topping type: ");

        String type;
        if (choice == 1) type = "meat";
        else if (choice == 2){
            type = "cheese";
        }
        else if (choice == 3) {
            type = "regular";
        }
        else if (choice == 4) {
            type = "sauce";
        }
        else type = "regular";

        //name, category
        getToppings().add(new Topping(name, type));
        System.out.println(name + " (" + type + ") added.");

    }


//    public abstract void remove_toppings(ArrayList<Topping> toppings, String topping_name);
//
//    public abstract  void add_toppings(ArrayList<Topping> toppings, String topping_name);


//    public abstract String get_Signature_name();

//    @Override
//    public String toString() {
//        String toppingsList = "";
//
//        for (Topping topping : getToppings()) {
//            if (!toppingsList.isEmpty()) {
//                toppingsList += ", ";
//            }
//            toppingsList += topping.getName();
//        }
//
//        String toastedText = isToasted() ? ", toasted" : "";
//
//        return get_Signature_name() + " (" + getLength() + " inch, " + getBread() + toastedText + ") [" +
//                toppingsList + "] | $" + String.format("%.2f", getPrice());
//    }


}
