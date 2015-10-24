package org.peggygao.algs.number;

public class BigNumberAdd {

    private static int[] add(String num1, String num2) {

	int len1 = num1.length();
	int len2 = num2.length();
	if (len1 > len2) {
	    for (int i = 0; i < len1 - len2; i++) {
		num2 = '0' + num2;
	    }
	} else {
	    for (int i = 0; i < len2 - len1; i++) {
		num1 = '0' + num1;
	    }
	}

	char[] add1 = num1.toCharArray();
	char[] add2 = num2.toCharArray();
	int[] sum = new int[Math.max(len1, len2) + 1];

	int overtake = 0;
	for (int i = add1.length - 1; i >= 0; i--) {
	    int temp = (add1[i] - '0') + (add2[i] - '0') + overtake;
	    if (temp > 9) {
		overtake = 1;
	    } else {
		overtake = 0;
	    }
	    sum[i + 1] = temp % 10;
	}

	if (overtake == 1) {
	    sum[0] = 1;
	}

	return sum;

    }

    private static void printSum(int[] sum) {

	boolean flag = false;

	for (int i = 0; i < sum.length; i++) {
	    if (sum[i] == 0 && !flag) {
		continue;
	    }
	    flag = true;
	    System.out.print(sum[i]);
	}
    }

    public static void main(String[] args) {
	String s1 = "399";
	String s2 = "1";
	printSum(add(s1, s2));

    }

}
