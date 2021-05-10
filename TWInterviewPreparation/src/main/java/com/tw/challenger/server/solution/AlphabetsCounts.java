package com.tw.challenger.server.solution;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AlphabetsCounts {

	public static void main(String[] args) {

		String str = "aasjjikkk";

		Map<Character, Long> frequency = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		// sort on basis of value
		Map<Character, Long> sortedMapByValue = frequency.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry<Character, Long>::getKey, Map.Entry<Character, Long>::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		sortedMapByValue.forEach((K, V) -> System.out.println(K + " " + V));

		System.out.println("====================================================");

	}

}
