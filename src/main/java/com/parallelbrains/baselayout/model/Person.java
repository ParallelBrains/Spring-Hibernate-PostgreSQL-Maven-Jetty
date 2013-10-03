package com.parallelbrains.baselayout.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Person extends BaseModel {

	@Column
	private String firstName;

	@Column
	private String lastName;

	public Person() {
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return super.toString() + " name = " + firstName + " " + lastName
				+ " id = " + getId();
	}
}
