package org.launchcode.chefs_table.controllers;

import org.launchcode.chefs_table.models.Ingredient;
import org.launchcode.chefs_table.models.User;
import org.launchcode.chefs_table.models.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping
    public String index(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        model.addAttribute("currentUser", user.getFirstName());
        model.addAttribute("isLoggedIn", (user != null));
        model.addAttribute("title", "Ingredients");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients/index";
    }

    @GetMapping("add")
    public String displayAddIngredientForm(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        model.addAttribute("currentUser", user.getFirstName());
        model.addAttribute("isLoggedIn", (user != null));
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

    @GetMapping("view/{ingredientId}")
    public String displayViewIngredient(HttpServletRequest request, Model model, @PathVariable int ingredientId) {

        Optional optIngredient = ingredientRepository.findById(ingredientId);
        if (optIngredient.isPresent()) {
            HttpSession session = request.getSession();
            User user = authenticationController.getUserFromSession(session);

            model.addAttribute("currentUser", user.getFirstName());
            model.addAttribute("isLoggedIn", (user != null));
            Ingredient ingredient = (Ingredient) optIngredient.get();
            model.addAttribute("ingredient", ingredient);
            model.addAttribute("title", ingredient.getName());
            return "ingredients/view";
        } else {
            return "redirect:";
        }
    }
}
