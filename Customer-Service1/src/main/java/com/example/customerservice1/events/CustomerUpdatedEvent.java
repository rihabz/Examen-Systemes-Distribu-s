package com.example.customerservice1.events;

import lombok.Getter;

public class CustomerUpdatedEvent extends BaseEvent<String>{
    @Getter
    private String nom;
    @Getter
    private String adresse;
    @Getter
    private String adresseEmail;

    public CustomerUpdatedEvent(String id, String nom, String adresse, String adresseEmail) {
        super(id);
        this.nom = nom;
        this.adresse = adresse;
        this.adresseEmail = adresseEmail;
    }
}
