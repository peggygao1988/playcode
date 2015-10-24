package org.peggygao.algs.number;

public class Sum {
    private static int add(int num1, int num2) {

	int sum = 0;
	int carry = 0;
	do {
	    sum = num1 ^ num2;
	    carry = (num1 & num2) << 1;

	    num1 = sum;
	    num2 = carry;

	} while (carry != 0);

	return num1;
    }

    public static void main(String[] args) {

	System.out.println(add(-5, 0));
    }

}
