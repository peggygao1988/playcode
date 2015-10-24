package org.peggygao.algs.array;

import java.util.Arrays;

/**
 * CTCI 9.7
 * 
 * @author peggygao
 * 
 */
public class CircusTower {

    static class HtWt implements Comparable<HtWt> {
	int height;
	int weight;

	public HtWt(int height, int weight) {
	    this.height = height;
	    this.weight = weight;
	}

	@Override
	public int compareTo(HtWt o) {

	    if (this == o) {
		return 0;
	    }
	    if (this.height == o.height) {
		return this.weight - o.weight;
	    }

	    return this.height - o.height;
	}
    }

    private static int maxHeightOfTower(HtWt[] a) {
	if (a == null || a.length == 0) {
	    return 0;
	}

	int max = 0;
	Arrays.sort(a);

	int[] dp = new int[a.length];
	for (int i = 0; i < a.length; i++) {

	    dp[i] = 1;

	    for (int j = 0; j < i; j++) {
		if (a[i].weight > a[j].weight && dp[i] < dp[j] + 1) {
		    dp[i] = dp[j] + 1;
		}
	    }

	    if (max < dp[i]) {
		max = dp[i];
	    }
	}

	return max;

    }

    public static void main(String[] args) {

	HtWt[] a = { new HtWt(65, 100), new HtWt(70, 150), new HtWt(56, 90),
		new HtWt(75, 190), new HtWt(68, 110), new HtWt(65, 95), };

	System.out.println(maxHeightOfTower(a));
    }

}
