package org.peggygao.algs.collections;

import java.util.Scanner;

public class MaxHeap<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MaxHeap(int maxN) {
	pq = (Key[]) new Comparable[maxN + 1];

    }

    private boolean less(int i, int j) {
	return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
	Key temp = pq[i];
	pq[i] = pq[j];
	pq[j] = temp;

    }

    private void swim(int k) {
	while (k > 1 && less(k / 2, k)) {
	    exch(k, k / 2);
	    k = k / 2;
	}

    }

    private void sink(int k) {

	while (2 * k <= N) {
	    int j = 2 * k;
	    if (j < N && less(j, j + 1)) {
		j++;
	    }
	    if (less(k, j)) {
		exch(k, j);
		k = j;
	    } else {
		break;
	    }
	}
    }

    public boolean isEmpty() {
	return N == 0;
    }

    public int size() {
	return N;
    }

    public void insert(Key v) {
	pq[++N] = v;

	swim(N);
    }

    public Key deletMax() {
	Key max = pq[1];

	pq[1] = pq[N--];
	pq[N + 1] = null;

	sink(1);

	return max;
    }

    public void print() {
	for (Key k : pq) {
	    System.out.print(k + "   ");
	}
	System.out.println();
    }

    public static void main(String[] args) {
	MaxHeap<String> mh = new MaxHeap<>(10);
	Scanner in = new Scanner(System.in);
	while (in.hasNext()) {
	    String input = in.nextLine();
	    if (input.equals("-")) {
		System.out.println(mh.deletMax());
	    } else if (input.equals("$")) {
		break;
	    } else {
		mh.insert(input);
	    }
	}
	mh.print();
    }

}
