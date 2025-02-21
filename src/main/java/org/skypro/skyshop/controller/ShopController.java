package org.skypro.skyshop.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ShopController {
    private final StorageService storageService;
    private final SearchService searchService;
    public ShopController(StorageService storageService,SearchService searchService) throws Exception{
        this.storageService = new StorageService();
        this.searchService = new SearchService(storageService);
    }

    @GetMapping("/products")
    public Map<UUID,Product> p(){
        return storageService.getProducts();
    }

    @GetMapping("/articles")
    public Map<UUID, Article> a(){
        return storageService.getArticles();
    }

    @GetMapping("/search")
    public List<Searchable> search(@RequestParam(required = false) String pattern) {
        return searchService.getList().stream()
            .filter(j -> j.getStringRepresentation().toLowerCase().contains(pattern.toLowerCase()))
            .collect(Collectors.toList());
    }
    
}
