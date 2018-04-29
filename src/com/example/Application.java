package com.example;

import java.util.List;

import com.example.java8streams.Student;
import com.example.java8streams.ListServices.ListOperations;
import com.example.java8streams.StudentServices.StudentOperations;

public class Application {

	public static void main(String[] args) {
		List<Student> list = StudentOperations.createStudentList();
		StudentOperations.createStudentPhraseStream(list, 18, "USA");
		
		/*int[] numbers = ListOperations.createNumberArray();
		ListOperations.multiplyArrayElementsToKey(numbers, 10);*/
	}

}
