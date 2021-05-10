package com.tw.challenger.server.solution;

import java.util.Stack;

//This is called as level order transversal
public class ZigZagTransverseTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.rootNode = new Node(1);
		tree.rootNode.left = new Node(2);
		tree.rootNode.right = new Node(3);
		tree.rootNode.left.left = new Node(7);
		tree.rootNode.left.right = new Node(6);
		tree.rootNode.right.left = new Node(5);
		tree.rootNode.right.right = new Node(4);

		System.out.println("ZigZag Order traversal of binary tree is");
		tree.printZigZagTransversal();
	}
}

class Node {

	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
	}
}

class BinaryTree {

	Node rootNode;

	void printZigZagTransversal() {

		if (rootNode == null)
			return;

		Stack<Node> currentLevel = new Stack<Node>();

		Stack<Node> nextLevel = new Stack<Node>();

		currentLevel.push(rootNode);

		boolean leftToRight = true;

		while (!currentLevel.isEmpty()) {

			// pop out of stack
			Node node = currentLevel.pop();

			// print the data in it
			System.out.print(node.data + " ");

			if (leftToRight) {
				if (null != node.left) {
					nextLevel.push(node.left);
				}

				if (null != node.right) {
					nextLevel.push(node.right);
				}
			} else {

				if (null != node.left) {
					nextLevel.push(node.left);
				}

				if (null != node.right) {
					nextLevel.push(node.right);
				}
			}

			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<Node> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}

		}

	}

}
