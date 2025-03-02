package org.skypro.skyshop.model.article;

import java.util.Objects;
import java.util.UUID;

import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Article implements Searchable{
    private final String nameOfArticle;
    private final String textOfArticle;
    private final UUID id = UUID.randomUUID();
    public Article(String n,String t){
        nameOfArticle = n;
        textOfArticle = t;
    }
    public String toString(){
        return getType() +" "+ nameOfArticle + " - " + textOfArticle;
    }

     @Override
     @JsonIgnore
     public String getSearchTerm() {
        return nameOfArticle + " " + textOfArticle;
    }

     @Override
     @JsonIgnore
     public String getType() {
        return "ARTICLE";
    }

     @Override
     public String getStringRepresentation() {
         return Searchable.super.getStringRepresentation();
     }
    @Override
    public String getName() {
        return nameOfArticle;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(nameOfArticle);
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj instanceof Product){
            Product other = (Product) obj;
            return nameOfArticle.hashCode() == other.hashCode() && nameOfArticle.equals(other.getName());
        }else{
            return false;
        }
    }
    @Override
    public UUID getId() {
        return id;
    }
 }
