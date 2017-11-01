package org.vivek.algos.trees;

import java.util.Collections;
import java.util.List;



/**
 * Represents a node in the Binary Search Tree.
 */
class Node {
	// The value present in the node.
	public int value;

	// The reference to the left subtree.
	public Node left;

	// The reference to the right subtree.
	public Node right;

	public Node(int value) {
		this.value = value;
	}

}

/**
 * Represents the Binary Search Tree.
 */
public class BinarySearchTreeDemo {

	// Refrence for the root of the tree.
	public Node root;

	public BinarySearchTreeDemo insert(int value) {
		Node node = new Node(value);

		if (root == null) {
			root = node;
			return this;
		}

		insertRec(root, node);
		return this;
	}

	private static int leftNodeCount = 0;
	private static int rightNodeCount = 0;

	private void insertRec(Node latestRoot, Node node) {

		if (latestRoot.value > node.value) {

			if (latestRoot.left == null) {
				latestRoot.left = node;
				return;
			} else {
				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				return;
			} else {
				insertRec(latestRoot.right, node);
			}
		}
	}

	/**
	 * Returns the minimum value in the Binary Search Tree.
	 */
	public int findMinimum() {
		if (root == null) {
			return 0;
		}
		Node currNode = root;
		while (currNode.left != null) {
			currNode = currNode.left;
		}
		return currNode.value;
	}

	/**
	 * Returns the maximum value in the Binary Search Tree
	 */
	public int findMaximum() {
		if (root == null) {
			return 0;
		}

		Node currNode = root;
		while (currNode.right != null) {
			currNode = currNode.right;
		}
		return currNode.value;
	}

	/**
	 * Printing the contents of the tree in an inorder way.
	 */
	public void printInorder() {
		printInOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in an inorder way
	 */
	private void printInOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		printInOrderRec(currRoot.left);
		System.out.print(currRoot.value + ", ");
		printInOrderRec(currRoot.right);
	}

	/**
	 * Printing the contents of the tree in a Preorder way.
	 */
	public void printPreorder() {
		printPreOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Preorder way
	 */
	private void printPreOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		System.out.print(currRoot.value + ", ");
		printPreOrderRec(currRoot.left);
		printPreOrderRec(currRoot.right);
	}

	/**
	 * Printing the contents of the tree in a Postorder way.
	 */
	public void printPostorder() {
		printPostOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Postorder way
	 */
	private void printPostOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		printPostOrderRec(currRoot.left);
		printPostOrderRec(currRoot.right);
		System.out.print(currRoot.value + ", ");

	}

	static int count(Node node) {
		Node right = node.right;
		Node left = node.left;
		int c = 1; // count yourself!
		if (right != null)
			c += count(right); // count sub trees
		if (left != null)
			c += count(left); // ..
		return c;
	}

	static int countChildren(Node node) {
		if (node == null)
			return 0;
		return 1 + countChildren(node.left) + countChildren(node.right);
	}
	static int sumOfLeafDepths( Node node, int depth ) {
        // When called as sumOfLeafDepths(root,0), this will compute the
        // sum of the depths of all the leaves in the tree to which root
        // points.  When called recursively, the depth parameter gives
        // the depth of the node, and the routine returns the sum of the
        // depths of the leaves in the subtree to which node points.
        // In each recursive call to this routine, depth goes up by one.
     if ( node == null ) {
           // Since the tree is empty and there are no leaves,
           // the sum is zero.
        return 0;
     }
     else if ( node.left == null && node.right == null) {
           // The node is a leaf, and there are no subtrees of node, so
           // the sum of the leaf depth is just the depths of this node.
        return depth;
     }
     else {
           // The node is not a leaf.  Return the sum of the
           // the depths of the leaves in the subtrees.
        return sumOfLeafDepths(node.left, depth + 1) 
                    + sumOfLeafDepths(node.right, depth + 1);
     }
 } // end sumOfLeafDepth()

	
	 static int maximumLeafDepth( Node node, int depth ) {
         // When called as maximumLeafDepth(root,0), this will compute the
         // max of the depths of all the leaves in the tree to which root
         // points.  When called recursively, the depth parameter gives
         // the depth of the node, and the routine returns the max of the
         // depths of the leaves in the subtree to which node points.
         // In each recursive call to this routine, depth goes up by one.
      if ( node == null ) {
           // The tree is empty.  Return 0.
         return 0;
      }
      else if ( node.left == null && node.right == null) {
            // The node is a leaf, so the maximum depth in this
            // subtree is the depth of this node (the only leaf 
            // that it contains).
         return depth;
      }
      else {
            // Get the maximum depths for the two subtrees of this
            // node.  Return the larger of the two values, which
            // represents the maximum in the tree overall.
         int leftMax = maximumLeafDepth(node.left, depth + 1);
         int rightMax =  maximumLeafDepth(node.right, depth + 1);
         if (leftMax > rightMax)
            return leftMax;
         else
            return rightMax;
      }
  } // end sumOfLeafDepth()

	// Recursive Solution
	/* To get the count of leaf nodes in a binary tree */
	public static int getLeafCountOfBinaryTree(Node node) {

		if (node == null) {
			return 0;
		}
		System.out.println("calling getLeafCountOfBinaryTree node.value="
				+ node.value);
		if (node.left == null && node.right == null) {
			System.out.println("End leaf node.value=" + node.value);
			return 1;
		} else {
			if (null != node.left) {
				System.out
						.println("calling getLeafCountOfBinaryTree node.left.value="
								+ node.left.value);
				leftNodeCount = getLeafCountOfBinaryTree(node.left);
			}
			if (null != node.right) {
				System.out
						.println("calling getLeafCountOfBinaryTree node.right.value="
								+ node.right.value);
				rightNodeCount = getLeafCountOfBinaryTree(node.right);
			}
			System.out
					.println("calling getLeafCountOfBinaryTree returning totalcount="
							+ (leftNodeCount + rightNodeCount));
			return leftNodeCount + rightNodeCount;

		}
	}
	
	
	public static int makeSum(Node root) {
		if (root == null)
			return 0;
		int temp = root.value;
		int sum = makeSum(root.left) + makeSum(root.right);
		if (root.left != null || root.right != null)
			root.value = sum;
		return temp + sum;
	}

	public static void printNice(Node root) {
		if (root == null)
			return;
		else {
			System.out.print(root.value);
			if (root.left != null) {
				System.out.print("L->[");
				printNice(root.left);
				System.out.print("]");
			}
			if (root.right != null) {
				System.out.print("R->[");
				printNice(root.right);
				System.out.print("]");
			}
		}
	}

	public static void main(String[] args) {
		BinarySearchTreeDemo bst = new BinarySearchTreeDemo();
		bst.insert(40).insert(25).insert(48).insert(10).insert(3).insert(17)
				.insert(32).insert(30).insert(38).insert(78).insert(50)
				.insert(93);
		System.out.println("Inorder traversal");
		bst.printInorder();

		System.out.println("Preorder Traversal");
		bst.printPreorder();

		System.out.println("Postorder Traversal");
		bst.printPostorder();

		System.out
				.println("The minimum value in the BST: " + bst.findMinimum());
		System.out
				.println("The maximum value in the BST: " + bst.findMaximum());

		Node root = bst.root;
		int numberOfNodes = count(root);
		System.out.println("No of nodes=" + numberOfNodes);
		int numberOfChildNodes = countChildren(root);
		System.out.println("numberOfChildNodes=" + numberOfChildNodes);
		System.out.println("Root value=" + root.value);
		System.out.println("isBST=" + isBST(root));
		 int leafCount = countChildren(root);
         int depthSum = sumOfLeafDepths(root,0);
         System.out.println("depthSum =" + depthSum );
         int depthMax = maximumLeafDepth(root,0);
         System.out.println("depthMax =" + depthMax );
         double averageDepth = ((double)depthSum) / leafCount;
         System.out.println("averageDepth=" + averageDepth);
         int sumoFNodes = makeSum( root);
         printNice(root);
         System.out.println("sumoFNodes =" + sumoFNodes );

	}

	public static boolean isBST(Node root) {
		return checkBooleanAndReturn(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	private static boolean checkBooleanAndReturn(Node root, int max, int min) {
		if (root == null)
			return true;
		boolean leftOk = true;
		boolean rightOk = true;
		boolean centerOk = true;
		if (root.left != null)
			leftOk = checkBooleanAndReturn(root.left, root.value, min);
		if (root.value >= min && root.value <= max)
			centerOk = true;
		else
			centerOk = false;
		if (root.right != null)
			rightOk = checkBooleanAndReturn(root.right, max, root.value);
		return leftOk && centerOk && rightOk;
	}

}