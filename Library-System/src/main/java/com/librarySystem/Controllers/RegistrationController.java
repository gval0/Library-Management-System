package com.librarySystem.Controllers;


import com.librarySystem.Models.Patron;
import com.librarySystem.Models.User;
import com.librarySystem.Services.PatronService;
import com.librarySystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private PatronService patronService;
    @GetMapping
    public String showRegistrationPage() {
        return "registration";
    }

    @PostMapping
    public ResponseEntity<String> processRegistration(@Validated User user) {
        User userDatabase = userService.getUserByUsername(user.getUsername());
        if (userDatabase != null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username is already registered. Please choose a different username.");
        }
        userService.saveUser(user);
        return ResponseEntity.ok("Registration successful. You can now log in.");
    }
}
