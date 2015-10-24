package org.peggygao.algs.array;

import java.util.Arrays;
/**
 * 
 * LIS related
 * @author peggygao
 *
 */
public class PieBridge {

    private static class Pie implements Comparable {
	int x;
	int y;

	public Pie(int x, int y) {
	    this.x = x;
	    this.y = y;
	}

	@Override
	public int compareTo(Object o) {
	    Pie p = (Pie) o;
	    if (this.x > p.x) {
		return 1;
	    } else if (this.x < p.x) {
		return -1;
	    }
	    return 0;
	}
    }

    private static int maxBridge(Pie[] pies) {

	Arrays.sort(pies);

	int max = 1;
	int[] maxLength = new int[pies.length];

	for (int i = 0; i < pies.length; i++) {

	    maxLength[i] = 1;

	    for (int j = 0; j < i; j++) {
		if (pies[j].y < pies[i].x && maxLength[j] + 1 > maxLength[i]) {
		    maxLength[i] = maxLength[j] + 1;
		}
	    }

	    if (maxLength[i] > max) {
		max = maxLength[i];
	    }

	}

	return max;
    }

    public static void main(String[] args) {

	Pie p1 = new Pie(15, 40);
	Pie p2 = new Pie(5, 8);
	Pie p3 = new Pie(1, 10);
	Pie p4 = new Pie(30, 31);
	Pie p5 = new Pie(34, 35);
	Pie p6 = new Pie(9, 20);
	Pie p7 = new Pie(36, 37);
	Pie p8 = new Pie(2, 4);

	Pie[] pies = { p1, p2, p3, p4, p5, p6, p7, p8 };
	System.out.println(maxBridge(pies));

    }

}
