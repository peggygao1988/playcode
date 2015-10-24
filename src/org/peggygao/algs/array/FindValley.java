package org.peggygao.algs.array;

public class FindValley {

    private static int findValley(int[] a) {

	if (a == null || a.length == 0) {
	    return -1;
	}

	int low = 0;
	int high = a.length - 1;

	while (low <= high) {
	    int mid = low + (high - low) / 2;

	    if (a[mid - 1] > a[mid] && a[mid + 1] > a[mid]) {
		return mid;
	    } else if (a[mid - 1] < a[mid] && a[mid] < a[mid + 1]) {

		high = mid - 1;
	    } else if (a[mid - 1] > a[mid] && a[mid] > a[mid + 1]) {
		low = mid + 1;
	    } else {
		high = mid - 1;
	    }

	}

	return -1;
    }

    public static void main(String[] args) {
	int[] a = { 9, 7, 7, 2, 1, 3, 7 };

	System.out.println(findValley(a));
    }
}
