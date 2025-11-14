package com.pluralsight.models;

import java.util.ArrayList;

//CHALLENGE YOURSELF FEATURE - CUSTOM SANDWICH
public class PhillyCheeseSteak extends SignatureSandwich {


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
}
