package com.librarySystem.Models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;

    private Date borrowDate;

    private Date dueDate;

    private Date returnDate;

    private boolean isReturend;

    public Transaction() {
    }

    public Transaction(Long id, Book book, Patron patron, Date borrowDate, Date dueDate, Date returnDate, boolean isReturend) {
        this.id = id;
        this.book = book;
        this.patron = patron;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.isReturend = isReturend;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturend() {
        return isReturend;
    }

    public void setReturend(boolean returend) {
        isReturend = returend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return isReturend == that.isReturend && Objects.equals(id, that.id) && Objects.equals(book, that.book) && Objects.equals(patron, that.patron) && Objects.equals(borrowDate, that.borrowDate) && Objects.equals(dueDate, that.dueDate) && Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, patron, borrowDate, dueDate, returnDate, isReturend);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", book=" + book +
                ", patron=" + patron +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", isReturend=" + isReturend +
                '}';
    }
}
