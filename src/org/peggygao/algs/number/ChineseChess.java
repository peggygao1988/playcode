package org.peggygao.algs.number;

public class ChineseChess {

    private static final int FULL_MASK = 255; // 11111111;
    private static final int LEFT_MASK = 240; // 11110000
    private static final int RIGHT_MASK = FULL_MASK >> 4; // 00001111

    private static byte rset(byte b, int n) {

	b = (byte) ((b & LEFT_MASK) | n);
	return b;
    }

    private static byte lset(byte b, int n) {
	b = (byte) ((b & RIGHT_MASK) | (n << 4));
	return b;
    }

    private static byte getR(byte b) {
	return (byte) (b & RIGHT_MASK);
    }

    private static byte getL(byte b) {
	return (byte) ((b & LEFT_MASK) >> 4);
    }

    private static void permutation(byte b) {

	for (b = lset(b, 1); getL(b) <= 9; b = lset(b, getL(b) + 1)) {
	    for (b = rset(b, 1); getR(b) <= 9; b = rset(b, getR(b) + 1)) {
		if (getL(b) % 3 != getR(b) % 3) {
		    print(b);
		}
	    }
	}
    }

    private static void print(byte b) {
	System.out.println(String.format("A=%d B=%d", getL(b), getR(b)));
    }

    public static void main(String[] args) {
	permutation((byte) 0);

    }
}
