package com.example.inventoryservice.events;

public class CategoryUpdatedEvent extends BaseEvent<String>{
    private String nom;
    private String description;

    public CategoryUpdatedEvent(String id, String nom, String description) {
        super(id);
        this.nom = nom;
        this.description = description;
    }
}
