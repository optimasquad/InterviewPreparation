
package com.tw.challenger.server.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author JATIN MAHAJAN
 *
 */
public class Amazon_boxes_fill_truck {

	public static void main(String args[]) {

		int boxes[] = { 1, 2, 3 };
		int unitsPerBox[] = { 3, 2, 1 };
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < unitsPerBox.length; i++) {

			for (int j = 0; j < boxes.length; j++) {

				if (unitsPerBox[i] >= boxes[j]) {
					result.add(boxes[j]);
				}

			}
		}

		// we get the boxes and then sort the list in descending order

		Collections.sort(result, Collections.reverseOrder());
		System.out.println(result);

	}

}
