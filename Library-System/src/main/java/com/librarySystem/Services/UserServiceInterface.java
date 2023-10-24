package com.librarySystem.Services;

import com.librarySystem.Models.User;

import java.util.List;

public interface UserServiceInterface {
    public User saveUser(User user);

    public List<User> getAllLibrarianUsers();
}
