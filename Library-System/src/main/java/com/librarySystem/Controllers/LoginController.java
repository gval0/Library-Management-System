package com.librarySystem.Controllers;

import com.librarySystem.Models.User;
import com.librarySystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showLoginPage() {
        return "login";
    }

    @PostMapping
    public ResponseEntity<String> processLogin(@RequestParam String username, @RequestParam String password) {
        User user = userService.getUserByUsername(username);
        boolean isCorrect  = userService.checkPassword(user, password);
        if (isCorrect) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
        }
    }
}
