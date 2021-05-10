package com.tw.challenger.server.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortHashMapByKeyOrValue {

	public static void main(String args[]) {

		Map<String, Integer> unsortMap = new HashMap<>();
		unsortMap.put("z", 10);
		unsortMap.put("b", 5);
		unsortMap.put("a", 6);
		unsortMap.put("c", 20);
		unsortMap.put("d", 1);
		unsortMap.put("e", 7);
		unsortMap.put("y", 8);
		unsortMap.put("n", 99);
		unsortMap.put("g", 50);
		unsortMap.put("m", 2);
		unsortMap.put("f", 9);

		System.out.println("Sort on basis of the Key");

		Map<String, Integer> sortedMapByKey = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));

		sortedMapByKey.forEach((K, V) -> System.out.println(K + " " + V));
		System.out.println("========================================");

		Map<String, Integer> sortedMapByValue = unsortMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		sortedMapByValue.forEach((K, V) -> System.out.println(K + " " + V));
		
		System.out.println("====================================================");

		List<String> wordsList = Arrays.asList("hello", "bye", "ciao", "bye", "ciao");

		Map<String, Long> frequencyDetails = wordsList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		frequencyDetails.forEach((k, v) -> System.out.println("Key " + k + " and value " + v));

	}

}
