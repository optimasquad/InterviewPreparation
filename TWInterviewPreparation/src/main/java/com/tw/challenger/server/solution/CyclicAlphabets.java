package com.tw.challenger.server.solution;

import java.util.Dictionary;
import java.util.Hashtable;

public class CyclicAlphabets {

	public static void main(String[] args) {

		Dictionary geek = new Hashtable();
		geek.put("A", 1);
		geek.put("B", 2);
		geek.put("C", 3);
		geek.put("D", 4);
		geek.put("E", 5);
		geek.put("F", 6);
		geek.put("G", 7);
		geek.put("H", 8);
		geek.put("I", 9);
		geek.put("J", 10);
		geek.put("K", 11);
		geek.put("L", 12);
		geek.put("M", 13);
		geek.put("N", 14);
		geek.put("O", 15);
		geek.put("P", 16);
		geek.put("Q", 17);
		geek.put("R", 18);
		geek.put("S", 19);
		geek.put("T", 20);
		geek.put("U", 21);
		geek.put("V", 22);
		geek.put("W", 23);
		geek.put("X", 24);
		geek.put("Y", 25);
		geek.put("Z", 26);

		char first = 'a';
		char last = 'z';
		int diff = first - last; // negative 25
		if (diff < 0) {
			diff += 26;
		}
		System.out.println(diff);

		char array[] = new char[26];
		int j = 0;
		for (char i = 'A'; i <= 'Z'; i++) {
			array[j] = i;
			j++;
			System.out.println("Char" + i);
		}

		// find distance between numbers
		String s = "BZA";
		int minus = 0;
		int total = 0;
		for (int i = 0; i < s.length() - 1; i++) {

			int dictval = (int) geek.get(i);
			System.out.println("dictionaryvalue" + dictval);

			if (dictval > 13) {
				if (i == 0) {
					minus = dictval - 1;
				} else {
					minus = 26 - (int) geek.get(i);
				}
			}

			total += minus;

			// int difference = s.charAt(i) - s.charAt(i+1);
			// if(difference == 0)
			// difference = 1;
			// System.out.println("Second Loop" + difference);
			// if (difference < 0) {
			// difference += 26;
			// }
			System.out.println("minus" + minus);
			System.out.println("total" + total);
		}

	}
}
