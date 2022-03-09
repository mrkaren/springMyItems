package com.example.springmyitems.controller;

import com.example.springmyitems.entity.User;
import com.example.springmyitems.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/addUser")
    public String addUserPage() {
        return "saveUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/editUser/{id}")
    public String editUserPage(ModelMap map,
                               @PathVariable("id") int id) {
        map.addAttribute("user", userService.findById(id));
        return "saveUser";

    }
}
