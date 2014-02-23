package com.parallelbrains.baselayout.controller.view;

import com.parallelbrains.baselayout.config.RouteConfig;
import com.parallelbrains.baselayout.model.User;
import com.parallelbrains.baselayout.service.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(RouteConfig.USER_BASE_MAPPING)
public class UserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = RouteConfig.USER_EDIT, method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam(value = "id", required = false) Long id) {
        LOGGER.debug("Received request to edit user id : " + id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(RouteConfig.USER_EDIT_VIEW);

        User user = userManager.get(id);

        modelAndView.addObject("user", user == null ? new User() : user);

        return modelAndView;
    }

    @RequestMapping(value = RouteConfig.USER_EDIT, method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        LOGGER.debug("Received postback on user " + user);

        userManager.save(user);

        return redirectTo(RouteConfig.USER_LIST);

    }

    @RequestMapping(value = RouteConfig.USER_LIST, method = RequestMethod.GET)
    public ModelAndView listPeople() {
        LOGGER.debug("Received request to list users");

        ModelAndView modelAndView = new ModelAndView();

        List<User> users = userManager.getAll();

        LOGGER.debug("User Listing count = " + users.size());

        modelAndView.addObject("users", users);
        modelAndView.setViewName(RouteConfig.USER_LIST_VIEW);

        org.springframework.security.core.userdetails.User loggedInUser = userManager.getLoggedInUser();

        if (loggedInUser != null) {
            modelAndView.addObject("loggedInUserName", userManager.getLoggedInUser().getUsername());
        }

        userManager.getLoggedInUser();

        return modelAndView;
    }

    @RequestMapping(value = RouteConfig.USER_DELETE, method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute User user) {
        LOGGER.debug("Deleting user " + user);

        userManager.delete(user.getId());

        return redirectTo(RouteConfig.USER_LIST);
    }

}
