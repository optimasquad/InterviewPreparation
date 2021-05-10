
package com.tw.challenger.server.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author JATIN MAHAJAN
 *
 */
public class CheckPrimeNumber {

	public static void main(String args[]) {

		List<Integer> primes = new ArrayList<>();
		IntStream.range(2, 100000).filter(n -> primes.parallelStream().noneMatch(p -> n % p == 0)).forEach(primes::add);
		System.out.println(primes.size());
		primes.stream().forEach(System.out::println);
	}

}