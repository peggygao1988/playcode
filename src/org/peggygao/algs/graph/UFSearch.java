package org.peggygao.algs.graph;

import org.peggygao.algs.collections.WeightedQuickUnion;

public class UFSearch
{
	Graph G;
	int s;
	WeightedQuickUnion uf = new WeightedQuickUnion(13);
	int count = 0;

	public UFSearch(Graph G, int s)
	{
		this.G = G;
		this.s = s;

		for (int v = 0; v < G.V(); v++)
		{
			for (int w : G.adj(v))
			{
				uf.union(v, w);
				if (w == s)
					count++;
			}
		}
	}

	public boolean marked(int v)
	{
		return (uf.isConnectd(s, v));
	}

	public int count()
	{
		return uf.getWeight(s);
	}

	public static void main(String[] args)
	{
		Graph G = new Graph(13);
		G.addEdge(0, 5);
		G.addEdge(4, 3);
		G.addEdge(0, 1);
		G.addEdge(9, 12);
		G.addEdge(6, 4);
		G.addEdge(5, 4);
		G.addEdge(0, 2);
		G.addEdge(11, 12);
		G.addEdge(9, 10);
		G.addEdge(0, 6);
		G.addEdge(7, 8);
		G.addEdge(9, 11);
		G.addEdge(5, 3);
		System.out.println(G.toString());

		UFSearch search = new UFSearch(G, 1);
		for (int v = 0; v < G.V(); v++)
		{
			if (search.marked(v))
			{
				System.out.println(v + " is Connected with " + 0);
			}
		}
		System.out.println("count : " + search.count());

	}

}
