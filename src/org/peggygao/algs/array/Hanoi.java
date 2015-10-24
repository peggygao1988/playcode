package org.peggygao.algs.array;

import java.util.Stack;

public class Hanoi {

    static class Tower {
	Stack<Integer> stack;
	int index;

	public Tower(int i) {
	    stack = new Stack<Integer>();
	    index = i;
	}

	public int index() {
	    return index;
	}

	public void add(int n) {
	    if (!stack.isEmpty() && stack.peek() <= n) {
		System.out.println("Error placing disk " + n);
	    } else {
		stack.add(n);
	    }
	}

	public void moveTopTo(Tower t) {
	    int d = stack.pop();
	    t.add(d);
	    System.out.println(String.format("move disk %d from %d to %d", d,
		    index(), t.index()));
	}

	public void moveDisk(int n, Tower dest, Tower buffer) {
	    if (n > 0) {
		moveDisk(n - 1, buffer, dest);
		moveTopTo(dest);
		buffer.moveDisk(n - 1, dest, this);
	    }
	}
    }

    private static void hanoi(int n, char src, char bridge, char dst) {
	if (n == 1) {
	    System.out.println(String.format("move %d disks from %s to %s", n,
		    src, dst));
	} else {

	    hanoi(n - 1, src, dst, bridge);
	    System.out.println(String.format("move %d disks from %s to %s", 1,
		    src, dst));
	    hanoi(n - 1, bridge, src, dst);
	}

    }

    public static void main(String[] args) {
	int n = 4;
	// Tower[] towers = new Tower[3];
	// for (int i = 0; i < 3; i++) {
	// towers[i] = new Tower(i);
	// }
	// for (int i = n - 1; i >= 0; i--) {
	// towers[0].add(i);
	// }
	//
	// towers[0].moveDisk(n, towers[2], towers[1]);

	hanoi(n, 'A', 'B', 'C');

    }

}
