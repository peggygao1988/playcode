package org.peggygao.algs.array;

public class FindOccurence {

    private static int getFirstK(int[] a, int k) {

	if (a == null || a.length == 0) {
	    return -1;
	}

	int start = 0;
	int end = a.length - 1;
	while (start <= end) {

	    int mid = start + (end - start) / 2;
	    int n = a[mid];

	    if (n == k) {
		if (mid > 0 && a[mid - 1] != k || mid == 0) {
		    return mid;
		} else {
		    end = mid - 1;
		}
	    } else if (n > k) {
		end = mid - 1;
	    } else {
		start = mid + 1;
	    }

	}

	return -1;

    }

    private static int getLastK(int[] a, int k) {
	if (a == null || a.length == 0) {
	    return -1;
	}

	int start = 0;
	int end = a.length - 1;
	while (start <= end) {

	    int mid = start + (end - start) / 2;
	    int n = a[mid];

	    if (n == k) {
		if (mid < a.length-1 && a[mid + 1] != k || mid == a.length - 1) {
		    return mid;
		} else {
		    start = mid + 1;
		}
	    } else if (n > k) {
		end = mid - 1;
	    } else {
		start = mid + 1;
	    }

	}

	return -1;

    }

    private static int occurence(int[] a, int k) {
	if (a == null || a.length == 0) {
	    return 0;
	}

	int first = getFirstK(a, k);
	int last = getLastK(a, k);
	if (first != -1 && last != -1) {
	    return last - first + 1;
	}

	return 0;
    }

    public static void main(String[] args) {
	System.out.println(occurence(new int[] { 1, 2, 3, 3, 3, 3, 4, 5 }, 6));

    }

}
