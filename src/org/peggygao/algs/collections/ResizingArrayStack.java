package org.peggygao.algs.collections;

import java.util.Iterator;
import java.util.Scanner;

public class ResizingArrayStack<Item extends Comparable<Item>> implements
	Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;
    private Stack<Integer> minStack = new Stack<Integer>();

    public int size() {
	return N;
    }

    public boolean isEmpty() {
	return N == 0;
    }

    public Item pop() {
	Item item = a[--N];
	a[N] = null;
	if (N <= a.length / 4) {
	    resize(a.length / 2);
	}

	minStack.pop();
	return item;
    }

    public void push(Item item) {
	if (N == a.length) {
	    resize(a.length * 2);
	}

	a[N++] = item;

	if (minStack.isEmpty()) {
	    minStack.push(0);
	}
	if (item.compareTo(a[minStack.peek()]) < 0) {
	    minStack.push(N - 1);
	} else {
	    minStack.push(minStack.peek());
	}

    }

    public Item min() {
	return a[minStack.peek()];
    }

    private void resize(int size) {
	Item[] temp = (Item[]) new Object[size];
	for (int i = 0; i < N; i++) {
	    temp[i] = a[i];

	}
	a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
	return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

	private int i = N;

	@Override
	public boolean hasNext() {
	    return i > 0;
	}

	@Override
	public Item next() {
	    return a[--i];
	}

	@Override
	public void remove() {
	    // TODO Auto-generated method stub

	}

    }

    public static void main(String[] args) {
	ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
	Scanner scanner = new Scanner(System.in);
	while (scanner.hasNext()) {
	    String input = scanner.next();

	    if (input.equals("#")) {
		break;
	    }
	    if (!input.equals("-")) {
		stack.push(input);
	    } else {
		if (!stack.isEmpty()) {
		    System.out.println(stack.pop());
		} else {
		    System.out.println("Stack is empty");
		}
	    }
	    System.out.println("size : " + stack.size());
	}

	scanner.close();

	for (String s : stack) {
	    System.out.println(s);
	}

    }
}
