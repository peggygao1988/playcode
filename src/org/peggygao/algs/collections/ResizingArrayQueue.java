package org.peggygao.algs.collections;

import java.util.Iterator;
import java.util.Scanner;

public class ResizingArrayQueue<Item> implements Iterable<Item> {

    Item[] a = (Item[]) new Object[1];
    private int head = -1;
    private int tail = 0;

    private int size = 0;

    public boolean isEmpty() {
	return size == 0;
    }

    public int size() {
	return size;
    }

    public void enqueue(Item item) {

	a[tail++] = item;
	if (head == -1) {
	    head = 0;
	}
	if (tail == a.length) {
	    tail = 0;
	}

	size++;

	if (size == a.length) {
	    resize(a.length * 2);
	}

    }

    public Item dequeue() {

	Item item = a[head++];
	a[head - 1] = null;
	if (head == a.length) {
	    head = 0;
	}
	--size;

	if (size == a.length / 4) {
	    resize(a.length / 2);
	}
	return item;
    }

    private void resize(int max) {
	Item[] temp = (Item[]) new Object[max];
	int i = 0;
	for (; i < size; i++, head = (++head) % a.length) {
	    temp[i] = a[head];

	}
	a = temp;
	head = 0;
	tail = i;

    }

    @Override
    public Iterator<Item> iterator() {
	return new ResizingArrayQueueIterator();
    }

    private class ResizingArrayQueueIterator implements Iterator<Item> {

	private int i = head;
	private int n = size;

	@Override
	public boolean hasNext() {
	    return n != 0;
	}

	@Override
	public Item next() {
	    n--;
	    return a[(i++) % a.length];

	}

	@Override
	public void remove() {
	    // TODO Auto-generated method stub

	}

    }

    public static void main(String[] args) {
	ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();

	Scanner scanner = new Scanner(System.in);
	while (scanner.hasNext()) {
	    String input = scanner.next();
	    if (input.equals("#")) {
		break;
	    } else if (!input.equals("-")) {
		queue.enqueue(input);
	    } else {
		System.out.println(queue.dequeue());
	    }
	    System.out.println("is Empty :" + queue.isEmpty());
	    System.out.println("queue size : " + queue.size());
	}

	scanner.close();

	for (String s : queue) {
	    System.out.println(s);
	}

    }

}
