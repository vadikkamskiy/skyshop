package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BasketService {
    private final ProductBasket b;
    private final StorageService store;


    public BasketService(ProductBasket b, StorageService store) {
        this.b = b;
        this.store = store;
    }

    public void checkProduct(UUID id){
        if(store.getProductById(id).isEmpty()){
            throw new NoSuchProductException(id);
        }
        else{
            b.addProduct(id);
        }
    }
    public UserBasket getUserBasket(){
        System.out.println(b.getProductBasket());
        return new UserBasket(b.getProductBasket().entrySet().stream()
                .map(e-> {
                    Product product = store.getProductById(e.getKey())
                            .orElseThrow(() -> new NoSuchProductException(e.getKey()));
                    return new BasketItem(product, e.getValue());
                })
                .toList());
    }
}
