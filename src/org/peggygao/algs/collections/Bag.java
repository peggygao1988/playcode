package org.peggygao.algs.collections;

import java.util.Iterator;
import java.util.Scanner;

public class Bag<Item> implements Iterable<Item>
{

	private Node first;
	private int size;

	public boolean isEmpty()
	{
		return first == null;
	}

	public int size()
	{
		return size;
	}

	public void add(Item item)
	{
		Node oldFisrt = first;
		first = new Node();
		first.item = item;
		first.next = oldFisrt;

		size++;
	}

	private class Node
	{
		Item item;
		Node next;
	}

	@Override
	public Iterator<Item> iterator()
	{
		// TODO Auto-generated method stub
		return new BagIterator();
	}

	private class BagIterator implements Iterator<Item>
	{

		private Node current = first;

		@Override
		public boolean hasNext()
		{
			return current != null;
		}

		@Override
		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove()
		{
			// TODO Auto-generated method stub

		}

	}

	public static void main(String[] args)
	{

		Bag<String> bag = new Bag<String>();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			String input = scanner.next();

			if (input.equals("#"))
			{
				break;
			}
			if (!input.equals("-"))
			{
				bag.add(input);
			}

			System.out.println("size : " + bag.size());
		}

		scanner.close();

		for (String s : bag)
		{
			System.out.println(s);
		}

	}

}
