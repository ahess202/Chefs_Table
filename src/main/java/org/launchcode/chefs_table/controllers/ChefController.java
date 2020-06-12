package org.launchcode.chefs_table.controllers;

import org.launchcode.chefs_table.models.User;
import org.launchcode.chefs_table.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("chefs")
public class ChefController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String index(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        model.addAttribute("currentUserObj", user);
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("currentUser", user.getFirstName());
        model.addAttribute("isLoggedIn", (user != null));
        model.addAttribute("title", "Meet The Chefs");
        return "/chefs/index";
    }
}
