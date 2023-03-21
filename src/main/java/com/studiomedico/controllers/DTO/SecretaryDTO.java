package com.studiomedico.controllers.DTO;

public class SecretaryDTO extends PersonaDTO{
    //campi da aggiungere al Secretary
    public SecretaryDTO() {
    }
    public SecretaryDTO(String name, String surname, String email, String address, String telephone, String fiscalCode) {
        super(name, surname, email, address, telephone, fiscalCode);
    }
}
