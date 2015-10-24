package org.peggygao.algs.list;

public class FindKthToTail {

    private static class Node {
	int value;
	Node next;
	
	public Node(int value,Node next){
	    this.value = value;
	    this.next = next;
	}
    }

    private static Node findKth(Node list, int k) {

	if(list == null || k <=0 ){
	    return null;
	}
	
	Node first = list;
	for(int i = 0 ; i < k-1 && first!=null; i++){
	    first = first.next;
	}
	
	if(first == null){
	    return null;
	}
	
	Node second = list;
	while(first.next!=null){
	    second  = second.next;
	    first = first.next;
	}
	
	
	return second;

    }

    public static void main(String[] args) {
	
	Node n6 = new Node(6,null);
	Node n5 = new Node(5,n6);
	Node n4 = new Node(4,n5);
	Node n3 = new Node(3,n4);
	Node n2 = new Node(2,n3);
	Node n1 = new Node(1,n2);
	
	Node result = findKth(n1, 9);
	if(result!=null){
	System.out.println(result.value);
	}else{
	    System.out.println("invalid ");
	}
	

    }

}
