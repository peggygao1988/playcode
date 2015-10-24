package org.peggygao.algs.number;

public class Count1 {

    private static int numberOf1(int n) {
	int count = 0;
	while (n != 0) {

	    n = (n - 1) & n;
	    count++;
	}

	return count;
    }

    private static int numberOf1_2(int n) {
	int count = 0;
	int key = 1;
	while (key != 0) {
	    if ((key & n) != 0) {
		count++;
	    }
	    key = key << 1;
	}

	return count;
    }

    public static void main(String[] args) {
	System.out.println(numberOf1_2(-2147483648));

    }

}
