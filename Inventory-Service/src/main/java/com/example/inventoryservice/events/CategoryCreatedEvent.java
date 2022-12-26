package com.example.inventoryservice.events;

public class CategoryCreatedEvent extends BaseEvent<String>{
    private String nom;
    private String description;

    public CategoryCreatedEvent(String id, String nom, String description) {
        super(id);
        this.nom = nom;
        this.description = description;
    }
}
