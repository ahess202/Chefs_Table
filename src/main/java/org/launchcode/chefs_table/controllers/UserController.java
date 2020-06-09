package org.launchcode.chefs_table.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.launchcode.chefs_table.models.Ingredient;
import org.launchcode.chefs_table.models.User;
import org.launchcode.chefs_table.models.data.UserRepository;
import org.launchcode.chefs_table.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    @GetMapping
    public String index(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        model.addAttribute("currentUser", user.getFirstName());
        model.addAttribute("isLoggedIn", (user != null));
        model.addAttribute("title", "Users");
        model.addAttribute("users", userRepository.findAll());
        return "users/index";
    }

    @GetMapping("profile")
    public String displayCurrentUserProfile(Model model, HttpServletRequest request,
                                     HttpServletResponse response,
                                     Object handler) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);



        model.addAttribute("user", user);
        return "/users/profile";
    }

    @GetMapping("view/{userId}")
    public String displaySelectedUserProfile(HttpServletRequest request, Model model, @PathVariable int userId) {
        Optional optUser = userRepository.findById(userId);
        if (optUser.isPresent()) {
            HttpSession session = request.getSession();
            User user = authenticationController.getUserFromSession(session);

            model.addAttribute("currentUser", user.getFirstName());
            model.addAttribute("isLoggedIn", (user != null));

            User user1 = (User) optUser.get();
            model.addAttribute("user", user1);
            return "users/view";
        } else {
            return "redirect:";
        }
    }


}
