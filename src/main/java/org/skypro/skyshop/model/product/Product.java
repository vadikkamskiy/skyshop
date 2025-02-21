package org.skypro.skyshop.model.product;

import java.util.Objects;

import org.skypro.skyshop.model.search.Searchable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Product implements Searchable{
    private final String name;
    public Product(String n) throws IllegalAccessException{
        name = n;
        checkNPE(n);
    }

    public String getName(){
        return name;
    }
    public abstract int getPrice();
    public abstract boolean isSpecial();
    @Override
    @JsonIgnore
    public String getSearchTerm() {
        return name + ": " + getPrice();
    }
    @Override
    @JsonIgnore
    public String getType(){
        return "PRODUCT";
    }

    private void checkNPE(String n) throws IllegalAccessException{
        if(n==null || n.isBlank()){
            throw new IllegalAccessException("empty name variable");
        }
    }
    @Override
    public int hashCode(){
        return Objects.hashCode(name);
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj instanceof Product){
            Product other = (Product) obj;
            return this.hashCode() == other.hashCode() && this.name.equals(other.getName());
        }else{
            return false;
        }
    }
}
