package org.vivek.algos.linkedlistexamples;



public class LinkedListImpl {
	
	protected ListNode head;
	protected ListNode tail;

	public LinkedListImpl() {
		// TODO Auto-generated constructor stub
		head = new ListNode(null);
	}
	
	public LinkedListImpl(ListNode head) {
		// TODO Auto-generated constructor stub
		this.head = head;
		
	}
	
	
	public LinkedListImpl(ListNode head,ListNode tail) {
		// TODO Auto-generated constructor stub
		this.head = head;
		this.tail = tail;
	}
	
	
	public ListNode getHead() {
		return head;
	}

	public ListNode getTail() {
		return tail;
	}
	
	public Integer getFirstValue(){
		return head.item;
		
	}
	
	public Integer getLastValue(){
		return tail.item;
		
	}
	
	
	public void purge() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty(){
		return head.next == null;
	}
	
	
	public void prepend(Integer item) {

		// Construct a node tmp and make head as the next pointer:Step1
		ListNode tmp = new ListNode(item, head);
		
		if (null != this.head) {
			// asign new head:make tmp the new head:Step2
			this.head = tmp;
		} else {
			// but if list is empty then the temp is the only element and is new tail as wells as head[see next statement executed]	
			this.tail = tmp;// tmp is new tail
		}
		this.head = tmp;
	}
	
	
	
	
	public void append(Integer item) {
		// Construct a node tmp and make null as the next pointer:Step1
		ListNode tmp = new ListNode(item,null);		
		
		if (null != this.head) {
			// make next pointer of tail as tmp :Step2
			 tail.next = tmp;// tmp is new tail
			
		} else {
			// but if list is empty then the temp is the only element and is new tail as wells as head[see next statement executed]	
			this.head = tmp;// tmp is new tail
		}
		this.tail = tmp; // now make tmp the new tail:Step2
	}
	
	public ListNode find(Integer x) {
		ListNode lnode = getHead();// runner
		while (lnode!=null && !lnode.item.equals(x)) {
						
			lnode = lnode.next;
		}
		
		return lnode;
	}
	
	
	public ListNode findPrevious(Integer x) {
		ListNode lnode = getHead();// runner
		while (lnode!=null && !lnode.next.item.equals(x)) {
						
			lnode = lnode.next;
		}
		
		return lnode;
	}
	
	
	
	public void remove(Integer item) {
		ListNode previousNode = findPrevious( item);
		if(null != previousNode.next){
			previousNode.next =previousNode.next.next;
		}
	}
	
	
	
	public void removeFirst()  {
		head = getHead();
		head = head.next;
		
	}

	public void removeLast() {

		Integer p = tail.item;
		ListNode previousNodetail = findPrevious(p);
		tail = previousNodetail;
		tail.next = null;
		
	}
	
	
	
	LinkedListImpl reverse() {
		// Return a new list containing the same items as the list,
		// but in the reverse order.
		ListNode rev = null; // rev will be the reversed list.
		ListNode current = getHead(); // For running through the nodes of list.
		while (current != null) {
			// construct a new node
			ListNode newNode = new ListNode();
			// copy the data to new node from runner
			newNode.item =current.item;
			// "Push" the next node of list onto the front of rev.
			newNode.next = rev;
			rev = newNode;
			// Move on to the next node in the list.
			current = current.next;
		}
		return new LinkedListImpl(rev);
	} // end reverse()

	
	
	LinkedListImpl reverse1() {
		ListNode current = getHead();// runner
		head = null; 

		while (current != null) {
			ListNode newNode = current;			
			newNode.next = head;
			head = newNode;			
			current = current.next;
		}
		
		return new LinkedListImpl(head);
	} // end reverse()



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode a=new ListNode(4);
		  ListNode b=new ListNode(6);
		  ListNode c=new ListNode(1);
		  ListNode d=new ListNode(9);
		  ListNode e=new ListNode(5);
		  ListNode f=new ListNode(3);
		  ListNode g=new ListNode(7);
		  ListNode h=new ListNode(2);
		  a.next=b;
		  b.next=c;
		  c.next=d;
		  d.next=e;
		  e.next=f;
		  f.next=g;
		  g.next=h;
		  a.printLinkedList();
		  
		  LinkedListImpl lnode  = new LinkedListImpl(a,h);
		  System.out.println("Finding item=3..." );
		  ListNode foundLnode= lnode.find(3);
		  System.out.println("Found foundLnode.item=" +foundLnode.item );
		  
		  System.out.println("Finding previous node item of item=3..." );
		  ListNode foundPreviousLnode= lnode.findPrevious(3);
		  System.out.println("Found foundPreviousLnode of item=3 ...=" +foundPreviousLnode.item );
		  
		  
		  System.out.println("Prepending 8..." ); 
		  lnode.prepend(8);		
		  lnode.getHead().printLinkedList();
		  
		  System.out.println("Removing 9..." ); 
		  lnode.remove(9);		
		  lnode.getHead().printLinkedList();
		  
		  
		  System.out.println("Removing last..." ); 
		  lnode.removeLast();		
		  lnode.getHead().printLinkedList();
		  
		  System.out.println("Removing First..." ); 
		  lnode.removeFirst() ;		
		  lnode.getHead().printLinkedList();
		 
		  System.out.println("Reversing..." ); 
		  LinkedListImpl reversed= lnode.reverse();
		  reversed.getHead().printLinkedList();
		  
		  
		  System.out.println("Reversing1..." ); 
		  LinkedListImpl reversed1= lnode.reverse1();
		  reversed1.getHead().printLinkedList();
		 
		

	}

}
