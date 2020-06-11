package org.launchcode.chefs_table.models;

import java.util.ArrayList;
import java.util.List;


public class IngredientQuantities {

    private List<String> ingredientQuantities = new ArrayList<>();

    public IngredientQuantities(List<String> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
    }

    public List<String> getIngredientQuantities() {
        return ingredientQuantities;
    }

    public void setIngredientQuantities(List<String> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
    }
}

