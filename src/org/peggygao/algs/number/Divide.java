package org.peggygao.algs.number;

public class Divide {

    int divide(int num1, int num2) {

	int result = 0;
	int multiplier = 1;
	int left = num1;
	while (left >= num2) {

	    multiplier = 1;
	    while (num2 * multiplier <= left >> 1) {
		multiplier = multiplier << 1;
	    }

	    result += multiplier;
	    left = left - num1 * multiplier;

	}

	return result;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
