package org.peggygao.algs.graph;

public class DirectedDFS {

    private Digraph G;
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s) {
	this.G = G;
	marked = new boolean[G.V()];
	dfs(G, s);
    }

    public void dfs(Digraph G, int s) {
	marked[s] = true;
	for (int v : G.adj(s)) {
	    if (!marked[v]) {
		dfs(G, v);
	    }
	}
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
	this.G = G;
	marked = new boolean[G.V()];

	for (int s : sources) {
	    if (!marked[s]) {
		dfs(G, s);
	    }
	}
    }

    public boolean marked(int v) {
	return marked[v];
    }

}
