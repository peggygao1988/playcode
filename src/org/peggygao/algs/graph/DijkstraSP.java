package org.peggygao.algs.graph;

import org.peggygao.algs.collections.IndexMinPQ;
import org.peggygao.algs.collections.Stack;

public class DijkstraSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightDigraph G, int s) throws Exception {
	edgeTo = new DirectedEdge[G.V()];
	distTo = new double[G.V()];
	pq = new IndexMinPQ<Double>(G.V());

	for (int v = 0; v < G.V(); v++) {
	    distTo[v] = Double.POSITIVE_INFINITY;
	}

	distTo[s] = 0.0;

	pq.insert(s, 0.0);

	while (!pq.isEmpty()) {
	    relax(G, pq.delMin());
	}

    }

    private void relax(EdgeWeightDigraph G, int v) throws Exception {
	for (DirectedEdge e : G.adj(v)) {
	    int w = e.to();

	    if (distTo[w] > distTo[v] + e.weight()) {
		distTo[w] = distTo[v] + e.weight();
		edgeTo[w] = e;

		if (pq.contains(w)) {
		    pq.changeKey(w, distTo[w]);
		} else {
		    pq.increaseKey(w, distTo[w]);
		}
	    }
	}
    }

    public double distTo(int v) {
	return distTo[v];
    }

    public boolean hasPathTo(int v) {
	return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {

	if (!hasPathTo(v)) {
	    return null;
	}
	Stack<DirectedEdge> stack = new Stack<DirectedEdge>();

	for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
	    stack.push(e);
	}

	return stack;
    }
}
