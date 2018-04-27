package com.example;

import java.util.List;

import com.example.java8streams.Student;

public class Application {

	public static void main(String[] args) {
		List<Student> list = Student.createStudentList();
		Student.printAllStudentsFromCountry(list, "USA");
	}

}
