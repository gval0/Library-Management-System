package com.librarySystem.Controllers;

import com.librarySystem.Models.User;
import com.librarySystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/details")
    public String showUserDetailsPage() {
        return "/userDetails";
    }

    @PostMapping("/insert")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "user added";
    }
}
