package com.pluralsight;

import java.util.ArrayList;

public class BLT extends SignatureSandwich{


    public BLT(String name, String bread, int length, boolean toasted) {
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

    @Override
    public String get_Signature_name() {
        return "BLT";
    }

    //ask matt should I do calculate price
}
