package com.launchcode.coffeeapp.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Review extends AbstractEntity {

    @ManyToOne
    private Place place;

    @ManyToMany
    @NotNull
    private List<Type> types;

    public Review() {
    }

    public Review(Place aPlace, List<Type> someTypes) {
        super();
        this.place = aPlace;
        this.types = someTypes;
    }

    // Getters and setters.

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) { this.types = types; }









}
