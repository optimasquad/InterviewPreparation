/**
 * 
 */
package com.tw.challenger.server.solution;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author JATIN MAHAJAN
 *
 */
public class MostCommonWordInParagrpah {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit" };

		String result = mostCommonWord(paragraph, banned);
		System.out.println(result);

	}

	private static String mostCommonWord(String paragraph, String[] banned) {

		// 1). replace the punctuations with spaces,
		// and put all letters in lower case
		String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

		// 2). split the string into words
		String[] words = normalizedStr.split("\\s+");

		Set<String> bannedWords = new HashSet();
		for (String word : banned)
			bannedWords.add(word);

		Map<String, Integer> wordCount = new HashMap();
		// 3). count the appearance of each word, excluding the banned words
		for (String word : words) {
			if (!bannedWords.contains(word))
				wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}

		// 4). return the word with the highest frequency
		return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
	}

}
