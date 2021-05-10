
package com.tw.challenger.server.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author JATIN MAHAJAN
 *
 */
public class KeysAndRooms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Integer> roomDetails1 = new ArrayList<Integer>();
		ArrayList<Integer> roomDetails2 = new ArrayList<Integer>();
		ArrayList<Integer> roomDetails3 = new ArrayList<Integer>();
		ArrayList<Integer> roomDetails4 = new ArrayList<Integer>();
		roomDetails1.add(1);
		roomDetails2.add(2);
		roomDetails3.add(3);

		List<List<Integer>> rooms1 = new ArrayList<List<Integer>>();
		rooms1.add(roomDetails1);

		List<List<Integer>> rooms2 = new ArrayList<List<Integer>>();
		rooms2.add(roomDetails2);

		List<List<Integer>> rooms3 = new ArrayList<List<Integer>>();
		rooms3.add(roomDetails3);
		
		List<List<Integer>> rooms4 = new ArrayList<List<Integer>>();
		rooms4.add(roomDetails4);

		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		rooms.addAll(rooms1);
		rooms.addAll(rooms2);
		rooms.addAll(rooms3);
		rooms.addAll(rooms4);

		boolean result = canVisitAllRooms(rooms);
		System.out.println(result);

	}

	private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] seen = new boolean[rooms.size()];
		seen[0] = true;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);

		// At the beginning, we have a todo list "stack" of keys to use.
		// 'seen' represents at some point we have entered this room.
		while (!stack.isEmpty()) { // While we have keys...
			int node = stack.pop(); // Get the next key 'node'
			for (int nei : rooms.get(node)) // For every key in room # 'node'...
				if (!seen[nei]) { // ...that hasn't been used yet
					seen[nei] = true; // mark that we've entered the room
					stack.push(nei); // add the key to the todo list
				}
		}

		for (boolean v : seen) // if any room hasn't been visited, return false
			if (!v)
				return false;
		return true;
	}

}
