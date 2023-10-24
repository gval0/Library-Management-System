package com.librarySystem.Controllers;

import com.librarySystem.Models.Book;
import com.librarySystem.Models.Transaction;
import com.librarySystem.Services.BookService;
import com.librarySystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transService;

    @GetMapping("/overdueBooks/{patronId}")
    public List<Transaction>  getOverdueBooks(@PathVariable Integer patronId){
        return transService.getOverdueTransactionsByPatronId(patronId);
    }

    @GetMapping("/allTransactions")
    public List<Transaction> getTransactions(){
        return transService.getAllTransactions();
    }

    @GetMapping("/overdueBooks")
    public List<Transaction> getOverdueBooks(){
        return transService.getAllTransactions();
    }
}
