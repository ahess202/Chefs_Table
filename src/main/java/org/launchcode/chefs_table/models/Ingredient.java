package org.launchcode.chefs_table.models;


import com.sun.istack.NotNull;

import javax.persistence.Entity;

@Entity
public class Ingredient extends AbstractEntity {

    @NotNull
    private String name;

    public Ingredient() {}

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
