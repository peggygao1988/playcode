package org.peggygao.algs.number;

public class Fibonacci {

    private static int fib(int k) {
	int[] result = { 0, 1 };
	if (k <= 1) {
	    return result[k];
	}

	int preOne = 1;
	int preTwo = 0;

	int current = 0;
	for (int i = 2; i <= k; i++) {
	    current = preOne + preTwo;
	    preTwo = preOne;
	    preOne = current;
	}

	return current;
    }

    public static void main(String[] args) {
	System.out.println(fib(5));

    }

}
