package com.parallelbrains.baselayout.controller.view;

import com.parallelbrains.baselayout.config.RouteConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /**
     * Selects the home page and populates the model with a message
     */
    @RequestMapping(value = RouteConfig.HOMEPAGE, method = RequestMethod.GET)
    public String home(Model model) {

        model.addAttribute("controllerMessage", "This project is under development");

        return RouteConfig.HOMEPAGE_VIEW;
    }

}
