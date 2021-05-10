/**
 * 
 */
package com.tw.challenger.server.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author JATIN MAHAJAN
 *
 */
public class Shortesttransformationsequences {

	/**
	 * @param args
	 */
	HashMap<String, List<String>> graph;
	HashMap<String, Integer> levelTracker;
	Set<String> wordDict;
	List<List<String>> res = new ArrayList<>();
	HashMap<String, Boolean> dpDfs;

	public static void main(String[] args) {

		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		List<List<String>> sequences = new Shortesttransformationsequences().findLadders(beginWord, endWord, wordList);
		System.out.println(sequences);
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		graph = new HashMap<>();
		levelTracker = new HashMap<>();
		wordDict = new HashSet<>(wordList);
		if (!wordDict.contains(endWord))
			return new ArrayList<>();

		constructGraph(beginWord, endWord);
		if (!levelTracker.containsKey(endWord))
			return new ArrayList<>();

		int totalLevel = levelTracker.get(endWord);
		dpDfs = new HashMap<>();
		getPath(new ArrayList<>(), beginWord, endWord, totalLevel);
		return res;
	}

	private void constructGraph(String beginWord, String endWord) {
		Deque<String> queue = new ArrayDeque<>();
		queue.add(beginWord);
		levelTracker.put(beginWord, 1);
		while (!queue.isEmpty()) {
			String s = queue.poll();
			if (s.equals(endWord))
				break;

			graph.put(s, new ArrayList<>());
			int level = levelTracker.get(s);
			List<String> list = graph.get(s);

			char[] arr = s.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char oldc = arr[i];
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == oldc)
						continue;
					arr[i] = c;
					String t = String.valueOf(arr);

					if (wordDict.contains(t)) {
						if (!levelTracker.containsKey(t)) {
							levelTracker.put(t, level + 1);
							queue.add(t);
							list.add(t);
						} else if (levelTracker.get(t) > level) {
							list.add(t);
						}
					}
				}
				arr[i] = oldc;
			}
		}
	}

	private boolean getPath(List<String> path, String currWord, String endWord, int totalLevel) {
		path.add(currWord);

		boolean ans = false;
		if (path.size() == totalLevel) {
			if (currWord.equals(endWord)) {
				res.add(new ArrayList<>(path));
				ans = true;
			}
		} else {
			for (String nextWord : graph.get(currWord)) {
				if (!dpDfs.containsKey(nextWord)) {
					boolean tmp = getPath(path, nextWord, endWord, totalLevel);
					ans = ans || tmp;
				} else if (dpDfs.get(nextWord)) {
					ans = true;
					getPath(path, nextWord, endWord, totalLevel);
				}
			}
		}
		path.remove(path.size() - 1);
		dpDfs.put(currWord, ans);
		return ans;
	}
}