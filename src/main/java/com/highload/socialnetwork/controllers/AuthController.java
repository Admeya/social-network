package com.highload.socialnetwork.controllers;

import com.highload.socialnetwork.model.external.UserExt;
import com.highload.socialnetwork.model.persistense.User;
import com.highload.socialnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userRegForm", new UserExt());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userRegForm") UserExt userForm, BindingResult bindingResult, Model model) throws Exception {

        User user = userService.save(userForm);

        return "redirect:/home/" + user.getUserId();
    }
}
