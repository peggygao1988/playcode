package org.peggygao.algs.number;

public class BinaryHex {

    private static void dec2Binary(int num) {

	if (num <= 1) {
	    System.out.print(num);
	    return;
	}

	dec2Binary(num / 2);
	System.out.print(num % 2);

    }

    private static char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
	    '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    private static void dec2Hex(int num) {
	if (num <= 15) {
	    System.out.print(hex[num]);
	    return;
	}
	dec2Hex(num / 16);
	System.out.print(hex[num % 16]);
    }

    public static void main(String[] args) {
	dec2Binary(37);
	System.out.println();
	dec2Hex(47);

    }

}
