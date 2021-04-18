package com.launchcode.coffeeapp.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Type extends AbstractEntity  {

    @ManyToMany(mappedBy = "types")
    @NotNull
    private List<Review> reviews = new ArrayList<>();

    @NotBlank(message = "Coffee type is required")
    @Size(min = 1, max = 100, message ="Coffee type must be between 1 & 100 characters")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type(String n) {
        this.description = n;
    }

    public Type() {}











}
