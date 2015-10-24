package org.peggygao.algs.graph;

import org.peggygao.algs.collections.Stack;

public class DirectedCycle {
    private Digraph G;
    private boolean[] marked;
    private boolean[] onStack;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph G) {
	onStack = new boolean[G.V()];
	marked = new boolean[G.V()];
	edgeTo = new int[G.V()];

	for (int v = 0; v < G.V(); v++) {
	    if (!marked[v]) {
		dfs(G, v);
	    }
	}

    }

    public void dfs(Digraph G, int v) {

	marked[v] = true;
	onStack[v] = true;
	for (int w : G.adj(v)) {
	    if (!marked[w]) {
		edgeTo[w] = v;
		dfs(G, w);
	    } else {
		if (onStack[w]) {
		    cycle = new Stack<Integer>();
		    for (int x = v; x != w; x = edgeTo[x]) {
			cycle.push(x);
		    }
		    cycle.push(w);
		    cycle.push(v);
		}
	    }
	}

	onStack[v] = false;

    }

    public boolean hasCycle() {
	return cycle != null;
    }

    public Iterable<Integer> cycle() {
	return cycle;
    }

}
