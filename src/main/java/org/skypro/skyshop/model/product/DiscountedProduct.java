package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private final int price;
    public int discount;
    private final UUID id;
    public DiscountedProduct(String n, int p, int d,UUID i) throws Exception{
        super(n);
        price = p;
        discount = d;
        id = i;
        try {
            checkPrice(p,d);
        } catch (IllegalAccessException e) {
            throw e;
        }
    }
    @Override
    public int getPrice(){
        return (price/100)*(100-discount);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        String output = "";
        output+=this.getType()+" ";
        output+=this.getName()+": ";
        output+=this.getPrice();
        output+="(discount " + this.discount+"%)";
        return output;
    }

    private void checkPrice(int u,int p) throws IllegalAccessException{
        if(u<=0){
            throw new IllegalAccessException("The price cannot be like this " + u + " that should be more 0");
        }
        if(p<0 || p>100){
            throw new IllegalAccessException("wrong input discount: " + p+ "% ??! thats unreal!!");
        }
    }
    public UUID getId() {
        return id;
    }
}
