package com.librarySystem.Services;

import com.librarySystem.Models.Book;
import com.librarySystem.Models.Patron;
import com.librarySystem.Models.User;
import com.librarySystem.Repositories.BookRepository;
import com.librarySystem.Repositories.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronService {
        @Autowired
        private PatronRepository patronRepo;

        public Patron savePatron(Patron patron, User user){
            if (patron == null){
                Patron p = new Patron();
                p.setMembershipStatus("Active");
                p.setUser(user);
                return patronRepo.save(p);
            }
            return patronRepo.save(patron);
        }

    public List<Patron> findAllPatron() {
        return patronRepo.findAll();
    }

    public Optional<Patron> getPatronById(Integer id) {
        return patronRepo.findById(id);
    }

    public Patron updatePatronInfo(Integer id, Patron updatedPatron) {
        return this. getPatronById(id)
                .map(patron -> {
                    patron.setUser(updatedPatron.getUser());
                    patron.setName(updatedPatron.getName());
                    patron.setMail(updatedPatron.getMail());
                    patron.setMembershipStatus(updatedPatron.getMembershipStatus());
                    this.savePatron(patron, patron.getUser());
                    return patron;
                })
                .orElseGet(() -> null);
    }

    public Optional<Patron> getPatronById(Long id){
        return patronRepo.findById(Math.toIntExact(id));
    }

    public boolean deletePatronById(Long id) {
        Optional<Patron> patron = this.getPatronById(id);
        if (patron.isPresent()) {
            patronRepo.deleteById(Math.toIntExact(id));
            return true;
        }
        return false;
    }
}
