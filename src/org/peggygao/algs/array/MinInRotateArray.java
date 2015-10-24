package org.peggygao.algs.array;

public class MinInRotateArray {

    private static int min(int[] a) {

	if (a == null || a.length == 0) {
	    return Integer.MAX_VALUE;
	}

	int low = 0;
	int high = a.length - 1;
	int mid = low;
	while (a[low] >= a[high]) {

	    if (low + 1 == high) {
		mid = high;
		break;
	    }

	    mid = (low + high) / 2;

	    if (a[low] == a[mid] && a[mid] == a[high]) {
		return minInOrder(a);
	    }

	    else if (a[low] <= a[mid]) {
		low = mid;
	    } else if (a[mid] <= a[high]) {
		high = mid;
	    }
	}

	return a[mid];

    }

    private static int minInOrder(int[] a) {
	int result = a[0];
	for (int i = 1; i < a.length; i++) {
	    if (a[i] < result) {
		result = a[i];
	    }
	}

	return result;
    }

    public static void main(String[] args) {

	System.out.println(min(new int[] { 1, 1, 1, 1, 0, 1 }));
    }

}
