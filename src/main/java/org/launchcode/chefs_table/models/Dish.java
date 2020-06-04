package org.launchcode.chefs_table.models;


import com.sun.istack.NotNull;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Dish extends AbstractEntity {

    @NotNull
    private String name;

    @NotNull
//    @Size(min = 10, max = 30)
    private String shortDescription;

//    @OneToOne
//    private DishDetails dishDetails;

    //    @ManyToMany
    private List<Ingredient> ingredientList;

}
