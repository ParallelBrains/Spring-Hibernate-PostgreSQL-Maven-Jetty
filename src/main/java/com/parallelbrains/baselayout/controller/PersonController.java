package com.parallelbrains.baselayout.controller;

import com.parallelbrains.baselayout.config.RouteConfig;
import com.parallelbrains.baselayout.model.Person;
import com.parallelbrains.baselayout.service.PersonManager;
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
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonManager personManager;

    @RequestMapping(value = RouteConfig.PERSON_EDIT, method = RequestMethod.GET)
    public ModelAndView editPerson(@RequestParam(value = "id", required = false) Long id) {
        LOGGER.debug("Received request to edit person id : " + id);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("edit");

        Person person = null;
        if (id == null) {
            person = new Person();
        } else {
            person = personManager.get(id);
        }

        mav.addObject("person", person);

        return mav;
    }

    @RequestMapping(value = RouteConfig.PERSON_EDIT, method = RequestMethod.POST)
    public String savePerson(@ModelAttribute Person person) {
        LOGGER.debug("Received postback on person " + person);

        personManager.save(person);

        return "redirect:list";

    }

    @RequestMapping(value = RouteConfig.PERSON_LIST, method = RequestMethod.GET)
    public ModelAndView listPeople() {
        LOGGER.debug("Received request to list persons");

        ModelAndView mav = new ModelAndView();
        List<Person> people = personManager.getAll();

        LOGGER.debug("Person Listing count = " + people.size());

        mav.addObject("people", people);
        mav.setViewName("list");

        return mav;
    }

}
