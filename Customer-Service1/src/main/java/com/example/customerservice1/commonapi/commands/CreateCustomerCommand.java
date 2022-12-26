package com.example.customerservice1.commonapi.commands;

import lombok.Getter;

public class CreateCustomerCommand extends BaseCommand<String> {
    @Getter
    private String nom;
    @Getter
    private String adresse;
    @Getter
    private String adresseEmail;

    public CreateCustomerCommand(String id, String nom, String adresse, String adresseEmail) {
        super(id);
        this.nom = nom;
        this.adresse = adresse;
        this.adresseEmail = adresseEmail;
    }
}
