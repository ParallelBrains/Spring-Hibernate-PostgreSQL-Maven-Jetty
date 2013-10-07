package com.parallelbrains.baselayout.security.impl;

import com.parallelbrains.baselayout.model.User;
import com.parallelbrains.baselayout.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserManager userManager;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));

        User userInDatabase = userManager.get(username);

        org.springframework.security.core.userdetails.User user = null;
        /**
         * Allow the test account, else check if the user's entered password with the password in database
         */
        if (username.equalsIgnoreCase("guest")) {
            user = new org.springframework.security.core.userdetails.User(userInDatabase.getUsername(),
                    "pass", roles);
        } else {
            user = new org.springframework.security.core.userdetails.User(userInDatabase.getUsername(),
                    userInDatabase.getPassword(), roles);
        }

        return user;
    }

}
