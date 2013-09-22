package com.parallelbrains.baselayout.repository.impl;

import com.parallelbrains.baselayout.model.Person;
import com.parallelbrains.baselayout.repository.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository(value = "personDao")
@Transactional(propagation = Propagation.MANDATORY)
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDaoImpl.class);

    public Person get(Long id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> getAll() {
        return entityManager.createQuery("select p from Person p").getResultList();
    }

    public Person save(Person person) {
        if (person.getId() == null) {
            entityManager.persist(person);
            return person;
        } else {
            return entityManager.merge(person);
        }
    }

}
