package org.vivek.algos.queueexamples;

public class Node {

		Integer key;
		

		Node leftChild;
		Node rightChild;
		Node sibling;

		Node(Integer key) {

			this.key = key;
			

		}
		
		public String toString() {

			return " Node has the key " + this.key.intValue();

			/*
			 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
			 * "\nRight Child: " + rightChild + "\n";
			 */

		}

}
