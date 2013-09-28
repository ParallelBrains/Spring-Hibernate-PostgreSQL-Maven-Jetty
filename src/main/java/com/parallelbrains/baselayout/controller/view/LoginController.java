package com.parallelbrains.baselayout.controller.view;

import com.parallelbrains.baselayout.config.RouteConfig;
import com.parallelbrains.baselayout.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = RouteConfig.LOGIN, method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName(RouteConfig.LOGIN_VIEW);

        return modelAndView;
    }

    @RequestMapping(value = RouteConfig.LOGIN, method = RequestMethod.POST)
    public String loginUser(@ModelAttribute User user) {

        // todo log the user in

        return redirectTo(RouteConfig.HOMEPAGE);
    }

}
