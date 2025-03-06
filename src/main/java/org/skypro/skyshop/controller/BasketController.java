package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.service.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService) throws Exception{
        this.basketService = basketService;
    }

    @GetMapping("/basket/{id}")
    public ResponseEntity<String> addProduct(@PathVariable UUID id) {
        try {
            basketService.checkProduct(id);
            return ResponseEntity.ok("Товар добавлен в корзину!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Неверный UUID");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Ошибка сервера: " + e.getMessage());
        }
    }
    @GetMapping("/basket")
    public UserBasket getUserBasket(){
         return basketService.getUserBasket();
    }
}
