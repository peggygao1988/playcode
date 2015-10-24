package org.peggygao.algs.graph;

import org.peggygao.algs.collections.Bag;
import org.peggygao.algs.collections.IndexMinPQ;

public class PrimMST {

    private boolean[] marked;
    private Edge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) throws Exception {
	marked = new boolean[G.V()];
	edgeTo = new Edge[G.V()];
	distTo = new double[G.V()];

	for (int v = 0; v < G.V(); v++) {
	    distTo[v] = Double.POSITIVE_INFINITY;
	}

	pq = new IndexMinPQ<Double>(G.V());

	distTo[0] = 0.0;
	pq.insert(0, 0.0);
	while (!pq.isEmpty()) {
	    visit(G, pq.delMin());
	}
    }

    private void visit(EdgeWeightedGraph G, int v) throws Exception {

	marked[v] = true;
	for (Edge e : G.adj(v)) {
	    int w = e.other(v);
	    if (marked[w]) {
		continue;
	    }

	    if (e.weight() < distTo[w]) {
		distTo[w] = e.weight();
		edgeTo[w] = e;

		if (pq.contains(w)) {
		    pq.change(w, distTo[w]);
		} else {
		    pq.insert(w, distTo[w]);
		}
	    }

	}
    }

    public Iterable<Edge> edges() {
	Bag<Edge> mst = new Bag<Edge>();

	for (Edge e : edgeTo) {
	    mst.add(e);
	}

	return mst;
    }

}
