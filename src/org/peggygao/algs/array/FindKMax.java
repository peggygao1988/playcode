package org.peggygao.algs.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKMax {

    private static void find(int[] a, int k) {

	// minHeap O(NlogK)

	/**
	 * 
	 * parition O(N)
	 */
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);

	for (int i = 0; i < a.length - 1; i++) {
	    if (pq.size() < k) {
		pq.add(a[i]);
	    }

	    else if (a[i] > pq.peek()) {
		pq.poll();
		pq.add(a[i]);
	    }
	}

	for (Integer i : pq) {
	    System.out.print(i + "\t");
	}
	System.out.println();
    }

    public static void main(String[] args) {
	int[] a = new int[1000];
	List<Integer> list = new ArrayList<Integer>();
	for (int i = 0; i < 1000; i++) {
	    list.add(i);
	}
	Collections.shuffle(list);

	for (int i = 0; i < 1000; i++) {
	    a[i] = (int) list.get(i);
	}
	find(a, 10);
    }
}
