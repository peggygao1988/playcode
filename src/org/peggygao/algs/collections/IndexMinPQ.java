package org.peggygao.algs.collections;

import java.util.Iterator;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer>
{
	private int NMAX; // maximum number of elements on PQ
	private int N; // number of elements on PQ
	private int[] pq; // binary heap using 1-based indexing
	private int[] qp; // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
	private Key[] keys; // keys[i] = priority of i

	/**
	 * Create an empty indexed priority queue with indices between 0 and NMAX-1.
	 * 
	 * @throws java.lang.IllegalArgumentException
	 *             if NMAX < 0
	 */
	public IndexMinPQ(int NMAX)
	{
		if (NMAX < 0)
			throw new IllegalArgumentException();
		this.NMAX = NMAX;
		keys = (Key[]) new Comparable[NMAX + 1]; // make this of length NMAX??
		pq = new int[NMAX + 1];
		qp = new int[NMAX + 1]; // make this of length NMAX??
		for (int i = 0; i <= NMAX; i++)
			qp[i] = -1;
	}

	/**
	 * Is the priority queue empty?
	 */
	public boolean isEmpty()
	{
		return N == 0;
	}

	/**
	 * Is i an index on the priority queue?
	 * 
	 * @throws java.lang.IndexOutOfBoundsException
	 *             unless (0 &le; i < NMAX)
	 */
	public boolean contains(int i)
	{
		if (i < 0 || i >= NMAX)
			throw new IndexOutOfBoundsException();
		return qp[i] != -1;
	}

	/**
	 * Return the number of keys on the priority queue.
	 */
	public int size()
	{
		return N;
	}

	/**
	 * Associate key with index i.
	 * 
	 * @throws java.lang.IndexOutOfBoundsException
	 *             unless 0 &le; i < NMAX
	 * @throws java.util.IllegalArgumentException
	 *             if there already is an item associated with index i.
	 */
	public void insert(int i, Key key)
	{
		if (i < 0 || i >= NMAX)
			throw new IndexOutOfBoundsException();
		if (contains(i))
			throw new IllegalArgumentException("index is already in the priority queue");
		N++;
		qp[i] = N;
		pq[N] = i;
		keys[i] = key;
		swim(N);
	}

	/**
	 * Return the index associated with a minimal key.
	 * z
	 * @throws Exception
	 * 
	 * @throws java.util.NoSuchElementException
	 *             if priority queue is empty.
	 */
	public int minIndex() throws Exception
	{
		if (N == 0)
			throw new Exception("Priority queue underflow");
		return pq[1];
	}

	/**
	 * Return a minimal key.
	 * 
	 * @throws Exception
	 * 
	 * @throws java.util.NoSuchElementException
	 *             if priority queue is empty.
	 */
	public Key minKey() throws Exception
	{
		if (N == 0)
			throw new Exception("Priority queue underflow");
		return keys[pq[1]];
	}

	/**
	 * Delete a minimal key and return its associated index.
	 * 
	 * @throws Exception
	 * 
	 * @throws java.util.NoSuchElementException
	 *             if priority queue is empty.
	 */
	public int delMin() throws Exception
	{
		if (N == 0)
			throw new Exception("Priority queue underflow");
		int min = pq[1];
		exch(1, N--);
		sink(1);
		qp[min] = -1; // delete
		keys[pq[N + 1]] = null; // to help with garbage collection
		pq[N + 1] = -1; // not needed
		return min;
	}

	/**
	 * Return the key associated with index i.
	 * 
	 * @throws Exception
	 * 
	 * @throws java.lang.IndexOutOfBoundsException
	 *             unless 0 &le; i < NMAX
	 * @throws java.util.NoSuchElementException
	 *             no key is associated with index i
	 */
	public Key keyOf(int i) throws Exception
	{
		if (i < 0 || i >= NMAX)
			throw new IndexOutOfBoundsException();
		if (!contains(i))
			throw new Exception("index is not in the priority queue");
		else
			return keys[i];
	}

	/**
	 * Change the key associated with index i to the specified value.
	 * 
	 * @throws Exception
	 * 
	 * @throws java.lang.IndexOutOfBoundsException
	 *             unless 0 &le; i < NMAX
	 * @deprecated Replaced by changeKey()
	 */
	@Deprecated
	public void change(int i, Key key) throws Exception
	{
		changeKey(i, key);
	}

	/**
	 * Change the key associated with index i to the specified value.
	 * 
	 * @throws Exception
	 * 
	 * @throws java.lang.IndexOutOfBoundsException
	 *             unless 0 &le; i < NMAX
	 * @throws java.util.NoSuchElementException
	 *             no key is associated with index i
	 */
	public void changeKey(int i, Key key) throws Exception
	{
		if (i < 0 || i >= NMAX)
			throw new IndexOutOfBoundsException();
		if (!contains(i))
			throw new Exception("index is not in the priority queue");
		keys[i] = key;
		swim(qp[i]);
		sink(qp[i]);
	}

	/**
	 * Decrease the key associated with index i to the specified value.
	 * 
	 * @throws Exception
	 * 
	 * @throws java.lang.IndexOutOfBoundsException
	 *             unless 0 &le; i < NMAX
	 * @throws java.lang.IllegalArgumentException
	 *             if key &ge; key associated with index i
	 * @throws java.util.NoSuchElementException
	 *             no key is associated with index i
	 */
	public void decreaseKey(int i, Key key) throws Exception
	{
		if (i < 0 || i >= NMAX)
			throw new IndexOutOfBoundsException();
		if (!contains(i))
			throw new Exception("index is not in the priority queue");
		if (keys[i].compareTo(key) <= 0)
			throw new IllegalArgumentException(
			        "Calling decreaseKey() with given argument would not strictly decrease the key");
		keys[i] = key;
		swim(qp[i]);
	}

	/**
	 * Increase the key associated with index i to the specified value.
	 * 
	 * @throws Exception
	 * 
	 * @throws java.lang.IndexOutOfBoundsException
	 *             unless 0 &le; i < NMAX
	 * @throws java.lang.IllegalArgumentException
	 *             if key &le; key associated with index i
	 * @throws java.util.NoSuchElementException
	 *             no key is associated with index i
	 */
	public void increaseKey(int i, Key key) throws Exception
	{
		if (i < 0 || i >= NMAX)
			throw new IndexOutOfBoundsException();
		if (!contains(i))
			throw new Exception("index is not in the priority queue");
		if (keys[i].compareTo(key) >= 0)
			throw new IllegalArgumentException(
			        "Calling increaseKey() with given argument would not strictly increase the key");
		keys[i] = key;
		sink(qp[i]);
	}

	/**
	 * Delete the key associated with index i.
	 * 
	 * @throws Exception
	 * 
	 * @throws java.lang.IndexOutOfBoundsException
	 *             unless 0 &le; i < NMAX
	 * @throws java.util.NoSuchElementException
	 *             no key is associated with index i
	 */
	public void delete(int i) throws Exception
	{
		if (i < 0 || i >= NMAX)
			throw new IndexOutOfBoundsException();
		if (!contains(i))
			throw new Exception("index is not in the priority queue");
		int index = qp[i];
		exch(index, N--);
		swim(index);
		sink(index);
		keys[i] = null;
		qp[i] = -1;
	}

	/**************************************************************
	 * General helper functions
	 **************************************************************/
	private boolean greater(int i, int j)
	{
		return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
	}

	private void exch(int i, int j)
	{
		int swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}

	/**************************************************************
	 * Heap helper functions
	 **************************************************************/
	private void swim(int k)
	{
		while (k > 1 && greater(k / 2, k))
		{
			exch(k, k / 2);
			k = k / 2;
		}
	}

	private void sink(int k)
	{
		while (2 * k <= N)
		{
			int j = 2 * k;
			if (j < N && greater(j, j + 1))
				j++;
			if (!greater(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}

	/***********************************************************************
	 * Iterators
	 **********************************************************************/

	/**
	 * Return an iterator that iterates over all of the elements on the priority
	 * queue in ascending order.
	 * <p>
	 * The iterator doesn't implement <tt>remove()</tt> since it's optional.
	 */
	public Iterator<Integer> iterator()
	{
		return new HeapIterator();
	}

	private class HeapIterator implements Iterator<Integer>
	{
		// create a new pq
		private IndexMinPQ<Key> copy;

		// add all elements to copy of heap
		// takes linear time since already in heap order so no keys move
		public HeapIterator()
		{
			copy = new IndexMinPQ<Key>(pq.length - 1);
			for (int i = 1; i <= N; i++)
				copy.insert(pq[i], keys[pq[i]]);
		}

		public boolean hasNext()
		{
			return !copy.isEmpty();
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}

		public Integer next()
		{
			if (!hasNext())
				return null;

			try
			{
				return copy.delMin();
			}
			catch (Exception e)
			{

				e.printStackTrace();
				return null;
			}

		}
	}

	public static void main(String[] args) throws Exception
	{
		// insert a bunch of strings
		String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };

		IndexMinPQ<String> pq = new IndexMinPQ<String>(strings.length);
		for (int i = 0; i < strings.length; i++)
		{
			pq.insert(i, strings[i]);
		}

		// delete and print each key
		while (!pq.isEmpty())
		{
			int i = pq.delMin();
			System.out.println(i + " " + strings[i]);
		}
		System.out.println();

		// reinsert the same strings
		for (int i = 0; i < strings.length; i++)
		{
			pq.insert(i, strings[i]);
		}

		// print each key using the iterator
		for (int i : pq)
		{
			System.out.println(i + " " + strings[i]);
		}
		while (!pq.isEmpty())
		{
			pq.delMin();
		}

	}
}
