package com.parallelbrains.baselayout.controller.view;

import com.parallelbrains.baselayout.config.RouteConfig;
import com.parallelbrains.baselayout.model.User;
import com.parallelbrains.baselayout.service.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController extends BaseController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserDetailsService userDetailsService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = RouteConfig.LOGIN, method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName(RouteConfig.LOGIN_VIEW);

        return modelAndView;
    }

    @RequestMapping(value = RouteConfig.LOGIN_FAILED, method = RequestMethod.GET)
    public ModelAndView loginFailedPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("loginErrorMessage", "Login failed, please try again.");
        modelAndView.setViewName(RouteConfig.LOGIN_VIEW);

        return modelAndView;
    }

    @RequestMapping(value = RouteConfig.PROCESS_REGISTER, method = RequestMethod.POST)
    public String savePerson(@ModelAttribute User user, HttpServletRequest request,
                             HttpServletResponse response) {

        userManager.save(user);

        if (user.getId() != null) { // registration is successful
            autoLoginUser(user);
        } else {
            LOGGER.warn("Registration failed for user {}", user.getEmail());
        }

        return redirectTo("/");
    }

    private void autoLoginUser(User user) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                    userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            LOGGER.error("Couldn't login the user {} automatically: ", user.getEmail(), e);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }

}
