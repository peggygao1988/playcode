package org.peggygao.algs.array;

public class FindInRotateDecreaseArray {

    private static int find(int[] a, int k, int start, int end) {

	if (start == end) {
	    if (a[start] == k) {
		return start;
	    } else {
		return -1;
	    }

	}
	int mid = start + (end - start) / 2;

	if (a[mid] == k) {
	    return mid;
	}
	if (a[mid] < a[start]) {

	    if (k > a[mid] && k <= a[start]) {
		return find(a, k, start, mid - 1);
	    } else {
		return find(a, k, mid + 1, end);
	    }
	} else {

	    if (k < a[mid] && k >= a[end]) {
		return find(a, k, mid + 1, end);
	    } else {
		return find(a, k, start, mid - 1);
	    }

	}

    }

    public static int search(int[] A, int target) {

	if (A == null || A.length == 0) {
	    return -1;
	}

	int start = 0;
	int end = A.length - 1;
	while (start <= end) {
	    int mid = start + (end - start) / 2;

	    if (A[mid] == target) {
		return mid;
	    }
	    if (A[mid] >= A[start]) {
		if (target >= A[start] && target < A[mid]) {
		    end = mid - 1;
		} else {
		    start = mid + 1;
		}
	    }
	    if (A[mid] < A[end]) {
		if (target <= A[end] && target > A[mid]) {
		    start = mid + 1;
		} else {
		    end = mid - 1;
		}
	    }

	}

	return -1;

    }

    private static int searchDup(int[] A, int target) {
	if (A == null || A.length == 0) {
	    return -1;
	}

	int start = 0;
	int end = A.length - 1;
	while (start <= end) {
	    int mid = start + (end - start) / 2;

	    if (A[mid] == target) {
		return mid;
	    }
	    if (A[mid] > A[start]) {
		if (target >= A[start] && target < A[mid]) {
		    end = mid - 1;
		} else {
		    start = mid + 1;
		}
	    } else if (A[mid] < A[start]) {
		if (target <= A[end] && target > A[mid]) {
		    start = mid + 1;
		} else {
		    end = mid - 1;
		}
	    } else {
		start++;
	    }

	}

	return -1;
    }

    public static void main(String[] args) {
	int[] a = { 1, 3, 1, 1, 1 };
	// System.out.println(find(a, 3, 0, a.length - 1));

	// int[] a = { 1 };
	System.out.println(searchDup(a, 1));

    }

}
