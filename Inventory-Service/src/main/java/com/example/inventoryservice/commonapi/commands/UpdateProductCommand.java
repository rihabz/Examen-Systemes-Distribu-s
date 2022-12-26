package com.example.inventoryservice.commonapi.commands;

import com.example.inventoryservice.commonapi.enums.ProctStatus;

public class UpdateProductCommand extends BaseCommand<String> {
    private String nom;
    private String description;
    private double prix;
    private int qte;
    private ProctStatus proctStatus;

    public UpdateProductCommand(String id, String nom, String description, double prix, int qte, ProctStatus proctStatus) {
        super(id);
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.qte = qte;
        this.proctStatus = proctStatus;
    }
}
