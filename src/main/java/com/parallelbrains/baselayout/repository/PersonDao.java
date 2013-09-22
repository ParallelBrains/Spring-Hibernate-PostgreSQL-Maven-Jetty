package com.parallelbrains.baselayout.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.parallelbrains.baselayout.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface PersonDao {
	
	Person get(Long id) ;
	
	List<Person> getAll();
	
    Person save(Person person);

}
