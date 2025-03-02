package org.skypro.skyshop.service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SampleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class StorageService {
    private final Map<UUID, Product> products = new HashMap<>();
    private final Map<UUID, Article> articles = new HashMap<>();
    private final List<Searchable> searchList = new LinkedList<>();
    public StorageService(ProductService productService) throws Exception {
        List<Product> prod = new LinkedList<>();
        List<Article> art = new LinkedList<>();
        prod.add(new SampleProduct("beer",69));
        System.out.println(prod.get(0).getId());
        prod.add(new DiscountedProduct("vodka",400,12));
        prod.add(new FixPriceProduct("Gin"));
        prod.add(new FixPriceProduct("Wine"));
        art.add(new Article("beer","beerrr"));
        art.add(new Article("vodka","voodkaaa"));
        art.add(new Article("Gin","GIN"));
        art.add(new Article("Wine","wineeee"));

        for(Product p : prod){
            products.put(p.getId(),p);
        }
        for(Article a : art){
            articles.put(a.getId(),a);
        }
//        shopList.add(new SampleProduct("wine", 670, UUID.randomUUID()));
//        artList.add(new Article("wine Divine", "vine, we miss", UUID.randomUUID()));
//        shopList.add(new DiscountedProduct("beer", 790, 12, UUID.randomUUID()));
//        artList.add(new Article("beer hellniken", "damn good", UUID.randomUUID()));
//        shopList.add(new SampleProduct("wine", 940, UUID.randomUUID()));
//        artList.add(new Article("Tuchi", "Cabernet", UUID.randomUUID()));
//        shopList.add(new FixPriceProduct("vodka", UUID.randomUUID()));
//        artList.add(new Article("vodka absoluse", "Luse everything", UUID.randomUUID()));
//        shopList.add(new SampleProduct("wine", 1500, UUID.randomUUID()));
//        artList.add(new Article("wine mother-in-law's cellar", "taste of childhood", UUID.randomUUID()));
//        shopList.add(new DiscountedProduct("vodka", 900, 5, UUID.randomUUID()));
//        artList.add(new Article("vodka nemiron", "turn it up", UUID.randomUUID()));
    }
    public Map<UUID, Article> getArticles() {
        return articles;
    }
    public Map<UUID, Product> getProducts() {
        return products;
    }
    public List<Searchable> getSearchables() {
        searchList.addAll(products.values());
        searchList.addAll(articles.values());
        return searchList;
    }
    public Optional<Product> getProductById(UUID id) throws IllegalArgumentException {
        return Optional.ofNullable(products.get(id));
    }
}