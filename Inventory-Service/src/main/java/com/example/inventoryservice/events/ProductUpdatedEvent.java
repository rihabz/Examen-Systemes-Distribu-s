package com.example.inventoryservice.events;

public class ProductUpdatedEvent extends BaseEvent<String>{
    private String nom;
    private String description;

    public ProductUpdatedEvent(String id, String nom, String description) {
        super(id);
        this.nom = nom;
        this.description = description;
    }
}
