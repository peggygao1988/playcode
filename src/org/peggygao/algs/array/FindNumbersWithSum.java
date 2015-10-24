package org.peggygao.algs.array;

public class FindNumbersWithSum {

    private static boolean find(int[] a, int sum) {

	boolean found = false;
	if (a == null || a.length < 2) {
	    return found;
	}

	int low = 0;
	int high = a.length - 1;

	while (low < high) {

	    int curSum = a[low] + a[high];
	    if (curSum > sum) {
		high--;
	    } else if (curSum < sum) {
		low++;
	    } else {
		System.out.printf("%d %d \n", a[low], a[high]);
		found = true;
		break;
	    }

	}

	return found;
    }

    public static void main(String[] args) {
	find(new int[] { 1, 2, 4, 7, 11, 15 }, 15);

    }

}
