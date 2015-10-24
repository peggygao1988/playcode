package org.peggygao.algs.number;

public class UglyNumber {

    private static int ugly(int index) {

	if (index <= 0) {
	    return 0;
	}
	int[] uglyNumners = new int[index];

	uglyNumners[0] = 1;

	int index2 = 0;
	int index3 = 0;
	int index5 = 0;

	int nextIndex = 1;

	while (nextIndex < index) {

	    uglyNumners[nextIndex] = Math.min(uglyNumners[index2] * 2,
		    Math.min(uglyNumners[index3] * 3, uglyNumners[index5] * 5));

	    while (uglyNumners[index2] * 2 <= uglyNumners[nextIndex]) {
		index2++;
	    }

	    while (uglyNumners[index3] * 3 <= uglyNumners[nextIndex]) {
		index3++;
	    }

	    while (uglyNumners[index5] * 5 <= uglyNumners[nextIndex]) {
		index5++;
	    }

	    nextIndex++;

	}

	return uglyNumners[index - 1];

    }

    private static void generateSerial() {
	int index2 = 0;
	int index5 = 0;

	int ex2 = 0;
	int ex5 = 0;
	int[] serial = new int[10];
	serial[0] = 1;
	print(ex2, ex5, serial[0]);
	int next = 1;
	while (next <= 9) {
	    serial[next] = Math.min(serial[index2] * 2, serial[index5] * 5);
	    if (serial[index2] * 2 < serial[index5] * 5) {
		ex2++;
	    } else {
		ex5++;
	    }
	    print(ex2, ex5, serial[next]);
	    while (serial[index2] * 2 <= serial[next]) {
		index2++;
	    }

	    while (serial[index5] * 5 <= serial[next]) {
		index5++;
	    }

	    next++;
	}
    }

    private static void print(int index2, int index5, int number) {
	System.out.println(String.format("2^%s * 5^%d = %d", index2, index5,
		number));
    }

    public static void main(String[] args) {
	// System.out.println(ugly(1500));
	generateSerial();
    }

}
