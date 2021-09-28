package com.mongodb.project.common.results;

import java.io.Serializable;

public class ErrorResponse<T> extends ServiceResponse implements Serializable {

    private T data;

    public ErrorResponse() {
        super(StatusType.ERROR);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
