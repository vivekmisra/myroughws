package org.vivek.algos.stackexamples;

import org.vivek.algos.linkedlistexamples.LinkedListImpl;


public class StackAsLinkedList {
	
	private LinkedListImpl list;
	int count;

	public StackAsLinkedList() {
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
	
	
	
	public Integer dequue(){		
		Integer top = list.getFirstValue();
		list.remove(top);
		--count;
		return top;	
		
	}
	
	
	public void enqueue(Integer item) {
		list.append(item);
		++count;

	}
	
	
	public Integer getHead(){
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
