package com.parallelbrains.baselayout.controller.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController {

    private static final String SPRING_REDIRECT = "redirect:";

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    protected String redirectTo(String viewToRedirect) {
        return SPRING_REDIRECT + viewToRedirect;
    }

}
