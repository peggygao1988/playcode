package org.peggygao.algs.array;

public class DeadProbability {

    private static int N = 10;

    private static double deadPro(int x, int y, int n) {
	if (x < 0 || x > N - 1 || y < 0 || y > N - 1) {
	    return 0.0;
	}

	return pro(x, y, n);
    }

    private static double pro(int x, int y, int n) {

	if (x < 0 || x > N - 1 || y < 0 || y > N - 1) {
	    return 1.0;
	} else if (n == 0) {
	    return 0.0;
	}

	double probabilty = 0.0;

	probabilty += 0.25 * pro(x - 1, y, n - 1);
	probabilty += 0.25 * pro(x + 1, y, n - 1);
	probabilty += 0.25 * pro(x, y - 1, n - 1);
	probabilty += 0.25 * pro(x, y + 1, n - 1);

	return probabilty;

    }

    public static void main(String[] args) {
	System.out.println(deadPro(0, 0, 2));
    }

}
