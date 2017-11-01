package org.vivek.algos.queueexamples;

import java.util.NoSuchElementException;

import org.vivek.algos.linkedlistexamples.LinkedListImpl;
import org.vivek.algos.linkedlistexamples.ListNode;
import org.vivek.algos.queueexamples.Node;

public class QueueAsLinkedList {
	
	private LinkedListImpl list;
	int count;
	Node root;

	public QueueAsLinkedList() {
		// TODO Auto-generated constructor stub
		list = new LinkedListImpl();
	}
	
	
	public void purge(){
		list.purge();
	}
	
	public boolean isEmpty(){
		if(null ==list.getHead()){
			return true;
		}else{
			return false;
		}
	}
	
	
	  /**
     * Returns the item least recently added to this queue.
     * @return the item least recently added to this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
	 public ListNode peek() {
	        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
	        return list.getHead();
	    }
	
	public Integer dequeue(){		
		Integer top = list.getFirstValue();
		list.remove(top);
		--count;
		return top;	
		
	}
	
	
	public void enqueue(ListNode listNode) {
		Integer itemValue = listNode.getItem();
		list.append( itemValue);
		++count;

	}
	
	
	public Integer getFirstItem(){
		Integer top = list.getFirstValue();
		return top;
	}
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
