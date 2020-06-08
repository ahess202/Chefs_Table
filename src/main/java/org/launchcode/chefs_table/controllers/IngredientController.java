package org.launchcode.chefs_table.controllers;

import org.launchcode.chefs_table.models.Ingredient;
import org.launchcode.chefs_table.models.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "Ingredients");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients/index";
    }

    @GetMapping("add")
    public String displayAddIngredientForm(Model model) {
        model.addAttribute(new Ingredient());
        return "ingredients/add";
    }

    @PostMapping("add")
    public String processAddIngredientForm(@ModelAttribute @Valid Ingredient newIngredient,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "ingredients/add";
        }

        ingredientRepository.save(newIngredient);
        return "redirect:";
    }
}
