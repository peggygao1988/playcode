package org.peggygao.algs.array;

public class Candy {

    public static int candy(int[] ratings) {

	if (ratings == null || ratings.length == 0) {
	    return 0;
	}

	int N = ratings.length;
	int[] candy = new int[N];

	for (int i = 0; i < N; i++) {
	    candy[i] = 1;
	}

	for (int i = 1; i < N; i++) {
	    if (ratings[i - 1] < ratings[i]) {
		candy[i] = candy[i - 1] + 1;
	    }

	}

	int sum = candy[N - 1];
	for (int i = N - 2; i >= 0; i--) {
	    if (ratings[i] > ratings[i + 1]) {
		candy[i] = Math.max(candy[i], candy[i + 1] + 1);
	    }
	    sum += candy[i];
	}

	return sum;
    }

    public static void main(String[] args) {

	int[] a = { 1, 2, 3, 4, 2, 6 };
	System.out.println(candy(a));
    }

}
