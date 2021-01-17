package com.bank.service;

import java.util.List;

import com.bank.models.User;

public interface UserService {

    public User findUser(Long userid);

    public User findUser(String username);

    public User searchLoginUser(String username, String password);

    public List<User> findAllUsers();

    public User add(User user);

    public User update(User user);

    public void delete(Long userId);
    
}