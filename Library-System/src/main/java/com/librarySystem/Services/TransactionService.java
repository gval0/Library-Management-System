package com.librarySystem.Services;

import com.librarySystem.Models.Book;
import com.librarySystem.Models.Transaction;
import com.librarySystem.Repositories.BookRepository;
import com.librarySystem.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.TrustAnchor;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transRepo;


    public Transaction saveTransaction(Transaction trans){
        return transRepo.save(trans);
    }



    public List<Transaction> getOverdueTransactionsByPatronId(Integer patronId) {
        return transRepo.findOverdueTransactionsByPatronId(patronId);
    }

    public Transaction getTransctionByBookId(Long bookId) {
        Optional<Transaction> transaction = transRepo.findLastTransactionByBookId(bookId);
        return transaction.orElse(null);
    }

    public boolean returnBookById(Long bookId) {
        Transaction transaction = this.getTransctionByBookId(bookId);
        if (transaction == null){
            return false;
        }
        transaction.setReturend(true);
        this.saveTransaction(transaction);
        return true;
    }

    public List<Transaction> getAllTransactions() {
        return transRepo.findAll();
    }
}
