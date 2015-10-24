package org.peggygao.algs.array;

public class AntsOnLog {

    private static void minMax(int length, int[] positions) {

	int min = Integer.MIN_VALUE;
	int max = Integer.MIN_VALUE;

	int mid = length / 2;
	for (int p : positions) {

	    if (p <= mid) {
		min = Math.max(min, p);
		max = Math.max(max, length - p);
	    } else {
		min = Math.max(length - p, min);
		max = Math.max(max, p);
	    }
	}

	System.out.println(String.format("max time : %d  min time : %d", max,
		min));
    }

    public static void main(String[] args) {
	minMax(27, new int[] { 3, 7, 13, 17, 23 });

    }
}
