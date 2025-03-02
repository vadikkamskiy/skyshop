package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserBasket {
    private final List<BasketItem> bs;
    private final int total;

    public UserBasket(List<BasketItem> bs){
        this.bs = bs;
        total = bs.stream().mapToInt(m -> m.getPrice() * m.getCount())
                .sum();
    }

    public List<BasketItem> getUserBasket(){
        return bs;
    }
    public int getTotal(){
        return total;
    }
}
