package com.librarySystem.Controllers;

import com.librarySystem.Models.Book;
import com.librarySystem.Models.User;
import com.librarySystem.Services.BookService;
import com.librarySystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book-register")
public class AddBookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String showRegistrationPage() {
        return "/addBook";
    }

    @PostMapping
    public ResponseEntity<String> processRegistration(@Validated Book book) {
        bookService.saveBook(book);
        return ResponseEntity.ok("Book registration successful.");
    }
}
