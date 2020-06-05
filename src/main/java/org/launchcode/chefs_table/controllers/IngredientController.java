package org.launchcode.chefs_table.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ingredients")
public class IngredientController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "Ingredients");
        return "ingredients/index";
    }
}
