package org.peggygao.algs.list;

public class SwapEvenOdd {

  
    private static class Node{
	char value;
	Node next;
	public Node(char value,Node next){
	    this.value = value;
	    this.next = next;
	}
    }
    
    
    private static Node swap(Node head){
	if(head == null || head.next == null){
	    return head;
	}
	
	
	Node p1 = head;
	Node p2 = head.next;
	Node next = p2.next;
	
	p2.next = p1;
	p1.next = swap(next);
	return p2;
	
	
    }
    
    private static Node swapNotRe(Node head){
	
	if(head == null || head.next == null){
	    return head;
	}
	
	Node p1 = head;
	Node p2 = p1.next;
	Node next = p2.next;
	p2.next = p1;
	p1.next = null;
	Node pre = p1;
	
	Node newHead = p2;
	while(next!=null && next.next!=null){
	    p1 = next;
	    p2 = next.next;
	    next = p2.next;
	    
	    p2.next = p1;
	    p1.next = null;
	    pre.next = p2;
	    
	    pre = p1;
	    
	}
	pre.next = next;
	
	return newHead;
		
    }
    public static void main(String[] args) {
	
	Node g = new Node('g', null);
	Node f = new Node('f',g);
	Node e = new Node('e',f);
	Node d = new Node('d', e);
	Node c = new Node('c', d);
	Node b = new Node('b',c);
	Node a = new Node('a', b);
	
//	Node head = swap(a);
	Node head = swapNotRe(a);
	while(head!=null){
	    System.out.print(head.value+"\t");
	    head  = head.next;
	}

    }

}
