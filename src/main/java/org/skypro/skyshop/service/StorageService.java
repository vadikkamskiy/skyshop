package org.skypro.skyshop.service;

import java.util.*;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SampleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class StorageService {
    private final Map<UUID, Product> products = new HashMap<>();
    private final Map<UUID, Article> articles = new HashMap<>();
    private final List<Searchable> searchList = new LinkedList<>();
    public StorageService() throws Exception {
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
        prod.add(new SampleProduct("wine", 670));
        art.add(new Article("wine Divine", "vine, we miss"));
        prod.add(new DiscountedProduct("beer", 790, 12));
        art.add(new Article("beer hellniken", "damn good"));
        prod.add(new SampleProduct("wine", 940));
        art.add(new Article("Tuchi", "Cabernet"));
        prod.add(new FixPriceProduct("vodka"));
        art.add(new Article("vodka absoluse", "Luse everything"));
        prod.add(new SampleProduct("wine", 1500));
        art.add(new Article("wine mother-in-law's cellar", "taste of childhood"));
        prod.add(new DiscountedProduct("vodka", 900, 5));
        art.add(new Article("vodka nemiron", "turn it up"));
        for(Product p : prod){
            products.put(p.getId(),p);
        }
        for(Article a : art){
            articles.put(a.getId(),a);
        }

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