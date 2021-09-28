package com.mongodb.project.common.results;

public class ServiceResponse {
    private StatusType status;

    public ServiceResponse() {
    }

    public ServiceResponse(StatusType status) {
        this.status = status;
    }


    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
