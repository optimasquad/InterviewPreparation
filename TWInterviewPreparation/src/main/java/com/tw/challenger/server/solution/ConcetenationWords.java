package com.tw.challenger.server.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcetenationWords {

	private static Set<String> set;

	public static void main(String args[]) {
		set = new HashSet<>();
		String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
		List<String> result = findAllConcatenatedWordsInADict(words);
		result.stream().forEach(s -> System.out.println(s));
	}

	private static List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> result = new ArrayList<String>();
		if (words.length <= 2)
			return result;

		Arrays.sort(words, (a, b) -> a.length() - b.length());

		for (String s : words) {
			if (s.isEmpty()) {
				continue;
			}
			if (isPossible(s)) {
				result.add(s);
			} else {
				set.add(s);
			}
		}

		return result;
	}

	private static boolean isPossible(String s) {
		if (s.isEmpty())
			return true;
		for (int i = 1; i <= s.length(); i++)
			if (set.contains(s.substring(0, i)) && isPossible(s.substring(i)))
				return true;
		return false;
	}
}
