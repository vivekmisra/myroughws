package org.vivek.algos.arrayexamples;

import java.util.Arrays;

public class SearchIn2DMatrix {

	public SearchIn2DMatrix() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };

		System.out.println("Original Matrix :");
		printMatrix(matrix);
		System.out.println();
		int totalCols = matrix[0].length; // Total columns of
															// Original Matrix
		int totalRows = matrix.length; // Total rows of Original
														// Matrix
		
		System.out.println("totalRows ="+totalRows  );//5
		System.out.println(" totalCols ="+ totalCols );//4

		int[] rowArr = new int[totalCols];

		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j <totalCols; j++) {
				rowArr[j] = matrix[i][j];
				System.out.println("matrix[i][j] =="+matrix[i][j] );
			}
			System.out.println("Row#"+i+"="+Arrays.toString(rowArr));
			
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
	}

	
}
