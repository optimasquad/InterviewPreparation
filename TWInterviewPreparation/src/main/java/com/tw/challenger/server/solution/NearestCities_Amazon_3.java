package com.tw.challenger.server.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NearestCities_Amazon_3 {
	public static class City {
		private String label;
		private int x;
		private int y;

		public City(String label, int x, int y) {
			this.label = label;
			this.y = y;
			this.x = x;
		}

		public double distance(int x, int y) {
			return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
		}
	}

	public static class Node {
		Node l, r;
		int val;
		List<City> cities = new LinkedList<City>();

		public Node(int v) {
			val = v;
		}
	}

	public static class Tree {
		Node root = null;

		public void insert(int n, City c) {
			if (root == null) {
				root = new Node(n);
				root.cities.add(c);
			} else {
				insertHelper(root, n, c);
			}
		}

		private void insertHelper(Node node, int n, City c) {
			if (n == node.val) {
				node.cities.add(c);
			} else if (n < node.val) {
				if (node.l == null) {
					node.l = new Node(n);
					node.l.cities.add(c);
				} else
					insertHelper(node.l, n, c);
			} else {
				if (node.r == null) {
					node.r = new Node(n);
					node.r.cities.add(c);
				} else
					insertHelper(node.r, n, c);
			}
		}

		public List<City> nearest(int n) {
			Node prev = root, curr = root;
			while (curr != null && curr.val != n) {
				prev = curr;
				if (n < curr.val) {
					curr = curr.l;
				} else {
					curr = curr.r;
				}
			}

			return (curr == null) ? prev.cities : curr.cities;
		}
	}

	private static final City DENVER = new City("Denver", 0, 0);
	private static final City SEATTLE = new City("Seattle", -4, 5);
	private static final City PORTLAND = new City("Portland", -2, 4);
	private static final City SANFRANCISCO = new City("San Francisco", -3, -2);
	private static final City LOSANGELES = new City("Los Angeles", -5, -3);
	private static final City CHICAGO = new City("Chicago", 2, 3);
	private static final City ATLANTA = new City("Atlanta", 3, 0);
	private static final City MIAMI = new City("Miami", 4, -5);
	private static List<City> cities = Arrays.asList(DENVER, SEATTLE, PORTLAND, SANFRANCISCO, LOSANGELES, CHICAGO,
			ATLANTA, MIAMI);

	// Trees balanced by insertion order, not self-balancing
	private static Tree xt = new Tree();
	static {
		xt.insert(DENVER.x, DENVER);
		xt.insert(SEATTLE.x, SEATTLE);
		xt.insert(LOSANGELES.x, LOSANGELES);
		xt.insert(SANFRANCISCO.x, SANFRANCISCO);
		xt.insert(PORTLAND.x, PORTLAND);
		xt.insert(ATLANTA.x, ATLANTA);
		xt.insert(CHICAGO.x, CHICAGO);
		xt.insert(MIAMI.x, MIAMI);
	}
	private static Tree yt = new Tree();
	static {
		yt.insert(DENVER.y, DENVER);
		yt.insert(ATLANTA.y, ATLANTA);
		yt.insert(PORTLAND.y, PORTLAND);
		yt.insert(CHICAGO.y, CHICAGO);
		yt.insert(SEATTLE.y, SEATTLE);
		yt.insert(LOSANGELES.y, LOSANGELES);
		yt.insert(SANFRANCISCO.y, SANFRANCISCO);
		yt.insert(MIAMI.y, MIAMI);
	}

	public static void main(String[] args) {
		search(0, 0);
		search(0, 1);
		search(0, 2);
		search(2, 2);
		search(4, 4);
		search(0, -1);
		search(0, -2);
		search(-2, 2);
		search(4, -4);
	}

	private static void search(int x, int y) {
		System.out.println("Searching for city nearest (" + x + ", " + y + ")");
		linearSearch(x, y);
		binarySearch(x, y);
	}

	private static void linearSearch(int x, int y) {
		double min = Double.MAX_VALUE;
		City nearest = null;
		for (City c : cities) {
			double dist = c.distance(x, y);
			if (dist < min) {
				nearest = c;
				min = dist;
			}
		}
		System.out.println("Linear search determined that " + nearest.label + " is closest with " + cities.size()
				+ " calculations.");
	}

	private static void binarySearch(int x, int y) {
		List<City> candidates = new LinkedList<City>();
		candidates.addAll(xt.nearest(x));
		candidates.addAll(yt.nearest(y));
		double min = Double.MAX_VALUE;
		City nearest = null;
		for (City c : candidates) {
			double dist = c.distance(x, y);
			if (dist < min) {
				nearest = c;
				min = dist;
			}
		}
		System.out.println("Binary search determined that " + nearest.label + " is closest with " + candidates.size()
				+ " calculations.");
	}
}