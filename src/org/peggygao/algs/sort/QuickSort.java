package org.peggygao.algs.sort;

import java.util.Stack;

import org.peggygao.algs.collections.Queue;

public class QuickSort {

    private static int partition(Comparable[] a, int low, int high) {

	Comparable pivot = a[low];

	int i = low;
	int j = high + 1;

	while (true) {
	    while (a[++i].compareTo(pivot) < 0) {
		if (i == high)
		    break;
	    }
	    while (a[--j].compareTo(pivot) > 0) {
		if (j == low)
		    break;
	    }

	    if (i >= j)
		break;

	    Comparable temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	Comparable temp = a[low];
	a[low] = a[j];
	a[j] = temp;
	return j;

    }

    private static void sort(Comparable[] a) {
	sort(a, 0, a.length - 1);

    }

    private static void sort(Comparable[] a, int low, int high)

    {
	if (low >= high) {
	    return;
	}

	int pivot = partition(a, low, high);
	sort(a, low, pivot - 1);
	sort(a, pivot + 1, high);

    }

    public static void sortNonRecur(Comparable[] a) {

	if (a == null || a.length == 0) {
	    return;
	}

	// Stack<Integer> stack = new Stack<Integer>();
	Queue<Integer> queue = new Queue<Integer>();
	int start = 0;
	int end = a.length - 1;

	queue.enqueue(start);
	queue.enqueue(end);
	// stack.push(start);
	// stack.push(end);

	while (!queue.isEmpty()) {

	    // end = stack.pop();
	    // start = stack.pop();
	    start = queue.dequeue();
	    end = queue.dequeue();
	    int pivot = partition(a, start, end);

	    if (start < pivot - 1) {

		queue.enqueue(start);
		queue.enqueue(pivot - 1);
		// stack.push(start);
		// stack.push(pivot - 1);
	    }
	    if (end > pivot + 1) {
		queue.enqueue(pivot + 1);
		queue.enqueue(end);
		// stack.push(pivot + 1);
		// stack.push(end);
	    }
	}

    }

    public static void print(Comparable[] a) {
	for (Comparable e : a)

	{
	    System.out.print(e + "  ");
	}
	System.out.println();
    }

    public static void main(String[] args) {
	Comparable[] array = { 'Q', 'U', 'I', 'C', 'K', 'S', 'O', 'R', 'T',
		'E', 'X', 'A', 'M', 'P', 'L', 'E' };
	sort(array);
	print(array);

    }

}
