package org.peggygao.algs.graph;

import org.peggygao.algs.collections.Bag;

public class EdgeWeightDigraph {

    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightDigraph(int V) {
	this.V = V;
	this.E = 0;
	adj = (Bag<DirectedEdge>[]) new Bag[V];

	for (int i = 0; i < V; i++) {
	    adj[i] = new Bag<DirectedEdge>();
	}
    }

    public int V() {
	return V;
    }

    public int E() {
	return E;
    }

    public void addEdge(DirectedEdge e) {
	adj[e.from()].add(e);
	E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
	return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
	Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
	for (int v = 0; v < V; v++) {

	    for (DirectedEdge e : adj[v]) {
		bag.add(e);
	    }
	}

	return bag;
    }
}
