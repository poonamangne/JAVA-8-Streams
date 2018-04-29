package com.example.java8streams.ListServices;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

public class ListOperations {

	public static int[] createNumberArray() {
		int[] numbers = { 1, 2, 3, 4 };
		return numbers;
	}

	public static List<String> createStringList() {
		List<String> stringList = Arrays.asList("sample1", "sample2", "sample3", "sample4");
		return stringList;
	}

	public static void convertsubStringToParseIntAppendString(List<String> list) {
		System.out.println("\n/*** Convert list substring to Integer and Append to Another String ***/");
		list.stream().map(s -> s.substring(6)).mapToInt(Integer::parseInt) // OR .mapToInt(s -> Integer.parseInt(s))
				.mapToObj(i -> "example" + i).forEach(System.out::println);
	}

	public static void convertStringListToUpperCase(List<String> list) {
		System.out.println("\n/*** Converting Strings to UpperCase ***/");
		list.replaceAll(s -> s.toUpperCase());
		list.forEach(System.out::println);
	}

	public static void reverseStringList(List<String> list) {
		System.out.println("\n/***Reversing List***/");
		Collections.reverse(list);
		list.forEach(System.out::println);
	}

	public static void execute(int a, int b, BiConsumer<Integer, Integer> consumer) {
		consumer.accept(a, b);
	}

	public static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int value : numbers) {
			consumer.accept(value, key);
		}
	}

	public static void addArrayElementsToKey(int[] numbers, int key) {
		System.out.println("\n/***Printing All Elements added to key***/");
		process(numbers, key, (v, k) -> System.out.println(v + k));
	}
	
	public static void multiplyArrayElementsToKey(int[] numbers, int key) {
		System.out.println("\n/***Printing All Elements multiplied***/");
		process(numbers, key, (a, b) -> System.out.println(a * b));
	}
	
	public static void createThread() {
		System.out.println("\n/***Thread Implementation***/");
		Thread t1 = new Thread(() -> System.out.println("Thread is running"));
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
