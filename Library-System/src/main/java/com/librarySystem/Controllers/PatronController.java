package com.librarySystem.Controllers;

import com.librarySystem.Models.Book;
import com.librarySystem.Models.Patron;
import com.librarySystem.Services.BookService;
import com.librarySystem.Services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/patron")
public class PatronController {

    @Autowired
    private PatronService patronService;

    @GetMapping("/list")
    public List<Patron> showPatronList() {
        return patronService.findAllPatron();
    }

    @GetMapping("/patronProfile/{id}")
    public Patron getPatronProfile(@PathVariable Integer id) {
        Optional<Patron> patron = patronService.getPatronById(id);
        return patron.orElse(null);
    }

    @PutMapping("/patronProfile/edit/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Integer id, @RequestBody Patron updatedPatron) {
        Patron patron = patronService.updatePatronInfo(id, updatedPatron);
        if (patron == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patron);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatron(@PathVariable Long id) {
        boolean deleted = patronService.deletePatronById(id);
        if (deleted) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.notFound().build();
    }

}
