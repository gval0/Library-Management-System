package com.librarySystem.Services;

import com.librarySystem.Models.Book;
import com.librarySystem.Models.Transaction;
import com.librarySystem.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService{

    @Autowired
    private BookRepository bookRepo;


    public Book saveBook(Book book){
        return bookRepo.save(book);
    }

    public Optional<Book> getBookById(Long id){
        return bookRepo.findById(id);
    }

    public boolean deleteBookById(Long id){
        Optional<Book> book = this.getBookById(id);
        if (book.isPresent()) {
            bookRepo.deleteById(id);
            return true;
        }
        return false;

    }

    public List<Book> findAllBook(){
        return bookRepo.findAll();
    }

    public Book updateBookInfo(Long id, Book updatedBook){
        return this.getBookById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setISBN(updatedBook.getISBN());
                    book.setGenre(updatedBook.getGenre());
                    book.setIsAvailable(updatedBook.getIsAvailable());
                    this.saveBook(book);
                    return book;
                })
                .orElseGet(() -> null);
    }

    public boolean bookAvailable(Book book) {
        return book.getIsAvailable().equals("Yes");
    }

    public void makeBookUnavailable(Book book) {
        book.setIsAvailable("No");
        this.saveBook(book);
    }

    public boolean  makeBookAvailable(Long bookId){
        Optional<Book> books = this.getBookById(bookId);
        Book book = books.orElse(null);
        if (book == null) {
            return false;
        }
        book.setIsAvailable("Yes");
        this.saveBook(book);
        return true;
    }
}
