package org.launchcode.chefs_table.controllers;

import org.launchcode.chefs_table.models.Dish;
import org.launchcode.chefs_table.models.Ingredient;
import org.launchcode.chefs_table.models.User;
import org.launchcode.chefs_table.models.data.DishRepository;
import org.launchcode.chefs_table.models.data.IngredientRepository;
import org.launchcode.chefs_table.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("dishes")
public class DishController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("")
    public String index(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        model.addAttribute("currentUser", user.getFirstName());
        model.addAttribute("isLoggedIn", (user != null));

        model.addAttribute("title", "Dishes");
        model.addAttribute("dishes", dishRepository.findAll());

        return "dishes/index";
    }

    @GetMapping("add")
    public String displayAddDishForm(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        model.addAttribute("currentUser", user.getFirstName());
        model.addAttribute("isLoggedIn", (user != null));
        model.addAttribute("title", "Add Dish");
        model.addAttribute(new Dish());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "dishes/add";
    }
    @PostMapping("add")
    public String processAddDishForm(@ModelAttribute @Valid Dish newDish,
                                    Errors errors, Model model, @RequestParam int userId, @RequestParam List<Integer> ingredients) {

        model.addAttribute("title", "Add Dish");

        if (errors.hasErrors()) {
            model.addAttribute("ingredients", ingredientRepository.findAll());
            model.addAttribute("users", userRepository.findAll());
            model.addAttribute("title", "Add Dish");
            return "dishes/add";
        }
        List<Ingredient> ingredientObjs = (List<Ingredient>) ingredientRepository.findAllById(ingredients);

        newDish.setUser(userRepository.findById(userId).get());
        newDish.setIngredientList(ingredientObjs);

        dishRepository.save(newDish);
        return "redirect:";
    }

    @GetMapping("/view/{dishId}")
    public String displayViewDish(HttpServletRequest request, Model model, @PathVariable int dishId) {
        Optional optDish = dishRepository.findById(dishId);
        if (optDish.isPresent()) {
            HttpSession session = request.getSession();
            User user = authenticationController.getUserFromSession(session);

            model.addAttribute("currentUser", user.getFirstName());
            model.addAttribute("isLoggedIn", (user != null));

            Dish dish = (Dish) optDish.get();
            model.addAttribute("dish", dish);
            return "dishes/view";
        } else {
            return "redirect:";
        }
    }

}
