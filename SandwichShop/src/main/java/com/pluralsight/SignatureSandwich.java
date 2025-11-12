package com.pluralsight;

public abstract class SignatureSandwich extends Sandwich{
    private String signature_name;
    public SignatureSandwich(String name, String bread, int length, boolean toasted) {
        super(name, bread, length, toasted);
        this.signature_name = name;
        signatureToppings();

    }

    public abstract void signatureToppings();

    public abstract String get_Signature_name();



}
