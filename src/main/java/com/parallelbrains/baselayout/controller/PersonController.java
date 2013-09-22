package com.parallelbrains.baselayout.controller;

import java.util.List;

import com.parallelbrains.baselayout.dao.PersonDao;
import com.parallelbrains.baselayout.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/person/")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonDao personDao;

    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public ModelAndView editPerson(@RequestParam(value = "id", required = false) Long id) {
        LOGGER.debug("Received request to edit person id : " + id);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("edit");

        Person person = null;
        if (id == null) {
            person = new Person();
        } else {
            person = personDao.find(id);
        }

        mav.addObject("person", person);

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "edit")
    public String savePerson(@ModelAttribute Person person) {
        LOGGER.debug("Received postback on person " + person);

        personDao.save(person);

        return "redirect:list";

    }

    @RequestMapping(method = RequestMethod.GET, value = "list")
    public ModelAndView listPeople() {
        LOGGER.debug("Received request to list persons");

        ModelAndView mav = new ModelAndView();
        List<Person> people = personDao.getPeople();

        LOGGER.debug("Person Listing count = " + people.size());

        mav.addObject("people", people);
        mav.setViewName("list");

        return mav;
    }

}
