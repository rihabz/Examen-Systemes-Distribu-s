package com.example.customerservice1.commonapi.commands;

import lombok.Getter;

public class UpdateCustomerCommand extends BaseCommand<String> {
    @Getter
    private String nom;
    @Getter
    private String adresse;
    @Getter
    private String adresseEmail;

    public UpdateCustomerCommand(String id, String nom, String adresse, String adresseEmail) {
        super(id);
        this.nom = nom;
        this.adresse = adresse;
        this.adresseEmail = adresseEmail;
    }
}
