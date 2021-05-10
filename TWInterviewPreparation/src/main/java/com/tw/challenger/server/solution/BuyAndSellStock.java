package com.tw.challenger.server.solution;

public class BuyAndSellStock {

	public static void main(String args[]) {

		int prices[] = { 7, 1, 5, 3, 6, 4 };

		int maxProfit = getMaxProfit(prices);
		System.out.println(maxProfit);

	}

	public static int getMaxProfit(int prices[]) {
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minprice)
				minprice = prices[i];
			else if (prices[i] - minprice > maxprofit)
				maxprofit = prices[i] - minprice;
		}
		return maxprofit;
	}

}
