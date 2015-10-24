package org.peggygao.algs.number;

public class PrintMaxNDigits {

    private static boolean increment(char[] number) {
	boolean isOverflow = false;
	int overTake = 0;
	int sum = 0;
	for (int i = number.length - 1; i >= 0; i--) {

	    sum = number[i] - '0' + overTake;
	    if (i == number.length - 1) {
		sum++;
	    }

	    if (sum >= 10) {
		if (i == 0) {
		    isOverflow = true;
		} else {
		    overTake = 1;
		    sum -= 10;
		    number[i] = (char) (sum + '0');
		}
	    }

	    else {
		number[i] = (char) (sum + '0');
		break;
	    }

	}

	return isOverflow;
    }

    private static void print1ToN(int n) {

	if (n <= 0) {
	    return;
	}
	char[] number = new char[n];
	for (int i = 0; i < n; i++) {
	    number[i] = '0';
	}

	for (int i = 0; i < 10; i++) {
	    number[0] = (char) (i + '0');
	    print1ToNRecursive(number, 1);
	}

    }

    private static void print1ToNRecursive(char[] number, int index) {

	if (index == number.length) {
	    print(number);
	    return;
	}

	for (int i = 0; i < 10; i++) {
	    number[index] = (char) (i + '0');
	    print1ToNRecursive(number, index + 1);
	}

    }

    private static void print(char[] number) {
	boolean flag = false;

	for (int i = 0; i < number.length; i++) {
	    if (number[i] == '0' && !flag) {
		continue;
	    }

	    flag = true;
	    System.out.print(number[i]);
	}
	System.out.print("\t");
    }

    public static void main(String[] args) {

	// print1ToN(5);
	char[] number = new char[2];
	for (int i = 0; i < 2; i++) {
	    number[i] = '0';

	}

	while (!increment(number)) {
	    print(number);
	}

    }

}
