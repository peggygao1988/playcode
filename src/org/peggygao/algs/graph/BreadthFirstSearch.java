package org.peggygao.algs.graph;

import org.peggygao.algs.collections.Queue;

public class BreadthFirstSearch {

    private Graph G;
    private int s;
    private int[] edgeTo;
    private boolean[] marked;

    public BreadthFirstSearch(Graph G, int s) {
	this.G = G;
	this.s = s;
	this.edgeTo = new int[G.V()];
	this.marked = new boolean[G.V()];

    }

    public void bfs(Graph G, int s) {
	Queue<Integer> queue = new Queue<Integer>();
	queue.enqueue(s);
	marked[s] = true;

	while (!queue.isEmpty()) {
	    int v = queue.dequeue();
	    for (int w : G.adj(v)) {
		if (!marked[w]) {
		    marked[w] = true;
		    edgeTo[w] = v;
		    queue.enqueue(w);
		}
	    }
	}
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

    public boolean hasPathTo(int v) {
	return marked[v];
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

	BreadthFirstSearch bfs = new BreadthFirstSearch(G, 0);
	bfs.bfs(G, 0);
	for (int v = 0; v < G.V(); v++) {

	    System.out.print(0 + " to " + v + " : ");
	    if (bfs.hasPathTo(v)) {
		bfs.printPath(v);
	    }
	    System.out.println();
	}
    }

}
