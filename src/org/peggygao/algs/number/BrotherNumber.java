package org.peggygao.algs.number;

import java.util.Arrays;

public class BrotherNumber {

    private static int getBrother(int n) {

	char[] result = Integer.toString(n).toCharArray();

	char previous = result[result.length - 1];
	int i = result.length - 2;
	for (; i >= 0; i--) {
	    if (result[i] < previous)
		break;
	    previous = result[i];
	}

	int min = i + 1;
	while (min < result.length&&result[min] > result[i]) {
//	    if (min == result.length-1) {
//		break;
//	    }
	    min++;
	}
	
	min--;

	char temp = result[i];
	result[i] = result[min];
	result[min] = temp;

	Arrays.sort(result, i + 1, result.length );
	return Integer.parseInt(String.valueOf(result));

    }

    public static void main(String[] args) {
	System.out.println(getBrother(34726641));
    }

}
