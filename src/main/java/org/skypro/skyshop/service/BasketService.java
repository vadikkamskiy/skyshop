package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BasketService {
    private final ProductBasket b;
    private final StorageService store;

    public BasketService(ProductBasket b, StorageService store, UserBasket ub) {
        this.b = b;
        this.store = store;
    }

    public void checkProduct(UUID id){
        if(store.getProductById(id).isEmpty()){
            throw new IllegalArgumentException();
        }
        else{
            b.addProduct(id);
        }
    }
    public UserBasket getUserBasket(){
        return new UserBasket(b.getProductBasket().entrySet().stream()
                .map(e-> new BasketItem(store.getProductById(e.getKey()).get(),e.getValue()))
                .toList());
    }
}
