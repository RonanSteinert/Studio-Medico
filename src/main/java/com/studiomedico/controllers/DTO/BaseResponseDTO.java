package com.studiomedico.controllers.DTO;

public class BaseResponseDTO {
    private Status status;
    private String errorMessage;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public enum Status{
        OK,KO;
    }

}
