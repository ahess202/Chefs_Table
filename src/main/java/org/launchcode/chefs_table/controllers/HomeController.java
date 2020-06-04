package org.launchcode.chefs_table.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Dish Search"); //Maybe call it Chef's Table? TBD
        return "index";
    }
}
