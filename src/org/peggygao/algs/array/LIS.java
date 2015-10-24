package org.peggygao.algs.array;

public class LIS {

    private static int LIS1(int[] array) {

	int maxLength = 0;
	int[] lis = new int[array.length];

	for (int i = 0; i < array.length; i++) {

	    lis[i] = 1;

	    for (int j = 0; j < i; j++) {
		if (array[i] > array[j] && lis[i] < lis[j] + 1) {
		    lis[i] = lis[j] + 1;
		}
	    }

	    if (lis[i] > maxLength) {
		maxLength = lis[i];
	    }
	}

	return maxLength;
    }

    private static int LIS2(int[] array) {

	int maxLength = 1;
	int[] minMaxV = new int[array.length + 1];
	minMaxV[0] = Integer.MIN_VALUE;
	minMaxV[1] = array[0];
	int[] lis = new int[array.length];

	for (int i = 1; i < array.length; i++) {

	    int j = 0;
	    // for (j = maxLength; j >= 0; j--) {
	    // if (minMaxV[j] < array[i]) {
	    // lis[i] = j + 1;
	    // break;
	    // }
	    // }

	    int low = 0;
	    int high = maxLength;
	    while (low <= high) {

		if (minMaxV[high] < array[i]) {
		    lis[i] = high + 1;
		    j = high;
		    break;
		}
		int mid = low + (high - low) / 2;
		if (minMaxV[mid] > array[i]) {
		    if (minMaxV[mid - 1] < array[i]) {
			lis[i] = mid;
			j = mid - 1;
			break;
		    } else
			high = mid - 1;

		} else if (minMaxV[mid] < array[i]) {
		    if (mid + 1 < i && minMaxV[mid + 1] > array[i]) {
			lis[i] = mid + 1;
			j = mid;
			break;
		    } else if (mid == i - 1) {
			lis[i] = mid + 1;
			j = mid;
			break;
		    } else
			low = mid + 1;
		}
	    }

	    if (lis[i] > maxLength) {
		maxLength = lis[i];
		minMaxV[lis[i]] = array[i];
	    } else if (minMaxV[j + 1] > array[i] && minMaxV[j] < array[i]) {
		minMaxV[j + 1] = array[i];
	    }
	}

	return maxLength;

    }

    public static void main(String[] args) {

	int[] a = { -10, 2, -9 ,4, -8, 6, -7, 8 };
	System.out.println(LIS2(a));

    }

}
