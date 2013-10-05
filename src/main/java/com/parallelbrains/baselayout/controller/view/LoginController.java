package com.parallelbrains.baselayout.controller.view;

import com.parallelbrains.baselayout.config.RouteConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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

//    @RequestMapping(value = RouteConfig.LOGIN, method = RequestMethod.POST)
//    public String loginUser(@ModelAttribute User user,
//                            HttpServletRequest request) {
//
//        AuthenticationManager am = new UserAuthenticationManager();
//
//        try {
//            Authentication authRequest = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
//            Authentication result = am.authenticate(authRequest);
//            SecurityContextHolder.getContext().setAuthentication(result);
//        } catch(AuthenticationException e) {
//            LOGGER.error("Authentication failed: " + e.getMessage());
//
//            return redirectTo("/fail");
//        }
//
//        String referer = request.getHeader("Referer");
//
//        return "redirect:"+ referer;
//    }

}
