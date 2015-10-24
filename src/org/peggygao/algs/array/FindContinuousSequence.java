package org.peggygao.algs.array;

public class FindContinuousSequence {

    private static void find(int sum) {

	if (sum < 3) {
	    return;
	}

	int low = 1;
	int high = 2;
	int mid = (sum + 1) / 2;
	int curSum = low + high;
	while (low < mid) {

	    if (curSum == sum) {
		print(low, high);
		high++;
		curSum += high;
	    } else if (curSum < sum) {
		high++;
		curSum += high;
	    } else {
		curSum -= low;
		low++;
	    }

	}

    }

    private static void print(int low, int high) {
	for (int i = low; i <= high; i++) {
	    System.out.print(i + " ");
	}
	System.out.println();
    }

    public static void main(String[] args) {
	find(15);

    }

}
