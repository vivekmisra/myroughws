/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/PrintMatrixSpiral.php.html

Problem

Print a matrix in spiral fashion.
Solution

We will first print the periphery of the matrix by the help of 4 for loops. Then recursively call this function to do the same thing
 with inner concentric rectangles. We will pass this information by a variable named depth, which will tell how many layers from outside should be ignored.
*/


package org.vivek.algos.arrayexamples;
public class PrintMatrixSpiral
{
	public static void main(String[] args)
	{
		int[][] matrix =
		{
		{ 3, 4, 5, 6, 2, 5 },
		{ 2, 4, 6, 2, 5, 7 },
		{ 2, 5, 7, 8, 9, 3 },
		{ 2, 4, 7, 3, 5, 8 },
		{ 6, 4, 7, 3, 5, 7 } };

		printSpiral(matrix);
	}

	public static void printSpiral(int[][] matrix)
	{
		printSpiral(matrix, 0);
	}

	private static void printSpiral(int[][] matrix, int depth)
	{
		if (matrix == null || matrix.length == 0)
			return;
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (2 * depth > Math.min(rows, cols))
			return;
		for (int i = depth; i < cols - depth - 1; ++i)
		{
			System.out.print(matrix[depth][i] + ",");
		}
		for (int i = depth; i < rows - depth - 1; ++i)
		{
			System.out.print(matrix[i][cols - depth - 1] + ",");
		}
		for (int i = rows - depth; i > depth; --i)
		{
			System.out.print(matrix[rows - depth - 1][i] + ",");
		}
		for (int i = rows - depth - 1; i > depth; --i)
		{
			System.out.print(matrix[i][depth] + ",");
		}
		printSpiral(matrix, ++depth);
	}
}
