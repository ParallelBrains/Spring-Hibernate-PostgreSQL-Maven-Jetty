package com.parallelbrains.baselayout.repository.impl;

import com.parallelbrains.baselayout.model.Person;
import com.parallelbrains.baselayout.repository.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "personDao")
@Transactional(propagation = Propagation.MANDATORY)
public class PersonDaoImpl extends BaseDao<Person> implements PersonDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDaoImpl.class);

}
