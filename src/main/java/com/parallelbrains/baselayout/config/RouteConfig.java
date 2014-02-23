package com.parallelbrains.baselayout.config;

/**
 * URL Mappings that Spring is supposed to intercept
 *
 * View (jsp) names that Spring needs to redirect the request
 */
public class RouteConfig {

    /**
     * Homepage
     */
    // Mapping
    public static final String HOMEPAGE = "/"; // GET

    // Views
    public static final String HOMEPAGE_VIEW = "home";

    /**
     * Login
     */
    // Mappings
    public static final String LOGIN = "/login";
    public static final String LOGIN_FAILED = "/login-failed";
    public static final String PROCESS_REGISTER = "/process-register"; // POST

    // Views
    public static final String LOGIN_VIEW = "login";

    /**
     * Person
     */
    // Base View Mapping
    public static final String PERSON_BASE_MAPPING = "/person";
    public static final String USER_BASE_MAPPING = "/user";

    // Sub View Mappings
    public static final String PERSON_EDIT = "edit"; // GET, POST
    public static final String PERSON_LIST = "list"; // GET
    public static final String PERSON_DELETE = "delete";

    public static final String USER_EDIT = "edit"; // GET, POST
    public static final String USER_LIST = "list"; // GET
    public static final String USER_DELETE = "delete";

    // Views
    public static final String PERSON_EDIT_VIEW = "edit";
    public static final String PERSON_LIST_VIEW = "list";

    public static final String USER_EDIT_VIEW = "edit";
    public static final String USER_LIST_VIEW = "list";

    // API Mappings
    public static final String BASE_API_URL = "/api";

    public static final String PERSON_API_BASE_URL = "/people"; // GET, POST
    public static final String PERSON_API_SINGLE_PERSON_URL = "/{id}"; // GET, PUT, DELETE

    public static final String USER_API_BASE_URL = "/users"; // GET, POST
    public static final String USER_API_SINGLE_PERSON_URL = "/{id}"; // GET, PUT, DELETE
}
