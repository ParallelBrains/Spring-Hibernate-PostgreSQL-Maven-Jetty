package com.parallelbrains.baselayout.controller.api;

import com.parallelbrains.baselayout.config.RouteConfig;
import com.parallelbrains.baselayout.security.impl.AuthenticationManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginAPIController extends BaseAPIController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginAPIController.class);

    @RequestMapping(value = RouteConfig.LOGIN, method = RequestMethod.POST)
    public void loginUser(@RequestParam(value = "username", required = true) String username,
                            @RequestParam(value = "password", required = true) String password,
                            HttpServletRequest request) {

        AuthenticationManager authenticationManager = new AuthenticationManagerImpl();

        try {
            Authentication authRequest = new UsernamePasswordAuthenticationToken(username, password);
            Authentication result = authenticationManager.authenticate(authRequest);
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (AuthenticationException e) {
            LOGGER.error("Authentication failed: {}", e);
        }

        LOGGER.debug("Successfully authenticated. Security context contains: {}",
                SecurityContextHolder.getContext().getAuthentication());
    }

}
