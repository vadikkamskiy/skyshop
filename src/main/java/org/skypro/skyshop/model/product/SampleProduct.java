package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SampleProduct extends Product {
    private final int price;
    private final UUID id;
    public SampleProduct(String n ,int p, UUID i)throws Exception{
        super(n);
        price = p;
        id = i;
        try {
            checkPrice(p);
        } catch (IllegalAccessException e) {
            throw e;
        }
    }
    @Override
    public int getPrice(){
        return price;
    }

    public boolean isSpecial() {
        return false;
    }

    public String toString() {
        String output = "";
        output+=this.getType()+" ";
        output+=this.getName()+": ";
        output+=this.getPrice();
        return output;
    }
    private void checkPrice(int u) throws IllegalAccessException{
        if(u<=0){
            throw new IllegalAccessException("The price cannot be like this " + u + " that should be more 0");
        }
    }
    @Override
    public UUID getId() {
        return id;
    }
}
