package com.parallelbrains.baselayout.service;

import com.parallelbrains.baselayout.model.Person;

import java.util.List;

public interface PersonManager {

    Person get(Long id) ;

    List<Person> getAll();

    void save(Person person);

}
