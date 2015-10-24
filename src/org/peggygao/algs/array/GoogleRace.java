package org.peggygao.algs.array;

/**
 * get rank by weight table
 * 
 * @author peggygao
 * 
 */
public class GoogleRace {

    private static void race(int[][] w, int[] order) {

	int round = order.length / 2;

	while (round > 0) {

	    int i = 0;
	    int j = 0;

	    while (j < round) {
		int win = w[order[i]][order[i + 1]];
		if (order[i] == win) {
		    swap(order, i, j);
		} else {
		    swap(order, i + 1, j);
		}
		j++;
		i += 2;
	    }
	    // System.out.print("round" + round + " : ");
	    // for (int k : order) {
	    // System.out.print(k + "\t");
	    // }
	    // System.out.println();
	    round /= 2;
	}

    }

    private static void swap(int[] order, int i, int j) {
	int temp = order[i];
	order[i] = order[j];
	order[j] = temp;
    }

    public static void main(String[] args) {
	int[][] w = { { -1, 0, 2, 0, 0, 0, 0, 0 }, { 0, -1, 2, 3, 4, 5, 6, 7 },
		{ 2, 2, -1, 2, 2, 2, 2, 2 }, { 0, 3, 2, -1, 3, 3, 3, 3 },
		{ 0, 4, 2, 3, -1, 4, 4, 4 }, { 0, 5, 2, 3, 4, -1, 6, 5 },
		{ 0, 6, 2, 3, 4, 6, -1, 6 }, { 0, 7, 2, 3, 4, 5, 6, -1 } };

	int[] order = { 0, 1, 2, 3, 4, 5, 6, 7 };
	race(w, order);
	for (int i : order) {
	    System.out.print(i + "\t");
	}
	System.out.println();
    }

}
