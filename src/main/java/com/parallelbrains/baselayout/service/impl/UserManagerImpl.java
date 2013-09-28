package com.parallelbrains.baselayout.service.impl;

import com.parallelbrains.baselayout.service.UserManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service(value = "userManager")
public class UserManagerImpl implements UserManager {

    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            return (User) authentication.getPrincipal();
        } else {
            return null;
        }
    }
}
