package com.example.java8streams.StudentServices;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.java8streams.Student;

public class StudentOperations {

	public static List<Student> createStudentList() {
		List<Student> list = Arrays.asList(
				new Student("Bob", "Gayer", 10, 3, "Usa"),
				new Student("Andy", "Schell", 3, 2, "India"), 
				new Student("Ana", "Gargi", 1, 19, "Usa"),
				new Student("Sam", "Bolter", 15, 20, "Canada"), 
				new Student("Kate", "Winslet", 2, 5, "India"),
				new Student("Ross", "Gayler", 5, 2, "Usa"), 
				new Student("Rachel", "Green", 20, 1, "India"));
		return list;
	}
	
	public static Map<String, Integer> createStudentMap(List<Student> list){
		Map<String, Integer> map = new HashMap<>();
		list.forEach(s -> map.put(s.getFirstName(), s.getId()));
		return map;
	}
	
	public static void printStudentMap(Map<String, Integer> map) {
		map.forEach((k,v) -> System.out.println(k + ":" + v));
	}
	
	public static void printStudentList(List<Student> list, Predicate<Student> predicate, Consumer<Student> consumer) {
		for (Student s : list) {
			if (predicate.test(s)) {
				consumer.accept(s);
			}
		}
	}
	
	public static void printAllStudents(List<Student> list) {
		printStudentList(list, s -> true, s -> System.out.println(s));
		//OR printStudentList(list, s -> true, System.out::println);
		//OR list.forEach(s -> System.out.println(s));
		//OR list.forEach(System.out::println);
	}
	
	public static void printAllStudentsFromCountry(List<Student> list, String country) {
		System.out.println("\n/*** Printing All Students from '" + country + "' ***/");
		printStudentList(list, s -> country.equalsIgnoreCase(s.getCountry()), s -> System.out.println(s));
	}
	
	public static void printAllStudentsFirstNameStartsWithsubString(List<Student> list, String subString) {
		System.out.println("\n/***Printing All Students whose firstName starts with '" + subString + "' ***/");
		printStudentList(list, s -> s.getFirstName().startsWith(subString), s -> System.out.println(s));
	}
	
	public static void printAllStudentsSortedByFirstName(List<Student> list) {
		System.out.println("\n/***Printing All Students sorted by First Name***/");
		Collections.sort(list, (s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()));
		printAllStudents(list);
	}
	
	public static void printAllStudentsGreaterThanAge(List<Student> list, int age) {
		System.out.println("\n/***Printing All Students with age > '" + age + "' ***/");
		printStudentList(list, s -> s.getAge() > age, s -> System.out.println(s));
	}
	
	public static void printAllStudentsSortedByAge(List<Student> list) {
		System.out.println("\n/***Printing All Students sorted by Age***/");
		Collections.sort(list, (s1,s2) -> s1.getAge() - s2.getAge());
		printAllStudents(list);
	}
	
	public static void printAllStudentsSortedById(List<Student> list) {
		System.out.println("\n/***Printing All Students sorted by ID***/");
		Collections.sort(list, (s1,s2) -> s1.getId() - s2.getId());
		printAllStudents(list);
	}
	
	public static void printAllStudentsSortedByLastName(List<Student> list) {
		System.out.println("\n/***Printing All Students sorted by Last Name***/");
		Collections.sort(list, (s1,s2) -> s1.getLastName().compareTo(s2.getLastName()));
		printAllStudents(list);
	}
	
	public static void createStudentMapAndPrint(List<Student> list) {
		Map<String, Integer> map = createStudentMap(list);
		printStudentMap(map);
	}
	
	public static void printAllStudentsFirstNameStartsWithsubStringStream(List<Student> list, String subString) {
		System.out.println("\n/*** Students whose First Name starts with '" + subString + "' ***/");
		list.stream().filter(s -> subString.equalsIgnoreCase(s.getFirstName().substring(0, subString.length())))
				.forEach(s -> System.out.println(s));
	}

	public static void printAllStudentsLastNamesEndsWithsubStringStream(List<Student> list, String subString) {
		System.out.println("\n/*** Students whose Last Name ends with '" + subString + "' ***/");
		list.stream()
				.filter(s -> subString.equalsIgnoreCase(s.getLastName()
						.substring(s.getLastName().length() - subString.length(), s.getLastName().length())))
				.forEach(s -> System.out.println(s));
	}

	public static void printAllStudentsFromCountryStream(List<Student> list, String country) {
		System.out.println("\n/*** Students who are not from '" + country + "' ***/");
		list.stream().filter(s -> country.equalsIgnoreCase(s.getCountry())).forEach(s -> System.out.println(s));
	}

	public static void getAverageAgeByCountryStream(List<Student> list, String country) {
		System.out.println("\n/*** Average age of All Students from '" + country + "' ***/");
		Double averageAge = list.stream().filter(s -> country.equalsIgnoreCase(s.getCountry()))
				.collect(Collectors.averagingInt(s -> s.getAge()));
		System.out.println(averageAge + " years");
	}

	public static void groupStudentsByAgeStream(List<Student> list) {
		System.out.println("\n/*** Grouping All Students by Age ***/");
		Map<Integer, List<Student>> filteredList1 = list.stream().collect(Collectors.groupingBy(s -> s.getAge()));
		filteredList1.forEach((age, p) -> System.out.println("Age: " + age + " " + p));
	}

	public static void createStudentPhraseStream(List<Student> list, int age, String country) {
		String phrase = list.stream().filter(s -> s.getAge() > age).map(s -> s.getFirstName())
				.collect(Collectors.joining(" and ", "In " + country.toUpperCase() + ", ", " are of legal age."));
		System.out.println(phrase);
	}

	public static void getStudentLastNameEndingWithsubStringSortedStream(List<Student> list, String subString) {
		System.out.println("\n/***Students LastName ending in " + subString + " and sorted ***/");
		list.stream().filter(s -> s.getLastName().endsWith(subString)).map(s -> s.getLastName().toUpperCase()).sorted()
				.forEach(System.out::println);
	}
}
