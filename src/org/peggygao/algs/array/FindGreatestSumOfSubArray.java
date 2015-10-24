package org.peggygao.algs.array;

public class FindGreatestSumOfSubArray {

    private static int find(int[] a) {

	if (a == null || a.length == 0) {
	    return 0;
	}

	int currentSum = 0;
	int maxSum = Integer.MIN_VALUE;

	for (int i = 0; i < a.length; i++) {

	    if (currentSum < 0) {
		currentSum = a[i];
	    } else {
		currentSum += a[i];
	    }

	    if (currentSum > maxSum) {
		maxSum = currentSum;
	    }

	}

	return maxSum;

    }

    private static int find2(int[] a) {
	if (a == null || a.length == 0) {
	    return Integer.MIN_VALUE;
	}

	int sum = 0;
	int max = Integer.MIN_VALUE;

	for (int i = 0; i < a.length; i++) {

	    if (sum < 0) {
		sum = 0;

	    }
	    sum += a[i];
	    if (sum > max) {
		max = sum;
	    }
	}
	return max;
    }

    private static int findMinSum(int[] a) {
	if (a == null || a.length == 0) {
	    return Integer.MAX_VALUE;
	}

	int sum = 0;
	int min = Integer.MAX_VALUE;

	for (int i : a) {
	    if (sum > 0) {
		sum = 0;
	    }
	    sum += i;

	    if (sum < min) {
		min = sum;
	    }
	}
	return min;
    }

    public static void main(String[] args) {
	int[] a = { -1, -2, -3, -10, -4, -7, -2, -5 };
	int result = find2(a);
	System.out.println(result);
    }
}
