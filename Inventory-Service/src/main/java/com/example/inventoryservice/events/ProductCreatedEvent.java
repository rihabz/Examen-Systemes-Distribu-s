package com.example.inventoryservice.events;

public class ProductCreatedEvent extends BaseEvent<String>{
    private String nom;
    private String description;

    public ProductCreatedEvent(String id, String nom, String description) {
        super(id);
        this.nom = nom;
        this.description = description;
    }
}
