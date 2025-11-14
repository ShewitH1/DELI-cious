package com.pluralsight.models;

import java.util.ArrayList;

//CHALLENGE YOURSELF FEATURE - CUSTOM SANDWICH
public class BLT extends SignatureSandwich {


    public BLT() {
        super("BLT", "white", 8, true);
    }

    @Override
    public void signatureToppings() {
        ArrayList<Topping> toppings = new ArrayList<>();

        toppings.add(new Topping("Bacon", "meat"));
        toppings.add(new Topping("Cheddar", "cheese"));
        toppings.add(new Topping("Lettuce", "regular"));
        toppings.add(new Topping("Tomato", "regular"));
        toppings.add(new Topping("Ranch", "sauce"));

        setToppings(toppings);


    }
}
