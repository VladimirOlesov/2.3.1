package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping({"/users"})
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/list"})
    public String listUsers(Model model) {
        model.addAttribute("listUsers", this.userService.getAllUsers());
        return "/list";
    }

    @GetMapping({"/new"})
    public String newUser(@ModelAttribute("user") User user) {
        return "/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        this.userService.addUser(user);
        return "redirect:/list";
    }

    @GetMapping({"/{id}/edit"})
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", this.userService.getUser(id));
        return "/edit";
    }

    @PatchMapping({"/{id}"})
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        this.userService.getUser(id);
        this.userService.updateUser(user);
        return "redirect:/list";
    }

    @DeleteMapping({"/{id}"})
    public String delete(@PathVariable("id") Long id) {
        this.userService.deleteUserById(id);
        return "redirect:/list";
    }
}