package com.parallelbrains.baselayout.service;

import org.springframework.security.core.userdetails.User;

public interface UserManager {

    User getLoggedInUser();

}
