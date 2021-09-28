package com.mongodb.project.common.results;

import java.io.Serializable;

public class SuccessResponse<T> extends ServiceResponse implements Serializable {

    private T data;
    private String message;

    public SuccessResponse() {
        super(StatusType.SUCCESS);
    }

    public SuccessResponse(StatusType status) {
        super(status);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
