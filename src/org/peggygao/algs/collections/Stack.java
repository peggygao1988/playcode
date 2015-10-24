package org.peggygao.algs.collections;

import java.util.Iterator;
import java.util.Scanner;

public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int size;

    public boolean isEmpty() {
	return size == 0;
    }

    public int size() {
	return size;
    }

    public void push(Item item) {
	Node newNode = new Node();
	newNode.item = item;

	Node oldFirst = first;
	newNode.next = oldFirst;
	first = newNode;

	++size;
    }

    public Item pop() {
	Item item = first.item;
	first = first.next;
	--size;
	return item;
    }

    public Item peek() {
	Item item = first.item;
	return item;
    }

    private class Node {
	Item item;
	Node next;
    }

    @Override
    public Iterator<Item> iterator() {
	// TODO Auto-generated method stub
	return new StackItetator();
    }

    private class StackItetator implements Iterator<Item> {

	private Node head = first;

	@Override
	public boolean hasNext() {
	    return head != null;
	}

	@Override
	public Item next() {
	    Item item = head.item;
	    head = head.next;
	    return item;
	}

	@Override
	public void remove() {
	    // TODO Auto-generated method stub

	}

    }

    public static void main(String[] args) {
	Stack<String> stack = new Stack<String>();
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
