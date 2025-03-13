package org.skypro.skyshop.service;

import org.junit.jupiter.api.Test;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.product.Product;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BasketServiceTest {
    @Test
    void testAddNonExistentProductThrowsException() {
        // Arrange
        Product product = mock(Product.class);
        StorageService storageService = mock(StorageService.class);
        ProductBasket productBasket = mock(ProductBasket.class);

        when(product.getId()).thenReturn(UUID.randomUUID());
        BasketService basketService = new BasketService(productBasket, storageService);

        // Act & Assert
        assertThrows(NoSuchProductException.class, () -> {
            basketService.checkProduct(product.getId());
        });
    }

    @Test
    void testAddExistingProductCallsAddProduct() {
        // Arrange
        UUID testId = UUID.randomUUID();
        Product testProduct = mock(Product.class);
        ProductBasket productBasket = mock(ProductBasket.class);
        StorageService storageService = mock(StorageService.class);

        when(testProduct.getId()).thenReturn(testId);

        BasketService basketService = new BasketService(productBasket, storageService);
        when(storageService.getProductById(testId)).thenReturn(Optional.of(testProduct));
        // Act
        basketService.checkProduct(testId);

        // Assert
        verify(productBasket).addProduct(testId);

        verify(productBasket, times(1)).addProduct(testId);

    }


    @Test
    void testGetUserBasketReturnsEmptyIfNoProducts() {
        // Arrange
        ProductBasket productBasket = mock(ProductBasket.class);
        StorageService storageService = mock(StorageService.class);

        when(productBasket.getProductBasket()).thenReturn(Collections.emptyMap());

        BasketService basketService = new BasketService(productBasket, storageService);

        // Act
        UserBasket products = basketService.getUserBasket();

        // Assert
        assertTrue(products.getUserBasket().isEmpty());
    }

}
