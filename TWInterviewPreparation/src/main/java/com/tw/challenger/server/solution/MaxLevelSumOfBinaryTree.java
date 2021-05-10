package com.tw.challenger.server.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JATIN MAHAJAN
 *
 */
public class MaxLevelSumOfBinaryTree {

	public static void main(String args[]) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(8);
		root.right.right.left = new Node(6);
		root.right.right.right = new Node(7);

		System.out.println("Maximum level sum is " + maxLevelSum(root));
	}

	private static int maxLevelSum(Node root) {

		if (root == null)
			return 0;

		int result = root.data;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {

			int count = queue.size();

			int sum = 0;
			while (count > 0) {

				Node temp = queue.poll();

				sum = sum + temp.data;

				if (temp.left != null)
					queue.add(temp.left);

				if (temp.right != null)
					queue.add(temp.right);

				count--;
			}

			result = Math.max(sum, result);

		}

		return result;
	}

	static class Node {

		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}

	};

}
