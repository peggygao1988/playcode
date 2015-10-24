package org.peggygao.algs.binarySearchTree;

public class PrintPostFromPreIn {

    private static void printPost(char[] in, char[] pre, int instart,
	    int inend, int prestart, int preend) {

	if (instart == inend) {
	    System.out.print(in[instart]);
	    return;
	}

	char root = pre[prestart];

	int rootInIndex = 0;
	for (int i = instart; i <= inend; i++) {
	    if (in[i] == root) {
		rootInIndex = i;
		break;
	    }
	}

	int leftlength = rootInIndex - instart;
	int rightlength = inend - rootInIndex;

	if (leftlength > 0) {
	    printPost(in, pre, instart, rootInIndex - 1, prestart + 1, prestart
		    + leftlength);
	}

	if (rightlength > 0) {
	    printPost(in, pre, rootInIndex + 1, rootInIndex + rightlength,
		    prestart + leftlength + 1, prestart + leftlength
			    + rightlength);
	}

	System.out.print(pre[prestart]);

    }

    public static void main(String[] args) {
	char[] in = "DBGEAFHC".toCharArray();
	char[] pre = "ABDEGCFH".toCharArray();

	printPost(in, pre, 0, in.length - 1, 0, pre.length - 1);

    }

}
