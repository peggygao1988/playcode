package org.peggygao.algs.number;

public class SwapOddEvenBit {

    private static int swap(int n) {

	return (n & 0xaaaaaaaa) >> 1 | (n & 0x55555555) << 1;
    }

    public static void main(String[] args) {
	System.out.println(swap(120));

    }

}
