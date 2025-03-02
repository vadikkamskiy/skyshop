package org.skypro.skyshop.model.basket;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class ProductBasket {
    private static Map<UUID,Integer> selfBasket;

    public ProductBasket(Map<UUID, Integer> selfBasket) {
        this.selfBasket = selfBasket;
    }

    public void addProduct(UUID id){
        selfBasket.merge(id,1, Integer::sum);
    }
    public Map<UUID, Integer> getProductBasket(){
        return Collections.unmodifiableMap(selfBasket);
    }
}
