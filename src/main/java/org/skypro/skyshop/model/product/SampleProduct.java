package org.skypro.skyshop.model.product;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@Scope("prototype")
public class SampleProduct extends Product {
    private final int price;
    public SampleProduct(String n ,int p)throws Exception{
        super(n,UUID.randomUUID());
        price = p;
        checkPrice(p);
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
}
