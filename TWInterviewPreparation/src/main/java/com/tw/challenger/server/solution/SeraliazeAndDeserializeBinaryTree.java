package com.tw.challenger.server.solution;

import java.util.Deque;
import java.util.LinkedList;

public class SeraliazeAndDeserializeBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		// BFS solution
		// System.out.println(root.val);
		if (root == null)
			return "[]";
		Deque<TreeNode> queue = new LinkedList();
		String answer = "[";
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (node == null) {
				answer += "null,";
			} else {
				answer += node.val + ",";
				queue.add(node.left);
				queue.add(node.right);
			}
		}

		return answer.substring(0, answer.length() - 1) + "]";
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		if (data.equals("[]"))
			return null;
		String[] answer = data.substring(1, data.length() - 1).split(",");
		Deque<TreeNode> queue = new LinkedList();
		TreeNode root = new TreeNode(Integer.parseInt(answer[0]));
		queue.add(root);
		for (int i = 1; i < answer.length; i++) {
			TreeNode node = queue.remove();
			if (!answer[i].equals("null")) {
				TreeNode left = new TreeNode(Integer.parseInt(answer[i]));
				node.left = left;
				queue.add(left);
			}
			// we can do ++i because the data we have will always be of even length
			if (!answer[++i].equals("null")) {
				TreeNode right = new TreeNode(Integer.parseInt(answer[i]));
				node.right = right;
				queue.add(right);
			}
		}

		return root;
	}

}
