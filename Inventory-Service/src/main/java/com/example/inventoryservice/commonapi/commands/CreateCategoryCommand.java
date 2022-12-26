package com.example.inventoryservice.commonapi.commands;

import com.example.inventoryservice.commonapi.enums.ProctStatus;

public class CreateCategoryCommand extends BaseCommand<String> {
    private String nom;
    private String description;

    public CreateCategoryCommand(String id, String nom, String description) {
        super(id);
        this.nom = nom;
        this.description = description;
    }
}
