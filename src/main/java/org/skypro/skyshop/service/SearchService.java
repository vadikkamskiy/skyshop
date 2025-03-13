package org.skypro.skyshop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    private final StorageService storageService;
    public SearchService(StorageService storageService){
        this.storageService = storageService;
    }
    public List<SearchResult> search(String pattern){
        return storageService.getSearchables().stream()
            .filter(a -> a.getSearchTerm().toLowerCase().contains(pattern.toLowerCase()))
            .map(SearchResult::fromSearchable)
            .collect(Collectors.toList());
    }
    public List<Searchable> getList(){
        return storageService.getSearchables();
    }
}
