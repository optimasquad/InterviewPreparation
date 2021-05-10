package com.tw.challenger.server.solution;

public class Nagarro {

	public static void main(String args[]) {

		String input = "this_is_a_variable";
		System.out.println(camelcasify(input));
		String inverse="thisIsAVariable";
		System.out.println(camelcasify(inverse));

	}

	public static String camelcasify(String in) {
		if (in.contains("_")) {
			StringBuilder sb = new StringBuilder();
			boolean capitalizeNext = false;
			for (char c : in.toCharArray()) {
				if (c == '_') {
					capitalizeNext = true;
				} else {
					if (capitalizeNext) {
						sb.append(Character.toUpperCase(c));
						capitalizeNext = false;
					} else {
						sb.append(c);
					}
				}
			}
			return sb.toString();
		} else {

			String response = in.replaceAll("([A-Z])", "_$1").toLowerCase();
			return response;
		}
	}
}
