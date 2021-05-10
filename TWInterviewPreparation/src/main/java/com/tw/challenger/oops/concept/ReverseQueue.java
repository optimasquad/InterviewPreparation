package com.tw.challenger.oops.concept;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

	public static void main(String args[]) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);

		Stack<Integer> reverse = new Stack<Integer>();

		while (!queue.isEmpty()) {
			reverse.push(queue.poll());
		}
		while(!reverse.isEmpty()) {
			
			System.out.println(reverse.pop());
		}
		
		int i='a';
		System.out.println(i);
		
		for(char it='a';it<='z';it++) {
			int result=it;
			System.out.println("Character"+" "+it+" and ASCII value "+result);
		}

	}

}
