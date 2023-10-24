package com.librarySystem.Controllers;


import com.librarySystem.Models.Book;
import com.librarySystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> showBookList() {
        return bookService.findAllBook();
    }

    @GetMapping("/bookProfile/{id}")
    public Book getBookProfile(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.orElse(null);
    }

    @PutMapping("/librarian/bookProfile/edit/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Book book = bookService.updateBookInfo(id, updatedBook);
        if (book == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }


    @DeleteMapping("/librarian/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.deleteBookById(id);
        System.out.println(deleted);
        if (deleted) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.notFound().build();
    }
}
