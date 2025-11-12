package com.pluralsight;

public abstract class SignatureSandwich extends Sandwich{
    public SignatureSandwich(String name, String bread, int length, boolean toasted) {
        super(name, bread, length, toasted);

    }

    public abstract void signatureToppings();

    public abstract String get_Signature_name();

}
