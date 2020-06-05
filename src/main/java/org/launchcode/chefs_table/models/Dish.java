package org.launchcode.chefs_table.models;


import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;

@Entity
public class Dish extends AbstractEntity {

    @NotNull
    private String name;

    @NotNull
    @Size(min = 10, max = 30)
    private String shortDescription;

    @NotNull
    private String author;

    @NotNull
    private String totalTime;

    @NotNull
    @ElementCollection
    private List<String> ingredientList = new ArrayList<String>();

    @NotNull
    private String cuisineType;

    @NotNull
    private int numServings;

    public Dish() {}

    public Dish(String name, @Size(min = 10, max = 30) String shortDescription, String author, String totalTime, List<String> ingredientList, String cuisineType, int numServings) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.author = author;
        this.totalTime = totalTime;
        this.ingredientList = ingredientList;
        this.cuisineType = cuisineType;
        this.numServings = numServings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public List<String> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<String> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public int getNumServings() {
        return numServings;
    }

    public void setNumServings(int numServings) {
        this.numServings = numServings;
    }
}
