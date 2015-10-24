package org.peggygao.algs.collections;

public class WeightedQuickUnion {

    int[] id;
    int[] sz;
    int count;

    public WeightedQuickUnion(int N) {
	id = new int[N];
	sz = new int[N];
	count = N;

	for (int i = 0; i < N; i++) {
	    id[i] = i;
	}
	for (int i = 0; i < N; i++) {
	    sz[i] = 1;
	}
    }

    public int find(int p) {
	while (p != id[p]) {
	    p = id[p];
	}

	return p;
    }

    public int count() {
	return count;
    }

    public boolean isConnectd(int p, int q) {
	return find(p) == find(q);
    }

    public void union(int p, int q) {

	int i = find(p);
	int j = find(q);

	if (i == j) {
	    System.out.println(p + "and " + q + " has connected!!");
	    return;
	}
	System.out.println(p + "and " + q + " begin connecting");
	if (sz[i] < sz[j]) {
	    id[i] = j;
	    sz[j] += sz[i];
	} else {
	    id[j] = i;
	    sz[i] += sz[j];
	}
	count--;

    }

    public void show()

    {
	for (int i = 0; i < id.length; i++) {
	    System.out.println(String.format("%d : %d ", i, id[i]));
	}
    }

    public int getWeight(int i) {
	int id = find(i);
	return sz[id];
    }

    public static void main(String[] args) {
	WeightedQuickUnion uf = new WeightedQuickUnion(10);
	uf.show();
	uf.union(4, 3);
	uf.union(3, 8);
	uf.union(6, 5);
	uf.union(9, 4);
	uf.union(2, 1);
	uf.union(8, 9);
	uf.union(5, 0);
	uf.union(7, 2);
	uf.union(6, 1);
	uf.union(1, 0);
	uf.union(6, 7);
	uf.show();
    }
}
