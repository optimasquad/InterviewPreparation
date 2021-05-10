
package com.tw.challenger.server.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JATIN MAHAJAN
 *
 */
public class LevelOrderTransversal {

	Node root;

	void printLevelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {

			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			/* Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/* Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	public static void main(String args[]) {
		LevelOrderTransversal tree_level = new LevelOrderTransversal();
		tree_level.root = new Node(1);
		tree_level.root.left = new Node(2);
		tree_level.root.right = new Node(3);
		tree_level.root.left.left = new Node(4);
		tree_level.root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is - ");
		tree_level.printLevelOrder();
	}

}

class Node {

	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
