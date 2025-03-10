package org.skypro.skyshop.model.exceptions;

public class ShopError {
    private final String code;
    private final String message;

    public ShopError(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getInfo(){
        return code + " T_T " + message;
    }
}
