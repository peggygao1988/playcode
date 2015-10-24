package org.peggygao.algs.array;

/**
 * find max subArraySum difference
 * 
 * @author peggygao
 * 
 */
public class MaxDisjointSubArrayDiff {

    private static int[] leftMin;
    private static int[] leftMax;
    private static int[] rightMin;
    private static int[] rightMax;

    private static void preCompute(int[] a) {

	int N = a.length;
	leftMin = new int[N];
	leftMax = new int[N];
	rightMin = new int[N];
	rightMax = new int[N];

	for (int i = 0; i < N; i++) {
	    leftMin[i] = Integer.MAX_VALUE;
	    rightMin[i] = Integer.MAX_VALUE;
	}
	for (int i = 0; i < N; i++) {
	    leftMax[i] = Integer.MIN_VALUE;
	    rightMax[i] = Integer.MIN_VALUE;
	}

	int currentSum = 0;
	int currentSum2 = 0;
	for (int i = 1; i < leftMax.length; i++) {
	    if (currentSum < 0) {
		currentSum = 0;
	    }
	    currentSum += a[i - 1];

	    if (currentSum > leftMax[i - 1]) {
		leftMax[i] = currentSum;
	    } else {
		leftMax[i] = leftMax[i - 1];
	    }

	    if (currentSum2 > 0) {
		currentSum2 = 0;
	    }
	    currentSum2 += a[i - 1];
	    if (currentSum2 < leftMin[i - 1]) {
		leftMin[i] = currentSum2;
	    } else {
		leftMin[i] = leftMin[i - 1];
	    }
	}

	currentSum = 0;
	currentSum2 = 0;
	for (int i = N - 2; i >= 0; i--) {

	    if (currentSum < 0) {
		currentSum = 0;
	    }
	    currentSum += a[i + 1];
	    if (currentSum > rightMax[i + 1]) {
		rightMax[i] = currentSum;
	    } else {
		rightMax[i] = rightMax[i + 1];
	    }

	    if (currentSum2 > 0) {
		currentSum2 = 0;
	    }
	    currentSum2 += a[i + 1];
	    if (currentSum2 < rightMin[i + 1]) {
		rightMin[i] = currentSum2;
	    } else {
		rightMin[i] = rightMin[i + 1];
	    }
	}

    }

    private static int maxDifference() {
	int currnetDiff = 0;
	int maxDif = Integer.MIN_VALUE;
	int N = leftMax.length;
	for (int i = 1; i < leftMax.length; i++) {

	    currnetDiff = leftMax[i] - rightMin[i - 1];
	    if (currnetDiff > maxDif) {
		maxDif = currnetDiff;
	    }

	    currnetDiff = rightMax[i - 1] - leftMin[i];
	    if (currnetDiff > maxDif) {
		maxDif = currnetDiff;
	    }
	}

	return maxDif;
    }

    public static void main(String[] args) {

	int[] a = { 2, -1, -2, 1, -4, 2, 8 };
	preCompute(a);
	for (int i : leftMax) {
	    System.out.print(i + "\t");
	}
	System.out.println();
	for (int i : leftMin) {
	    System.out.print(i + "\t");
	}
	System.out.println();
	for (int i : rightMax) {
	    System.out.print(i + "\t");
	}
	System.out.println();
	for (int i : rightMin) {
	    System.out.print(i + "\t");
	}
	System.out.println();
	System.out.println(maxDifference());
    }

}
