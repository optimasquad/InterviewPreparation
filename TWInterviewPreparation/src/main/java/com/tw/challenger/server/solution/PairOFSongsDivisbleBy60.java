/**
 * 
 */
package com.tw.challenger.server.solution;

/**
 * @author JATIN MAHAJAN
 *
 */
public class PairOFSongsDivisbleBy60 {

	public static void main(String args[]) {

		int time[] = { 30, 20, 150, 100, 40 };

		int result = numPairsDivisibleBy60(time);

		System.out.println("The result is " + result);

	}

	private static int numPairsDivisibleBy60(int[] time) {
		int count = 0, n = time.length;
		for (int i = 0; i < n; i++) {
			// j starts with i+1 so that i is always to the left of j
			// to avoid repetitive counting
			for (int j = i + 1; j < n; j++) {
				if ((time[i] + time[j]) % 60 == 0) {
					count++;
				}
			}
		}
		return count;
	}

}
