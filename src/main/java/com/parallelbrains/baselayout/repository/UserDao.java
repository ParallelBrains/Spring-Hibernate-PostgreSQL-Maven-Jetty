package com.parallelbrains.baselayout.repository;

import com.parallelbrains.baselayout.model.User;

import java.util.List;

public interface UserDao {

    User get(Long id) ;

    User get(String username);

    List<User> getAll();

    void save(User user);

    void delete(Long id);

}
