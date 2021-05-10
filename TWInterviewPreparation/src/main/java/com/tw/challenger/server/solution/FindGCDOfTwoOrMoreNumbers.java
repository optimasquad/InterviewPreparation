/**
 * 
 */
package com.tw.challenger.server.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JATIN MAHAJAN
 *
 */
public class FindGCDOfTwoOrMoreNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// There are list of numbers
		List<Integer> list = new ArrayList<>();
		list.add(54);
		list.add(24);

		List<Integer> response = list.stream().map(i -> findGCD(i, i + 1)).collect(Collectors.toList());

		for (int i = 0; i < list.size(); i++) {

			int result = findGCD(list.get(i), list.get(i + 1));
			response.add(result);
		}

		System.out.println(response);
	}

	private static int findGCD(Integer number1, Integer number2) {
		if (number2 == 0) {
			return number1;
		}
		return findGCD(number2, number1 % number2);
	}

}
