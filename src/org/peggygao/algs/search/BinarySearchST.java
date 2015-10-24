package org.peggygao.algs.search;

public class BinarySearchST<Key extends Comparable<Key>, Value>
{
	private int N;
	private Key[] keys;
	private Value[] values;

	public BinarySearchST(int cap)
	{
		keys = (Key[]) new Comparable[cap];
		values = (Value[]) new Object[cap];
	}

	public int size()
	{
		return N;
	}

	public boolean isEmpty()
	{
		return N == 0;
	}

	public int rank(Key key)
	{

		int lo = 0;
		int hi = N - 1;

		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (keys[mid].compareTo(key) > 0)
			{
				hi = mid - 1;
			}
			else if (keys[mid].compareTo(key) < 0)
			{
				lo = mid + 1;
			}
			else
			{
				return mid;
			}
		}

		return lo;
	}

	public Value get(Key key)
	{
		if (isEmpty())
		{
			return null;
		}
		int i = rank(key);
		if (i <= N && keys[i].compareTo(key) == 0)
		{
			return values[i];
		}
		else
		{
			return null;
		}

	}

	public void put(Key key, Value value)
	{
		int i = rank(key);
		if (i <= N && keys[i].compareTo(key) == 0)
		{
			values[i] = value;
			return;
		}
		for (int j = N; j > i; j--)
		{
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}

		keys[i] = key;
		values[i] = value;
		N++;
	}
}
