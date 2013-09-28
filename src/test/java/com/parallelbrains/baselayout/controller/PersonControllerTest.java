package com.parallelbrains.baselayout.controller;

import com.parallelbrains.baselayout.controller.view.PersonController;
import com.parallelbrains.baselayout.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonControllerTest {
	
	@Autowired
	private DataInitializer dataInitializer;
	
	@Autowired
	private PersonController personController;
		
	@Before
	public void before() {
		dataInitializer.initData();
	}
	
	@Test
	public void shouldReturnPersonListView() {
		ModelAndView mav = personController.listPeople();
		assertEquals("list",mav.getViewName());
		
		List<Person> people = (List<Person>) mav.getModelMap().get("people");
		assertNotNull(people);		
		assertEquals(DataInitializer.PERSON_COUNT,people.size());		
	}
	
	

	public void shouldReturnNewPersonWithEditMav() {
		ModelAndView mav = personController.editPerson(null);
		assertNotNull(mav);
		assertEquals("edit", mav.getViewName());
		Object object = mav.getModel().get("person");
		assertTrue(Person.class.isAssignableFrom(object.getClass()));
		Person person = (Person) object;
		assertNull(person.getId());
		assertNull(person.getFirstName());
		assertNull(person.getLastName());		
	}
	
	@Test
	public void shouldReturnSecondPersonWithEditMav() {
		Long template = dataInitializer.people.get(1);
		ModelAndView mav = personController.editPerson(template);
		assertNotNull(mav);
		assertEquals("edit", mav.getViewName());
		Object object = mav.getModel().get("person");
		assertTrue(Person.class.isAssignableFrom(object.getClass()));
		Person person = (Person) object;
		assertEquals(template,person.getId());
	}
	
}
