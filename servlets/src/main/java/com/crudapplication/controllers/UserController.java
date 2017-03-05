package com.crudapplication.controllers;

import com.crudapplication.model.User;
import com.crudapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Aleksandr_Shakhov on 05.03.17 21:23.
 */

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(name = "users", method = RequestMethod.GET)
    public String listAllUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", this.userService.getAllUsers());
        return "users";
    }

    @RequestMapping(name = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == 0) {
            this.userService.addUser(user);
        } else {
            this.userService.updateUser(user);
        }
        return "redirect:/users";
    }

    @RequestMapping("/delete/${id}")
    public String deleteUser(@PathVariable("id") int id) {
        this.userService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping("/edit/${id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute(this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.getAllUsers());

        return "users";
    }

    @RequestMapping("/userdata/${id}")
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        return "userdata";
    }
}
