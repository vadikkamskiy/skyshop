package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    String getSearchTerm();
    String getName();
    String getType();
    UUID getId();
    default String getStringRepresentation(){
        return getType() +'\n' + getSearchTerm();
    }
    default int compareTo(Searchable s2){
            return this.getName().compareTo(s2.getName());
        }
}
