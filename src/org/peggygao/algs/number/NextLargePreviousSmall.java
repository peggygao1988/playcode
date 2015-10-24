package org.peggygao.algs.number;

public class NextLargePreviousSmall {

    private static boolean getBit(int n, int index) {
	return (n & (1 << index)) > 0 ? true : false;
    }

    private static int setBit(int n, int index, boolean flag) {
	if (flag == true) {

	    return n | (1 << index);
	} else {

	    return n & ~(1 << index);

	}
    }

    private static int getNextLarge(int n) {

	if (n <= 0) {
	    return -1;
	}

	int index = 0;
	int countOne = 0;

	while (!getBit(n, index)) {
	    index++;
	}

	while (getBit(n, index)) {
	    index++;
	    countOne++;
	}

	n = setBit(n, index, true);
	index--;
	n = setBit(n, index, false);

	countOne--;
	for (int i = index - 1; i >= countOne; i--) {
	    n = setBit(n, i, false);
	}
	for (int i = countOne - 1; i >= 0; i--) {
	    n = setBit(n, i, true);
	}

	return n;

    }

    private static int getPreviousSmall(int n) {

	if (n <= 0) {
	    return -1;
	}

	int index = 0;
	int countzero = 0;

	while (getBit(n, index)) {
	    index++;
	}

	while (!getBit(n, index)) {
	    index++;
	    countzero++;
	}

	n = setBit(n, index, false);
	index--;
	n = setBit(n, index, true);

	for (int i = index - 1; i >= countzero; i--) {
	    n = setBit(n, i, true);
	}
	
	for(int i = countzero-1; i >=0; i--){
	    n = setBit(n, i, false);
	}
	
	return n;
    }

    public static void main(String[] args) {

	System.out.println(getNextLarge(184));
	System.out.println(getPreviousSmall(195));
    }

}
