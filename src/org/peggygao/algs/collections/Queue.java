package org.peggygao.algs.collections;

import java.util.Iterator;
import java.util.Scanner;

public class Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    public boolean isEmpty() {
	return size == 0;
    }

    public int size() {
	return size;
    }

    public void enqueue(Item item) {
	Node oldLast = last;
	last = new Node();
	last.item = item;

	last.next = null;

	if (isEmpty()) {
	    first = last;
	} else {
	    oldLast.next = last;
	}
	++size;

    }

    public Item dequeue() {
	Item item = first.item;

	first = first.next;
	--size;
	if (isEmpty()) {
	    last = null;
	}
	return item;
    }

    private class Node {
	Item item;
	Node next;
    }

    @Override
    public Iterator<Item> iterator() {
	return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

	private Node current = first;

	@Override
	public boolean hasNext() {
	    return current != null;
	}

	@Override
	public Item next() {
	    Item item = current.item;
	    current = current.next;
	    return item;
	}

	@Override
	public void remove() {
	    // TODO Auto-generated method stub

	}

    }

    public static void main(String[] args) {
	Queue<String> queue = new Queue<String>();
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
