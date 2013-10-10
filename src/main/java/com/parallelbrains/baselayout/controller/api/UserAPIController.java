package com.parallelbrains.baselayout.controller.api;

import com.parallelbrains.baselayout.config.RouteConfig;
import com.parallelbrains.baselayout.model.User;
import com.parallelbrains.baselayout.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = RouteConfig.BASE_API_URL)
public class UserAPIController extends BaseAPIController {

    @Autowired
    private UserManager userManager;

    @ResponseBody
    @RequestMapping(value = RouteConfig.USER_API_LIST_PEOPLE_URL, method = RequestMethod.GET,
            produces = "application/json")
    public List<User> getUsers() throws Exception {
        return userManager.getAll();
    }

    @ResponseBody
    @RequestMapping(value = RouteConfig.USER_API_SINGLE_PERSON_URL, method = RequestMethod.GET,
            produces = "application/json")
    public User getUser(@PathVariable Long id) throws Exception {
        return userManager.get(id);
    }

    @ResponseBody
    @RequestMapping(value = RouteConfig.USER_API_SINGLE_PERSON_URL, method = RequestMethod.PUT,
            produces = "application/json")
    public User updateUser(@RequestBody User userWithNewValues) throws Exception {
        userManager.save(userWithNewValues);

        return userWithNewValues;
    }

    @ResponseBody
    @RequestMapping(value = RouteConfig.USER_API_LIST_PEOPLE_URL, method = RequestMethod.POST,
            produces = "application/json")
    public User saveUser(@RequestBody User user) throws Exception {
        userManager.save(user);

        return user;
    }

    @ResponseBody
    @RequestMapping(value = RouteConfig.USER_API_SINGLE_PERSON_URL, method = RequestMethod.DELETE,
            produces = "application/json")
    public User deleteUser(@PathVariable Long id) throws Exception {
        userManager.delete(id);

        // todo to trigger success() function of backbone upon deletion i needed to return something..
        return new User();
    }

}
