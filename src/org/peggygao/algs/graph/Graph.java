package org.peggygao.algs.graph;

import org.peggygao.algs.collections.Bag;

public class Graph {

    private int V;
    private int E;

    private Bag<Integer>[] adj;

    public Graph(int v) {
	this.V = v;
	E = 0;
	adj = (Bag<Integer>[]) new Bag[v];
	for (int i = 0; i < v; i++) {
	    adj[i] = new Bag<Integer>();
	}
    }

    public int V() {
	return V;
    }

    public int E() {
	return E;
    }

    public void addEdge(int v, int w) {
	adj[v].add(w);
	adj[w].add(v);
	E++;
    }

    public Iterable<Integer> adj(int v) {
	return adj[v];
    }

    public String toString() {
	String s = V + " vertices,  " + E + " edges\n";
	for (int i = 0; i < V; i++) {
	    s += i + " : ";
	    for (int w : this.adj(i)) {
		s += w + "  ";
	    }
	    s += "\n";
	}
	return s;
    }

}
