package org.peggygao.algs.number;

public class Atoi {

    private static int atoi(char[] string) throws IllegalAccessException {

	if (string == null || string.length == 0) {
	    throw new IllegalArgumentException("invalid input");
	}

	int start = 0;
	while(string[start]==' '){
	    start++;
	}
	boolean negative = false;
	if (string[start] == '-') {
	    negative = true;
	    start++;
	} else if (string[start] == '+') {
	    start++;
	}

	long result = 0;
	while (start < string.length) {
	    if (string[start] < '0' || string[0] > '9') {
		throw new IllegalAccessException("invalid input");
	    }

	    result = result * 10 + string[start] - '0';

	    if ((negative == false && result > Integer.MAX_VALUE)
		    || (negative == true && result > (long)-1*Integer.MIN_VALUE)) {
		throw new IllegalAccessException("invalid input");
	    }

	    start++;
	}

	if (negative) {
	    result *= -1;
	}
	return (int) result;
    }

    public static void main(String[] args) {
	try {
	    System.out.println(atoi("-1".toCharArray()));
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
