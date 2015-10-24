package org.peggygao.algs.array;

import java.util.ArrayList;

public class Triangle {

    private static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

	int n = triangle.size();
	int[] sum = new int[n];

	for (int i = 0; i < n; i++) {
	    sum[i] = triangle.get(n - 1).get(i);
	}

	for (int i = n - 2; i >= 0; i--) {
	    for (int j = 0; j <= i; j++) {
		sum[j] = Math.min(sum[j], sum[j + 1]) + triangle.get(i).get(j);
	    }
	}

	return sum[0];

    }

    public static void main(String[] args) {
	ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> l = new ArrayList<Integer>();
	l.add(1);
	triangle.add(l);

	ArrayList<Integer> q = new ArrayList<Integer>();
	q.add(2);
	q.add(3);
	triangle.add(q);
	System.out.println(minimumTotal(triangle));
    }
}
