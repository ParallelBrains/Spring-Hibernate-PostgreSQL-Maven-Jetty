package com.parallelbrains.baselayout.service;

import com.parallelbrains.baselayout.model.Person;
import com.parallelbrains.baselayout.utils.TestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class PersonManagerTest extends BaseManagerTest {

    @Autowired
    private PersonManager personManager;

    @Test
    public void saveAPerson() {
        Person person = TestUtils.getAPersonObject();

        personManager.save(person);

        assertNotNull(person.getId());
    }

    @Test
    public void getAPerson() {
        Person person = TestUtils.getAPersonObject();

        personManager.save(person);

        Person savedPerson = personManager.get(person.getId());

        assertNotNull(savedPerson);
    }

    @Test
    public void listPeople() {
        Person person = TestUtils.getAPersonObject();

        personManager.save(person);

        List<Person> people = personManager.getAll();

        assertEquals(1, people.size());
    }

    @Test
    public void deleteAPerson() {
        Person person = TestUtils.getAPersonObject();

        personManager.save(person);

        Long personId = person.getId();

        assertNotNull(personId);

        personManager.delete(personId);

        Person deletedPerson = personManager.get(personId);

        assertNull(deletedPerson);
    }

}
