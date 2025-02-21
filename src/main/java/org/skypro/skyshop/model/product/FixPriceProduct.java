package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    static int FIXED_PRICE = 109;
    private final UUID id;

    public FixPriceProduct(String n,UUID i) throws Exception{
        super(n);
        id = i;
    }
    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    public boolean isSpecial() {
        return true;
    }


    public String toString() {
        String output = "";
        output+=this.getType()+" ";
        output+=this.getName()+": Fixed price - ";
        output+=this.getPrice();
        return output;
    }
    @Override
    public UUID getId() {
        return id;
    }
    
}
