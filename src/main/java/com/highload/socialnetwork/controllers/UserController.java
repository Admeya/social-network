package com.highload.socialnetwork.controllers;

import com.highload.socialnetwork.model.external.UserExt;
import com.highload.socialnetwork.model.mapper.UserExt2UserMapper;
import com.highload.socialnetwork.model.persistense.User;
import com.highload.socialnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        UserExt userInfo = new UserExt();
        userInfo.setUsername("FirstUser");
        model.addAttribute("userInfo", userInfo);
        return "home";
    }

    @GetMapping({"/home/{id}"})
    public String home(Model model, @PathVariable Long id) {
        User user = userService.viewUser(id);
        UserExt userInfo = UserExt2UserMapper.map(user);
        model.addAttribute("userInfo", userInfo);
        return "home";
    }
}
