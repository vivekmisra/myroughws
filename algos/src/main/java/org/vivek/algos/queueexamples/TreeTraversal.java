package org.vivek.algos.queueexamples;

public class TreeTraversal {
	
	Node root;
	QueueAsArrayList queue;

	public TreeTraversal() {
		// TODO Auto-generated constructor stub
	}
	 public void levelorder(Node node){
	        if (node == null)
	            return;
	 
	        if (node == root)
	            queue.enqueue(node);
	         
	        if (node.leftChild != null)
	            queue.enqueue(node.leftChild);
	        if (node.rightChild != null)
	            queue.enqueue(node.rightChild);
	         
	        System.out.printf("%d ", queue.poll().key);
	         
	        levelorder(queue.peek());
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
