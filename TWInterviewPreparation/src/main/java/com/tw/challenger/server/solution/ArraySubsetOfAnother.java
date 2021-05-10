package com.tw.challenger.server.solution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySubsetOfAnother {

	public static void main(String args[]) {

		int arr1[] = { 1, 9, 5 };
		int arr2[] = { 1, 4, 7, 3, 5, 6 };

		List<Integer> list = Arrays.stream(arr1).boxed().collect(Collectors.toList());

		boolean result = isSubset(arr1, arr2);
		System.out.println(result);

	}

	private static boolean isSubset(int arr1[], int arr2[]) {

		Arrays.sort(arr1);

		Arrays.sort(arr2);

		int size = 0;

		for (int i = 0; i < arr1.length; i++) {

			for (int j = 0; j < arr2.length; j++) {

				if (arr1[i] == arr2[j]) {
					size++;
				}
			}

		}

		if (size == arr1.length)
			return true;

		return false;

	}

}
