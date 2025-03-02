package org.skypro.skyshop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    private final List<Searchable> searchables;
    public SearchService(StorageService storageService){
        searchables = storageService.getSearchables();
    }
    public List<SearchResult> search(String pattern){
        return searchables.stream()
            .filter(a -> a.toString().toLowerCase().contains(pattern.toLowerCase()))
            .map(SearchResult::fromSearchable)
            .collect(Collectors.toList());
    }
    public List<Searchable> getList(){
        return searchables;
    }
}
