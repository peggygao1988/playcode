package org.peggygao.algs.graph;

import java.util.PriorityQueue;

import org.peggygao.algs.collections.Queue;

public class LazyPrimeMST {

    private boolean[] marked;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;

    public LazyPrimeMST(EdgeWeightedGraph G) {
	mst = new Queue<Edge>();
	marked = new boolean[G.V()];
	pq = new PriorityQueue<Edge>();

	visit(G, 0);
	while (!pq.isEmpty()) {
	    Edge e = pq.poll();
	    int v = e.either();
	    int w = e.other(v);
	    if (marked[v] && marked[w]) {
		continue;
	    }

	    mst.enqueue(e);
	    if (!marked[v]) {
		visit(G, v);
	    }
	    if (!marked[w]) {
		visit(G, w);
	    }
	}

    }

    private void visit(EdgeWeightedGraph G, int v) {

	marked[v] = true;

	for (Edge e : G.adj(v)) {
	    if (!marked[e.other(v)]) {
		pq.add(e);
	    }
	}

    }
}
