package com.parallelbrains.baselayout.utils.impl;

import com.parallelbrains.baselayout.model.Person;
import com.parallelbrains.baselayout.repository.PersonDao;
import com.parallelbrains.baselayout.utils.DaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoHelperImpl implements DaoHelper {

    @Autowired
    private PersonDao personDao;

    public Person savePerson(String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName("Andy");
        person.setLastName("Gibson");

        personDao.save(person);

        return person;
    }

}
