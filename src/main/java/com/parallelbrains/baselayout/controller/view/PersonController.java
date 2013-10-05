package com.parallelbrains.baselayout.controller.view;

import com.parallelbrains.baselayout.config.RouteConfig;
import com.parallelbrains.baselayout.model.Person;
import com.parallelbrains.baselayout.service.PersonManager;
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
@RequestMapping(RouteConfig.PERSON_BASE_MAPPING)
public class PersonController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonManager personManager;

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = RouteConfig.PERSON_EDIT, method = RequestMethod.GET)
    public ModelAndView editPerson(@RequestParam(value = "id", required = false) Long id) {
        LOGGER.debug("Received request to edit person id : " + id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(RouteConfig.PERSON_EDIT_VIEW);

        Person person = personManager.get(id);

        modelAndView.addObject("person", person == null ? new Person() : person);

        return modelAndView;
    }

    @RequestMapping(value = RouteConfig.PERSON_EDIT, method = RequestMethod.POST)
    public String savePerson(@ModelAttribute Person person) {
        LOGGER.debug("Received postback on person " + person);

        personManager.save(person);

        return redirectTo(RouteConfig.PERSON_LIST);

    }

    @RequestMapping(value = RouteConfig.PERSON_LIST, method = RequestMethod.GET)
    public ModelAndView listPeople() {
        LOGGER.debug("Received request to list persons");

        ModelAndView modelAndView = new ModelAndView();

        List<Person> people = personManager.getAll();

        LOGGER.debug("Person Listing count = " + people.size());

        modelAndView.addObject("people", people);
        modelAndView.setViewName(RouteConfig.PERSON_LIST_VIEW);

        org.springframework.security.core.userdetails.User loggedInUser = userManager.getLoggedInUser();

        if (loggedInUser != null) {
            modelAndView.addObject("loggedInUserName", userManager.getLoggedInUser().getUsername());
        }

        userManager.getLoggedInUser();

        return modelAndView;
    }

    @RequestMapping(value = RouteConfig.PERSON_DELETE, method = RequestMethod.DELETE)
    public String deletePerson(@ModelAttribute Person person) {
        LOGGER.debug("Deleting person " + person);

        personManager.delete(person.getId());

        return redirectTo(RouteConfig.PERSON_LIST);
    }

}
