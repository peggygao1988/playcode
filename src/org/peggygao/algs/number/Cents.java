package org.peggygao.algs.number;

public class Cents {

    private static int waysOfCents(int sum, int value) {

	int next = 0;
	switch (value) {
	case 25:
	    next = 10;
	    break;
	case 10:
	    next = 5;
	    break;
	case 5:
	    next = 1;
	    break;
	case 1:
	    return 1;

	}

	int ways = 0;
	for (int i = 0; i * value <= sum; i++) {
	    ways += waysOfCents(sum - i * value, next);
	}

	return ways;

    }

    public static void main(String[] args) {
	System.out.println(waysOfCents(25, 25));

    }

}
