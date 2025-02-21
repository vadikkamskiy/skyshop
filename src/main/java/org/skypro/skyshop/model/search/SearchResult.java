package org.skypro.skyshop.model.search;

public class SearchResult {
    private final String id;
    private final String name;
    private final String contentType;

    public SearchResult(String i, String n, String t){
        id=i;
        name = n;
        contentType = t;
    }
    public static SearchResult fromSearchable(Searchable f){
        return new SearchResult(f.getId().toString(), f.getName(), f.getType());
    }

    public String toString(){
        return id + name + contentType;
    }
}
