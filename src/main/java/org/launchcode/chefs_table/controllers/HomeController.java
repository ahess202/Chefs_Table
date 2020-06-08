package org.launchcode.chefs_table.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "Our Chefs To Follow");
        return "index";
    }
}
