package org.launchcode.chefs_table.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.launchcode.chefs_table.models.User;
import org.launchcode.chefs_table.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    AuthenticationController authenticationController;

    @GetMapping
    public String index(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        model.addAttribute("currentUserObj", user);
        model.addAttribute("currentUser", user.getFirstName());
        model.addAttribute("isLoggedIn", (user != null));
        model.addAttribute("title", "Welcome to the Chef's Table!");
        return "index";
    }
}
