package org.example.mvc.controller;


import org.example.mvc.entity.User;
import org.example.mvc.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SpringController {

    @Autowired
    private SpringService service;

    @RequestMapping("/")
    public String showAll(Model model) {
        List<User> allUsers = service.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "hello";
    }

    @RequestMapping("/addNew")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create";
    }

    @RequestMapping("/saveuser")
    public String saveUser(@ModelAttribute("user") User user) {
        service.createUser(user);
        return "redirect:/";
    }

    @RequestMapping("/update")
    public String updateUser(@RequestParam("user-ID") int id, Model model) {
        User user = service.getUser(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        model.addAttribute("user", user);
        return "create";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("user-ID") int id) {
        service.deleteUser(id);
        return "redirect:/";
    }
}
