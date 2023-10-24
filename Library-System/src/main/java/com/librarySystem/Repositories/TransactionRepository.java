package com.librarySystem.Repositories;

import com.librarySystem.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.patron.id = :patronId AND t.isReturend = false AND t.dueDate < current_date")
    List<Transaction> findOverdueTransactionsByPatronId(@Param("patronId") Integer patronId);

    @Query("SELECT t FROM Transaction t WHERE t.book.id = :bookId ORDER BY t.returnDate DESC")
    Optional<Transaction> findLastTransactionByBookId(@Param("bookId") Long bookId);
}
