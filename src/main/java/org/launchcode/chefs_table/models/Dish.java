package org.launchcode.chefs_table.models;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Dish extends AbstractEntity {

    @NotNull
    @NotBlank(message = "Must Enter a name!")
    private String name;

    @NotNull
    @Size(min = 1, max = 250)
    private String shortDescription;

    @NotNull
    @Column(length=5000)
    @Size(min = 1)
    private String directions;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    private String totalTime;

    @NotNull
    private String timeType;

    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();

    //TODO Make hashmap
    @NotNull
    @ElementCollection
    private List<String> ingredientQuantities = new ArrayList<>();

    @NotNull
    private String cuisineType;

    @NotNull
    private int numServings;

    @NotNull
    private String dishImage;

    public Dish() {}

    public Dish(String name, @Size(min = 10, max = 30) String shortDescription, User user, String totalTime, List<Ingredient> ingredients, String cuisineType, int numServings, String dishImage, String directions, String timeType, List<String> ingredientQuantities) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.user = user;
        this.totalTime = totalTime;
        this.ingredients = ingredients;
        this.cuisineType = cuisineType;
        this.numServings = numServings;
        this.dishImage = dishImage;
        this.directions = directions;
        this.timeType = timeType;
        this.ingredientQuantities = ingredientQuantities;
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

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User author) {
        this.user = author;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public List<Ingredient> getIngredientList() {
        return ingredients;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredients = ingredientList;
    }

    public List<String> getIngredientQuantities() {
        return ingredientQuantities;
    }

    public void setIngredientQuantities(List<String> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDishImage() {
        return dishImage;
    }

    public void setDishImage(String dishImage) {
        this.dishImage = dishImage;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }
}
