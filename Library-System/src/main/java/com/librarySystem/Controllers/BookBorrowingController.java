package com.librarySystem.Controllers;

import com.librarySystem.Models.Book;
import com.librarySystem.Models.Transaction;
import com.librarySystem.Services.BookService;
import com.librarySystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookBorrow")
public class BookBorrowingController {

    @Autowired
    private TransactionService transService;
    @Autowired
    private BookService bookService;

    @PostMapping("/borrow")
    public ResponseEntity<String> add(@RequestBody Transaction trans){
        Book book = trans.getBook();
        if (bookService.bookAvailable(book)){
            bookService.makeBookUnavailable(book);
            trans.setReturend(false);
            transService.saveTransaction(trans);
            return ResponseEntity.ok("added");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("book can't be borrowed");
    }

    @PostMapping("/librarian/return")
    public ResponseEntity<String> returnBook(@RequestBody Long bookId){
        if (transService.returnBookById(bookId) && bookService.makeBookAvailable(bookId)){
            return ResponseEntity.ok("done");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("book can't be borrowed");
    }
}
