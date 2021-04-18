package com.launchcode.coffeeapp.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Place extends AbstractEntity {

    @OneToMany
    @JoinColumn(name = "place_id")
    private List<Review> reviews = new ArrayList<>();

    @NotBlank(message = "Coffee place is required")
    @Size(min = 1, max = 50, message ="place must be between 1 & 50 characters")
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Place(String n) {
        this.location = n;
    }

    public Place() {}

}
