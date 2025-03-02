package org.skypro.skyshop.service;


import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SampleProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductService {
    private final ApplicationContext context;
    @Autowired
    ProductService(ApplicationContext context){
        this.context = context;
    }
    public final Product createSampleProduct(String name, int price, UUID id){
        return context.getBean(SampleProduct.class,name,price,id);
    }

    public final Product createDiscountedProduct(String name, int price, int discount,UUID id){
        return context.getBean(DiscountedProduct.class,name, price,discount,id);
    }

    public final Product createFixPriceProduct(String name,UUID id){
        return context.getBean(FixPriceProduct.class,name, id);
    }
}
