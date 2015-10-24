package org.peggygao.algs.number;

public class DiceSum {

    private static int[] probability;

    private static void count(int n) {
	probability = new int[5 * n + 1];
	recursive(0, 0, n);
    }

    private static void recursive(int sum, int index, int n) {
	if (index == n) {
	    probability[sum - n]++;
	    return;
	}

	for (int i = 1; i <= 6; i++) {
	    recursive(sum + i, index + 1, n);
	}

    }

    private static void print() {
	for (int i = 0; i < probability.length; i++) {
	    System.out.print(probability[i] + "\t");
	}
	System.out.println();
    }

    private static void printPro(int k) {

	if (k < 1) {
	    return;
	}

	int[][] pro = new int[2][6 * k + 1];

	int flag = 0;

	for (int i = 1; i <= 6; i++) {
	    pro[flag][i] = 1;
	}

	for (int w = 2; w <= k; w++) {

	    for (int i = 0; i < w; i++) {
		pro[1 - flag][i] = 0;
	    }

	    for (int i = w; i <= w * 6; i++) {

		pro[1 - flag][i] = 0;
		for (int j = 1; j <= i && j <= 6; j++) {
		    pro[1 - flag][i] += pro[flag][i - j];
		}
	    }

	    flag = 1 - flag;
	}

	for (int i = k; i <= k * 6; i++) {
	    System.out.print(pro[flag][i] + "\t");
	}

    }

    public static void main(String[] args) {
	count(2);
	print();
	printPro(2);
    }

}
