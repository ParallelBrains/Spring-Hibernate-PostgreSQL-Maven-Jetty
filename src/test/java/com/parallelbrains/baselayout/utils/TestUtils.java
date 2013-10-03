package com.parallelbrains.baselayout.utils;

import com.parallelbrains.baselayout.model.Person;
import com.parallelbrains.baselayout.model.User;

public class TestUtils {

    public static Person getAPersonObject(String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        return person;
    }

    public static User getAUserObject(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }

}
