package org.peggygao.algs.graph;

public class Edge implements Comparable<Edge>
{
	private int v;
	private int w;
	private double weight;

	public Edge(int v, int w, double weight)
	{
		super();
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public double weight()
	{
		return weight;
	}

	public int either()
	{
		return v;
	}

	public int other(int vertex)
	{
		if (vertex == v)
			return w;
		else if (vertex == w)
			return v;
		else
			return Integer.MIN_VALUE;
	}

	@Override
	public int compareTo(Edge that)
	{
		if (this.weight() < that.weight())
			return -1;
		else if (this.weight() > that.weight())
			return 1;
		else
			return 0;
	}

	public String toString()
	{
		return String.format("%d-%d %.2f", v, w, weight);
	}

}
