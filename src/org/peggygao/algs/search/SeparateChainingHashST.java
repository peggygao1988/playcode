package org.peggygao.algs.search;

public class SeparateChainingHashST<Key, Value>
{

	private int M;
	private int N;
	private SequentialSearchST<Key, Value>[] st;

	public SeparateChainingHashST(int size)
	{
		M = size;
		st = new SequentialSearchST[size];
		for (int i = 0; i < M; i++)
		{
			st[i] = new SequentialSearchST();
		}
	}

	private int hash(Key key)
	{
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public Value get(Key key)
	{
		return st[hash(key)].get(key);
	}

	public void put(Key key, Value value)
	{
		st[hash(key)].put(key, value);
	}
	
	public void delete(Key key)
	{
		st[hash(key)].delete(key);
	}

}
