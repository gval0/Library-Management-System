package com.librarySystem.Controllers;

import com.librarySystem.Models.Patron;
import com.librarySystem.Models.User;
import com.librarySystem.Services.PatronService;
import com.librarySystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/librarian")
public class LibrarianController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-list")
    public List<User> showPatronList() {
        return userService.getAllLibrarianUsers();
    }
}
