package com.fhyd.userManagement.controllers;

import com.fhyd.userManagement.models.Group;
import com.fhyd.userManagement.models.User;
import com.fhyd.userManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        model.addAttribute("user", new User());
        return "users";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateGroup(@ModelAttribute User user) {
       userService.updateUser(user);
        return "redirect:/users/";
    }

    @RequestMapping("/edit/{id}")
    public String editGroup(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }
}
