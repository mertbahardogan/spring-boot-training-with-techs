package com.mongodb.project.common.exceptions;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class MethodRequestNotValidException extends Exception{
    private final List result;

    private MethodRequestNotValidException(List result) {
        this.result = result;
    }

    public static MethodRequestNotValidException createWith(List result) {
        return new MethodRequestNotValidException(result);
    }

    public ArrayList getMessageList() {
        ArrayList<String> list=new ArrayList<String>();
        for (Object object : result) {
            if(object instanceof FieldError) {
                FieldError fieldError = (FieldError) object;
                String message = fieldError.getDefaultMessage();
                list.add(message);
            }
        }
        return list;
    }
}
