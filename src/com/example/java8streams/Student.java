package com.example.java8streams;

public class Student {
	private String firstName;
	private String lastName;
	private int age;
	private int id;
	private String country;
	
	public Student(String firstName, String lastName, int id, int age, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.age = age;
		this.country = country;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "(Name:" + firstName + " " + lastName + ", ID:" + id + ", Age:" + age + ", Country:" + country + ")";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
