package org.peggygao.algs.array;

public class MaxProfit {

    public static int maxProfit(int[] prices) {

	if (prices == null || prices.length == 0) {
	    return 0;
	}

	int maxP = 0;

	int[] left = new int[prices.length];

	int min = prices[0];
	for (int i = 0; i < prices.length; i++) {

	    if (min > prices[i]) {
		min = prices[i];
	    }

	    if (i > 0) {
		left[i] = Math.max(left[i - 1], prices[i] - min);
	    }

	}

	int max = prices[prices.length - 1];
	int[] right = new int[prices.length];
	for (int i = prices.length - 1; i >= 0; i--) {
	    if (max < prices[i]) {
		max = prices[i];
	    }

	    if (i < prices.length - 1) {
		right[i] = Math.max(right[i + 1], max - prices[i]);
	    }

	    maxP = Math.max(maxP, right[i] + left[i]);

	}

	return maxP;

    }

    public static void main(String[] args) {

	int[] a = { 1 };
	System.out.println(maxProfit(a));
    }

}
