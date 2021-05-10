package com.tw.challenger.server.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NearByRestaurants_Amazon_2 {

	public static void main(String[] args) {
		List<List<Integer>> results = getNearby(
				Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(-1, 1)), 2);
		results.stream().forEach(System.out::println);
	}

	private static List<List<Integer>> getNearby(List<List<Integer>> coordinates, int numofRestaurants) {

		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Map<List<Integer>, Double> resultMap = new HashMap<>();
		for (List<Integer> coordinate : coordinates) {
			int totalSquare = (coordinate.get(0) * coordinate.get(0)) + (coordinate.get(1) * coordinate.get(1));
			double squareRoot = Math.sqrt(totalSquare);
			resultMap.put(coordinate, squareRoot);
		}
		// Sort the map on basis of the value
		Map<List<Integer>, Double> sortedResults = resultMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		int count = 0;
		for (Map.Entry<List<Integer>, Double> output : sortedResults.entrySet()) {

			if (numofRestaurants > count) {
				result.add(output.getKey());
			}

			count++;
		}

		return result;

	}

}
