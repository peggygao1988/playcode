package org.peggygao.algs.graph;

import java.util.Stack;

public class DepthFirstSearch {

    boolean[] marked;
    int[] edgeTo;
    int count;
    int s;

    public DepthFirstSearch(Graph g, int s) {
	this.s = s;
	marked = new boolean[g.V()];
	edgeTo = new int[g.V()];

	for (int i = 0; i < g.V(); i++) {
	    marked[i] = false;
	    edgeTo[i] = -1;
	}
    }

    public void dfs(Graph g, int s) {
	marked[s] = true;
	count++;
	for (int v : g.adj(s)) {
	    if (!marked(v)) {
		edgeTo[v] = s;
		dfs(g, v);
	    }
	}
    }

    private int getNextUnMarked(Graph g, int v) {
	for (int w : g.adj(v)) {
	    if (!marked[w]) {
		return w;
	    }
	}
	return -1;
    }

    public void dfsNotRe(Graph g, int s) {
	Stack<Integer> stack = new Stack<Integer>();
	stack.push(s);
	marked[s] = true;
	edgeTo[s] = s;
	while (!stack.isEmpty()) {
	    int current = stack.peek();
	    int next = getNextUnMarked(g, current);
	    if (next == -1) {
		stack.pop();
	    } else {
		marked[next] = true;
		edgeTo[next] = current;
		stack.push(next);
	    }

	}

    }

    public boolean marked(int w) {
	return marked[w];
    }

    public boolean hasPathTo(int w) {
	return marked[w];
    }

    public int count() {
	return count;
    }

    public Iterable<Integer> pathTo(int v) {
	if (!hasPathTo(v))
	    return null;

	Stack<Integer> stack = new Stack<Integer>();

	stack.push(v);
	while (edgeTo[v] != s) {
	    stack.push(edgeTo[v]);
	    v = edgeTo[v];
	}

	stack.push(s);
	return stack;

    }

    public void printPath(int v) {
	if (v == s) {
	    System.out.print(s + " \t");
	    return;
	}

	int w = edgeTo[v];
	printPath(w);
	System.out.print(v + "\t");

    }

    public static void main(String[] args) {
	Graph G = new Graph(6);
	G.addEdge(0, 5);
	G.addEdge(2, 4);
	G.addEdge(2, 3);
	G.addEdge(1, 2);
	G.addEdge(0, 1);
	G.addEdge(3, 4);
	G.addEdge(3, 5);
	G.addEdge(0, 2);

	System.out.println(G.toString());

	DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
	// dfs.dfsNotRe(G, 0);
	dfs.dfsNotRe(G, 0);
	for (int v = 0; v < G.V(); v++) {
	    System.out.print(0 + " to " + v + " : ");
	    if (dfs.hasPathTo(v)) {
		dfs.printPath(v);
		// Stack<Integer> stack = (Stack<Integer>) dfs.pathTo(v);
		// while (!stack.isEmpty())
		// {
		// int x = stack.pop();
		// if (x == 0)
		// {
		// System.out.print(x);
		// }
		// else
		// {
		// System.out.print("-" + x);
		// }
		// }
	    }
	    System.out.println();
	}

    }

}
