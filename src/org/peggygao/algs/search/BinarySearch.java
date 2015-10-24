package org.peggygao.algs.search;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] a, int key) {

	Arrays.sort(a);

	int low = 0;
	int high = a.length - 1;

	while (low <= high) {
	    int middle = (low + high) / 2;
	    if (a[middle] < key) {
		low = middle + 1;
	    } else if (a[middle] > key) {
		high = middle - 1;
	    } else {
		return middle;
	    }
	}
	return -1;

    }

    public static int binarySearchRecursive(int[] a, int key, int low,
	    int high, int depth) {
	if (low > high)
	    return -1;
	int middle = (low + high) / 2;

	System.out.printf("low : %d , high : %d , depth : %d \n", low, high,
		depth);
	if (a[middle] < key)
	    return binarySearchRecursive(a, key, middle + 1, high, ++depth);
	else if (a[middle] > key)
	    return binarySearchRecursive(a, key, low, middle - 1, ++depth);
	else
	    return middle;
    }

    public static int rank(int[] a, int key) {

	int low = 0;
	int high = a.length - 1;

	while (low <= high) {
	    int middle = (low + high) / 2;
	    if (a[middle] < key) {
		low = middle + 1;
	    } else if (a[middle] > key) {
		high = middle - 1;
	    } else {
		for (int i = middle - 1; i >= low; i--) {
		    if (a[i] < key) {
			return i + 1;
		    }
		}
		return low;
	    }
	}

	if (a[a.length - 1] < key) {
	    return a.length;
	} else if (a[0] > key) {
	    return -1;
	}
	return low;
    }

    public static void main(String[] args) {

	int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	// Arrays.sort(a);
	System.out.println(binarySearch(a, 4));
    }
}
