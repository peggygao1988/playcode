package org.peggygao.algs.array;

/**
 * all positive integers
 * 
 * if contains negative brute force O(N*N)
 * 
 * @author peggygao
 * 
 */
public class MinLengthSubArrayGreatThanSum {

    private static int minSubArray(int[] a, int s) {

	if (a == null || a.length == 0) {
	    return -1;
	}

	int i = 0;
	int j = 0;
	int sum = 0;
	int maxLength = Integer.MAX_VALUE;
	int length = 0;
	while (i < a.length) {

	    if (sum <= s) {
		if (j == a.length) {
		    break;
		}
		sum += a[j++];
		length++;
	    } else if (sum > s) {
		if (length < maxLength) {
		    maxLength = length;
		}

		sum -= a[i++];
		length--;
	    }
	}

	return maxLength;

    }

    public static void main(String[] args) {

	int[] a = { 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 };
	System.out.println(minSubArray(a, 10));
    }

}
