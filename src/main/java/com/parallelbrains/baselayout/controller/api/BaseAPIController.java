package com.parallelbrains.baselayout.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

public abstract class BaseAPIController {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseAPIController.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(Exception e) {
        LOGGER.error("Exception: ", e);

        return e.getMessage() != null ? e.getMessage() : e.toString();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public void handleAccessDenied(AccessDeniedException e, HttpServletResponse response) throws Exception {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleInvalidCalls(IllegalArgumentException e, HttpServletResponse response) throws Exception {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }

}
