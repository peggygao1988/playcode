package org.peggygao.algs.search;

public class SequentialSearchST<Key, Value>
{

	private Node first;

	private class Node
	{
		Key key;
		Value value;
		Node next;

		public Node(Key key, Value value, Node next)
		{
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}

	public Value get(Key key)
	{
		for (Node x = first; x != null; x = x.next)
		{
			if (x.key.equals(key))
			{
				return x.value;
			}
		}

		return null;
	}

	public void put(Key key, Value value)
	{

		for (Node x = first; x != null; x = x.next)
		{
			if (x.key.equals(key))
			{
				x.value = value;
				return;
			}
		}

		first = new Node(key, value, first);
	}

	public void delete(Key key)
	{

		if (first.key.equals(key))
		{
			first = first.next;
			return;
		}
		Node prev = first;
		for (Node x = first.next; x != null; prev = x, x = x.next)
		{
			if (x.key.equals(key))
			{
				prev.next = x.next;

			}
		}
	}

	public void print()
	{
		for (Node x = first; x != null; x = x.next)
		{
			System.out.print(x.key + " : " + x.value + "    ");
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		SequentialSearchST<Integer, Integer> st = new SequentialSearchST<Integer, Integer>();
		for (int i = 0; i < 10; i++)
		{
			st.put(i, i);
		}
		st.print();
		st.delete(0);
		st.print();
	}

}
