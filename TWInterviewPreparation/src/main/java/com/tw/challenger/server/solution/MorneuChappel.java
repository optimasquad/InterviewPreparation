/**
 * 
 */
package com.tw.challenger.server.solution;

/**
 * @author JATIN MAHAJAN
 *
 */
public class MorneuChappel {

	// Structure to store the coordinates of a point.
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	};

	// Function to find the minimum number of points
	static int findmin(Point p[], int n) {
		int a = 0, b = 0, c = 0, d = 0;
		for (int i = 0; i < n; i++) {
			// Number of points on the left of Y-axis.
			if (p[i].x <= 0)
				a++;

			// Number of points on the right of Y-axis.
			else if (p[i].x >= 0)
				b++;

			// Number of points above X-axis.
			if (p[i].y >= 0)
				c++;

			// Number of points below X-axis.
			else if (p[i].y <= 0)
				d++;
		}
		return Math.min(Math.min(a, b), Math.min(c, d));
	}

	// Driver Code
	public static void main(String[] args) {
		Point p[] = { new Point(1, 3), new Point(2, 5), new Point(3, 6) };
		int n = p.length;
		System.out.println(findmin(p, n));
	}
}
