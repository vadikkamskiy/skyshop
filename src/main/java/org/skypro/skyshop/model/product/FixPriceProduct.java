package org.skypro.skyshop.model.product;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class FixPriceProduct extends Product {
    static int FIXED_PRICE = 109;
    public FixPriceProduct(String n) throws Exception{
        super(n,UUID.randomUUID());
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
}
