package org.peggygao.algs.number;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FindLostNumber {

    private static void findLost() throws FileNotFoundException {

	byte[] bits = new byte[0xFFFFFFFF / 8];

	Scanner in = new Scanner(new FileReader("input.txt"));

	while (in.hasNextInt()) {
	    int n = in.nextInt();

	    bits[n / 8] |= 1 << (n % 8);
	}

	for (int i = 0; i < bits.length; i++) {
	    for (int j = 0; j < 8; j++) {

		if ((bits[i] & (1 << j)) == 0) {
		    System.out.println(i * 8 + j);
		}
	    }
	}

    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
