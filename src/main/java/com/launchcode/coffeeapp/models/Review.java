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

    @ManyToMany
    @NotNull
    private List<Flavor> flavors;

    public Review() {
    }

    public Review(Place aPlace, List<Type> someTypes, List<Flavor> someFlavors) {
        super();
        this.place = aPlace;
        this.types = someTypes;
        this.flavors = someFlavors;
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

    public List<Flavor> getFlavors() {
        return flavors;
    }

    public void setFlavors(List<Flavor> flavors) { this.flavors = flavors; }









}
