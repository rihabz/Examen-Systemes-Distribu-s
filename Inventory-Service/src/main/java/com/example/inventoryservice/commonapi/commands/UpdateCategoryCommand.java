package com.example.inventoryservice.commonapi.commands;

public class UpdateCategoryCommand extends BaseCommand<String> {
    private String nom;
    private String description;

    public UpdateCategoryCommand(String id, String nom, String description) {
        super(id);
        this.nom = nom;
        this.description = description;
    }
}
