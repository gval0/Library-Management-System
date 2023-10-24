package com.librarySystem.Services;

import com.librarySystem.Models.User;
import com.librarySystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{
    @Autowired
    private UserRepository userRepo;
    @Override
    public User saveUser(User user){
        return userRepo.save(user);
    }

    public User getUserByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public boolean checkPassword(User user, String providedPassword) {
        return user != null && user.getPassword().equals(providedPassword);
    }

    public List<User> getAllLibrarianUsers(){
        return userRepo.findAllByRole("LIBRARIAN");
    }
}
