/*
f,bFor problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/search-in-sorted-matrix.html

Problem

Given a matrix whose rows and columns are sorted, search for an element in that matrix.

Solution

We start from the right top element of the array. If the search element is greater than the element we move 
below, if it is less we move to the left. And we continue the above process In this way either we will find the
element or will reach to a position  where no left or bottom is possible. In an N*M matrix the search complexity is O(N+M).
In N*N matrix the complexity is O(2*N) = O(N)

 */

package org.vivek.algos.arrayexamples;

public class SearchInSortedMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 5, 7, 8, 9 }, { 6, 9, 11, 13 }, { 7, 11, 12, 14 },
				{ 8, 13, 16, 17 } };
		boolean result = contains(matrix, 14);
		System.out.println(result);

	}

	private static boolean contains(int[][] matrix, int k) {
		int row = matrix.length;
		int col = matrix[0].length;
		int currentRow = 0;
		int currentCol = col - 1;
		while (currentRow != row && currentCol != -1) {
			if (matrix[currentRow][currentCol] == k)
				return true;
			else if (matrix[currentRow][currentCol] > k)
				currentCol--;
			else
				currentRow++;
		}
		return false;
	}
}
