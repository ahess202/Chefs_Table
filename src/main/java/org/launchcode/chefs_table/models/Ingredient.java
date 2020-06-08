package org.launchcode.chefs_table.models;



import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private List<Dish> dishes = new ArrayList<>();

    public Ingredient() {}

    public Ingredient(String name, List<Dish> dishes) {
        this.name = name;
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return name;
    }
}
