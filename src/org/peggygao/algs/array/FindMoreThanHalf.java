package org.peggygao.algs.array;

public class FindMoreThanHalf {

    /**
     * O(n)
     * 
     * @param numbers
     * @param k
     * @return
     */
    private static int find(int[] numbers, int k) {

	if (numbers == null || numbers.length == 0 || k <= 0
		|| k > numbers.length) {
	    return 0;
	}

	int start = 0;
	int end = numbers.length - 1;

	while (start <= end) {
	    int pivot = partition(numbers, start, end);
	    if (pivot == k - 1) {
		for (int i = 0; i < k; i++) {
		    System.out.print(numbers[i]);
		}
		System.out.println();
		return numbers[pivot];
	    } else if (pivot > k - 1) {
		end = pivot - 1;
	    } else if (pivot < k - 1) {
		start = pivot + 1;
	    }
	}

	return numbers[k];

    }

    private static int partition(int[] numbers, int start, int end) {

	if (start == end) {
	    return start;
	}
	int pivot = numbers[start];

	int i = start;
	int j = end + 1;

	while (true) {
	    while (numbers[++i] < pivot) {
		if (i == end) {
		    break;
		}
	    }
	    while (numbers[--j] > pivot) {
		if (j == start) {
		    break;
		}
	    }

	    if (i >= j) {
		break;
	    }

	    int temp = numbers[i];
	    numbers[i] = numbers[j];
	    numbers[j] = temp;
	}

	int temp = numbers[j];
	numbers[j] = numbers[start];
	numbers[start] = temp;

	return j;

    }

    private static int find2(int[] a) {
	int candidate = 0;
	int times = 0;
	for (int i = 0; i < a.length; i++) {
	    if (times == 0) {
		candidate = a[i];
		times = 1;
	    } else {

		if (candidate == a[i]) {
		    times++;
		} else {
		    times--;
		}
	    }
	}
	return candidate;
    }

    private static void find3(int[] a) {
	int[] candidate = new int[3];
	int[] count = new int[3];

	for (int i = 0; i < a.length; i++) {
	    int m = 0;
	    for (; m < 3; m++) {
		if (candidate[m] == a[i]) {

		    count[m]++;
		    break;
		}
	    }
	    if (m < 3) {
		continue;
	    }
	    int j = 0;
	    for (; j < 3; j++) {
		if (count[j] == 0) {
		    candidate[j] = a[i];
		    count[j] = 1;
		    break;
		}
	    }

	    if (j == 3) {
		for (int k = 0; k < 3; k++) {
		    count[k]--;
		}
	    }
	}

	for (int i = 0; i < 3; i++) {
	    System.out.println(candidate[i]);
	}
    }

    public static void main(String[] args) {
	// find(new int[] { 1,2,3,4,5,6,7,9,8,10 }, 10);

	// System.out.println(find2(new int[]{3,5,3,5,8,3,3,3,3,6,7}));
	find3(new int[] { 4, 5, 6, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 7 });

    }

}
