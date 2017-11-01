package org.vivek.algos.linkedlistexamples;

public final class ListNode {

	Integer item;
	ListNode next;

	// Constructors
	public ListNode() {
	}
	
	public ListNode(Integer item) {
		this(item,null);
	}

	public ListNode(Integer item, ListNode next) {
		this.item = item;
		this.next = next;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public void printLinkedList() {
		ListNode head = this;
		while (head != null) {
			System.out.print(head.item + "->");
			head = head.next;
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
