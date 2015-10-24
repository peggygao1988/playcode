package org.peggygao.algs.array;

/**
 * find max a[i]-a[j] where i < j
 * 
 * @author peggygao
 * 
 */
public class MaxDiff {

    private static int max = 0;
    private static int min = 0;

    public static int maxDiffCore1(int[] a, int start, int end) {
	if (start == end) {
	    max = a[start];
	    min = a[end];
	    return -1;
	}

	int middle = start + (end - start) / 2;

	int diffLeft = maxDiffCore1(a, start, middle);
	int maxLeft = max;
	int minLeft = min;

	int diffRight = maxDiffCore1(a, middle + 1, end);
	int maxRight = max;
	int minRight = min;

	max = maxRight > maxLeft ? maxRight : maxLeft;
	min = minRight < minLeft ? minRight : minLeft;

	int crossDiff = maxLeft - minRight;
	int maxDiff = diffLeft > diffRight ? diffLeft : diffRight;
	maxDiff = maxDiff > crossDiff ? maxDiff : crossDiff;

	return maxDiff;
    }

    public static int maxDiffCore2(int[] a, int start, int end) {
	int[] diff = new int[a.length - 1];

	for (int i = 1; i < a.length; i++) {
	    diff[i - 1] = a[i - 1] - a[i];
	}

	int maxSum = 0;
	int currentSum = Integer.MIN_VALUE;
	for (int i = 0; i < diff.length; i++) {

	    if (currentSum < 0) {
		currentSum = 0;
	    }
	    currentSum += diff[i];
	    if (currentSum > maxSum) {
		maxSum = currentSum;
	    }
	}

	return maxSum;

    }

    private static int maxDiffCore3(int[] a, int start, int end) {
	int min = a[a.length - 1];
	int maxDif = Integer.MIN_VALUE;

	for (int i = a.length - 1; i >= 0; i--) {

	    if (min > a[i]) {
		min = a[i];
	    }

	    int dif = a[i] - min;

	    if (dif > maxDif) {
		maxDif = dif;
	    }

	}

	return maxDif;
    }

    private static int maxDiffCore4(int[] a) {
	int maxDif = 0;
	int max = a[0];

	for (int i = 1; i < a.length; i++) {
	    if (max < a[i]) {
		max = a[i];
	    }

	    int dif = max - a[i];

	    if (dif > maxDif) {
		maxDif = dif;
	    }
	}

	return maxDif;
    }

    public static void main(String[] args) {
	int[] array = { 2, 4, 1, 16, 7, 5, 11, 9 };
	int result = maxDiffCore3(array, 0, array.length - 1);
	System.out.println("maxDiff is " + result);
	System.out.println(maxDiffCore4(array));
    }
}
