package org.launchcode.chefs_table.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dishes")
public class DishController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "Dishes");
        return "dishes/index";
    }

}
