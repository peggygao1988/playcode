package org.peggygao.algs.binarySearchTree;

public class Tree2List {

    private static class Node {
	int value;
	Node left;
	Node right;

	public Node(int value, Node left, Node right) {
	    super();
	    this.value = value;
	    this.left = left;
	    this.right = right;
	}

    }

    private static Node convert(Node current, Node last) {

	if (current == null) {
	    return null;
	}

	if (current.left != null) {
	    last = convert(current.left, last);
	}

	current.left = last;
	if (last != null) {
	    last.right = current;
	}

	last = current;

	if (current.right != null) {
	    last = convert(current.right, last);
	}

	return last;

    }
    
    private static Node tree2list(Node root){
	
	Node last = convert(root, null);
	while(last!=null&&last.left!=null){
	    last = last.left;
	}
	
	return last;
	
    }
    

    public static void main(String[] args) {

	Node n1 = new Node(4,null,null);
	Node n2 = new Node(8,null,null);
	Node n3 = new Node(6,n1,n2);
	Node n4 = new Node(12,null,null);
	Node n5 = new Node(16,null,null);
	Node n6 = new Node(14,n4,n5);
	Node n7 = new Node(10,n3,n6);
	
	Node root = tree2list(n7);
	while(root!=null){
	    System.out.print(root.value+"\t");
	    root = root.right;
	}
	
    }

}
