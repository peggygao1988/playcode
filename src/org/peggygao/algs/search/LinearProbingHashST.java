package org.peggygao.algs.search;

public class LinearProbingHashST<Key, Value>
{

	private int M;
	private int N;
	private Key[] keys;
	private Value[] values;

	public LinearProbingHashST(int size)
	{

		keys = (Key[]) new Object[size];
		values = (Value[]) new Object[size];
		M = size;
	}

	public int hash(Key key)
	{
		return (key.hashCode() & 0X7fffffff) % M;
	}

	public void resize(int cap)
	{

		LinearProbingHashST t = new LinearProbingHashST<>(cap);
		for (int i = 0; i < M; i++)
		{
			if (keys[i] != null)
			{
				t.put(keys[i], values[i]);
			}
			keys = (Key[]) t.keys;
			values = (Value[]) t.values;
			M = t.M;
		}
	}

	public Value get(Key key)
	{
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
		{

			if (keys[i].equals(key))
			{
				return values[i];
			}
		}
		return null;
	}

	public void put(Key key, Value value)
	{
		if (N > M / 2)
		{
			resize(M * 2);
		}
		int i = hash(key);
		for (; keys[i] != null; i = (i + 1) % M)
		{
			if (keys[i].equals(key))
			{
				values[i] = value;
				return;
			}
		}

		keys[i] = key;
		values[i] = value;
		N++;
	}

	public boolean contains(Key key)
	{
		return get(key) == null;
	}

	public void delete(Key key)
	{
		if (!contains(key))
			return;

		int i = hash(key);
		while (!keys[i].equals(key))
		{
			i = (i + 1) % M;
		}
		keys[i] = null;
		values[i] = null;

		i = (i + 1) % M;
		while (keys[i] != null)
		{
			Key oldKey = keys[i];
			Value oldValue = values[i];
			keys[i] = null;
			values[i] = null;
			N--;
			put(oldKey, oldValue);

			i = (i + 1) % M;
		}

		N--;

		if (N > 0 && N == M / 2)
		{
			resize(M / 2);
		}
	}
}
