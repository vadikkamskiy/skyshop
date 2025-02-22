package org.skypro.skyshop.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.*;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SampleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

@Service
public class StorageService {
    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;
    List<Product> shopList = new LinkedList<>();
    List<Article> artList = new LinkedList<>();
    List<Searchable> searchList = new LinkedList<>();

    public StorageService() throws Exception {
        shopList.add(new SampleProduct("beerr", 69, UUID.randomUUID()));
        artList.add(new Article("Bad beer", "Very good choise", UUID.randomUUID()));
        shopList.add(new FixPriceProduct("whiskey", UUID.randomUUID()));
        artList.add(new Article("Whiskey Jacky Danielson", "beautiful with cola", UUID.randomUUID()));
        shopList.add(new DiscountedProduct("gin", 450, 11, UUID.randomUUID()));
        artList.add(new Article("Gin Hendroy's", "very strong", UUID.randomUUID()));
        shopList.add(new SampleProduct("wine", 670, UUID.randomUUID()));
        artList.add(new Article("wine Divine", "vine, we miss", UUID.randomUUID()));
        shopList.add(new DiscountedProduct("beer", 790, 12, UUID.randomUUID()));
        artList.add(new Article("beer hellniken", "damn good", UUID.randomUUID()));
        shopList.add(new SampleProduct("wine", 940, UUID.randomUUID()));
        artList.add(new Article("Tuchi", "Cabernet", UUID.randomUUID()));
        shopList.add(new FixPriceProduct("vodka", UUID.randomUUID()));
        artList.add(new Article("vodka absoluse", "Luse everything", UUID.randomUUID()));
        shopList.add(new SampleProduct("wine", 1500, UUID.randomUUID()));
        artList.add(new Article("wine mother-in-law's cellar", "taste of childhood", UUID.randomUUID()));
        shopList.add(new DiscountedProduct("vodka", 900, 5, UUID.randomUUID()));
        artList.add(new Article("vodka nemiron", "turn it up", UUID.randomUUID()));
        articles = artList.stream()
                .collect(Collectors.toMap(Article::getId, element -> element));
        products = shopList.stream()
                .collect(Collectors.toMap(Product::getId, element -> element));
        searchList.addAll(shopList);
        searchList.addAll(artList);
    }

    public Map<UUID, Article> getArticles() {
        return articles;
    }

    public Map<UUID, Product> getProducts() {
        return products;
    }

    public List<Searchable> getSearchables() {
        return searchList;
    }
}