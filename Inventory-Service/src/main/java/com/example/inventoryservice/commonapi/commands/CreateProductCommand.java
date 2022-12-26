package com.example.inventoryservice.commonapi.commands;

import com.example.inventoryservice.commonapi.enums.ProctStatus;
import lombok.Getter;

public class CreateProductCommand extends BaseCommand<String> {
    private String nom;
    private String description;
    private double prix;
    private int qte;
    private ProctStatus proctStatus;

    public CreateProductCommand(String id, String nom, String description, double prix, int qte, ProctStatus proctStatus) {
        super(id);
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.qte = qte;
        this.proctStatus = proctStatus;
    }
}
