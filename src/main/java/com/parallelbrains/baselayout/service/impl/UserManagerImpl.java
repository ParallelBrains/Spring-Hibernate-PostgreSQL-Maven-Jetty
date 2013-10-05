package com.parallelbrains.baselayout.service.impl;

import com.parallelbrains.baselayout.model.User;
import com.parallelbrains.baselayout.repository.UserDao;
import com.parallelbrains.baselayout.service.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userManager")
@Transactional(propagation = Propagation.REQUIRED)
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDao userDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonManagerImpl.class);

    public User get(Long id) {
        return userDao.get(id);
    }

    public User get(String username) {
        return userDao.get(username);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void delete(Long id) {
        userDao.delete(id);
    }

    public org.springframework.security.core.userdetails.User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null &&
                authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User) {
            return (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        } else {
            return null;
        }
    }
}
