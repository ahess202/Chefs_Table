package org.launchcode.chefs_table.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.launchcode.chefs_table.models.User;
import org.launchcode.chefs_table.models.data.UserRepository;
import org.launchcode.chefs_table.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    @GetMapping("profile")
    public String displayUserProfile(Model model, HttpServletRequest request,
                                     HttpServletResponse response,
                                     Object handler) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);



        model.addAttribute("user", user);
        return "/users/profile";
    }


}
