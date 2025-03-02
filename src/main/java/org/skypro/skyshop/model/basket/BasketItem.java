package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

public final class BasketItem {
    private static Product product;
    private static int c;
    public BasketItem(Product product, int c){
        this.product = product;
        this.c = c;
    }
    public String getName(){
        return product.getName();
    }

    public int getPrice(){
        return product.getPrice();
    }

    public int getCount(){
        return c;
    }
}
