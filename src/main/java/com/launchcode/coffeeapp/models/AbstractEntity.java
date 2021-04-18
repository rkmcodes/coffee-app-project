package com.launchcode.coffeeapp.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NotBlank(message = "Summary is Required")
    @Size(min = 1, max = 1000, message ="Summary must be between 1 & 1000 characters")
    private String summary;

    public int getId() {
        return id;
    }

    public String getName() {
        return summary;
    }

    public void setName(String name) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }















}
