package com.parallelbrains.baselayout.service;

import com.parallelbrains.baselayout.model.User;

import java.util.List;

public interface UserManager {

    User get(Long id) ;

    User get(String username) ;

    List<User> getAll();

    void save(User user);

    void delete(Long id);

    org.springframework.security.core.userdetails.User getLoggedInUser();

}
