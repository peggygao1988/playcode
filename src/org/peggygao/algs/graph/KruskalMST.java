package org.peggygao.algs.graph;

import java.util.PriorityQueue;

import org.peggygao.algs.collections.Queue;
import org.peggygao.algs.collections.WeightedQuickUnion;

public class KruskalMST {
    
    private Queue<Edge> mst;
    
    public KruskalMST(EdgeWeightedGraph G){
	mst = new Queue<Edge>();
	
	PriorityQueue<Edge> pq = new PriorityQueue();
	for(Edge e : G.edges()){
	    pq.add(e);
	}
	
	WeightedQuickUnion uf = new WeightedQuickUnion(G.V());
	
	while(!pq.isEmpty() && mst.size() < G.V()-1){
	    
	    Edge e = pq.poll();
	    int v = e.either();
	    int w = e.other(v);
	    if(uf.isConnectd(v, w)){;
		continue;
	    }
	    
	    uf.union(v, w);
	    mst.enqueue(e);
	    
	    
	}
    }

}
