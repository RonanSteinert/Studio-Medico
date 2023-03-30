package com.studiomedico.statusEnum;

public enum StatusRecord {
    Active("Active"),
    Deleted("Deleted");
    private final String description;

    StatusRecord(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }


}
