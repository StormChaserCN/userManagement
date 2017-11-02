package com.fhyd.userManagement.services;

import com.fhyd.userManagement.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void deleteUser(Long id);
    void addUser(User u);
    void updateUser(User u);
    User getUserById(Long id);
}
