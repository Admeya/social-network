package com.highload.socialnetwork.controllers;

import com.highload.socialnetwork.model.external.SearchExt;
import com.highload.socialnetwork.model.external.UserExt;
import com.highload.socialnetwork.model.mapper.UserExt2UserMapper;
import com.highload.socialnetwork.model.persistense.User;
import com.highload.socialnetwork.services.SearchService;
import com.highload.socialnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private UserService userService;
    private SearchService searchService;

    @Autowired
    public UserController(UserService userService, SearchService searchService) {
        this.userService = userService;
        this.searchService = searchService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        UserExt userInfo = new UserExt();
        userInfo.setUsername("FirstUser");
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("userSearchForm", new SearchExt());
        return "home";
    }

    @GetMapping({"/home/{id}"})
    public String home(Model model, @PathVariable Long id) {
        User user = userService.viewUser(id);
        UserExt userInfo = UserExt2UserMapper.map(user);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("userSearchForm", new SearchExt());
        return "home";
    }

    @PostMapping({"/"})
    public String search(@ModelAttribute("userSearchForm") SearchExt searchForm, Model model) {
        List<User> findedUsers = searchService.search(searchForm);
        List<UserExt> externalUserModelList = findedUsers.stream()
                .map(UserExt2UserMapper::map)
                .collect(Collectors.toList());

        model.addAttribute("searchList", externalUserModelList);
        return "search";
    }
}
