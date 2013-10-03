package com.parallelbrains.baselayout.utils;

import com.parallelbrains.baselayout.model.Person;

public class TestUtils {

    public static Person getAPersonObject(String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        return person;
    }

}
