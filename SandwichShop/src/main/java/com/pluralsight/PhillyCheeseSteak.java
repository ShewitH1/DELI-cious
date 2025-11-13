package com.pluralsight;

import java.util.ArrayList;

public class PhillyCheeseSteak extends SignatureSandwich{


    public PhillyCheeseSteak() {
        super("Philly Cheese Steak", "white", 8, true);
    }

    @Override
    public void signatureToppings() {
        ArrayList<Topping> toppings = new ArrayList<>();

        toppings.add(new Topping("Steak", "meat"));
        toppings.add(new Topping("American", "cheese"));
        toppings.add(new Topping("Peppers", "regular"));
        toppings.add(new Topping("Mayo", "sauce"));

        //ask matt about settoppings
        setToppings(toppings);


    }

//    @Override
//    public void remove_toppings(ArrayList<Topping> toppings, String topping_name) {
//
//    }
//
//    @Override
//    public void add_toppings(ArrayList<Topping> toppings, String topping_name) {
//
//    }

//    @Override
//    public String get_Signature_name() {
//        return "Philly Cheese Steak";
//    }









}
