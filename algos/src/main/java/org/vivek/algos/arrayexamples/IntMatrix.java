package org.vivek.algos.arrayexamples;


import java.util.Arrays;
import java.util.Scanner;

public class IntMatrix {
	private int[][] matrix;
	
	/**
	 * Build a BigMatrix from an integer array.
	 * @param theIntArray
	 */
	public IntMatrix(int[][] theIntArray) {
		matrix = new int[theIntArray.length][];
		for (int i=0; i<theIntArray.length; i++) {
			matrix[i] = new int[theIntArray[i].length];
			for (int j=0; j<theIntArray[i].length; j++)
				matrix[i][j] = theIntArray[i][j];
		}
	}
	
	/**
	 * Build a BigMatrix of the specified size, filled with int zeroes.
	 * @param rows
	 * @param cols
	 */
	public IntMatrix(int rows, int cols) {
		matrix = new int[rows][];
		for (int i=0; i<rows; i++) {
			matrix[i] = new int[cols];
			for (int j=0; j<cols; j++)
				matrix[i][j] = 0;
		}
	}
	
	

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	/**
	 * Builds an nxn identity matrix.
	 * @param n
	 * @return
	 */
	public static IntMatrix identity(int n) {
		IntMatrix result = new IntMatrix(n,n);
		for (int i=0; i<n; i++) result.setValue(i, i, 1);
		return result;
	}
	
	public int getValue(int i, int j) {
		return matrix[i][j];
	}
	
	public void setValue(int i, int j, int v) {
		matrix[i][j] = v;
	}
	
	public int getRows() {
		return matrix.length;
	}
	
	public int getCols() {
		return matrix[0].length;
	}
	
	public IntMatrix multiply(IntMatrix that) {
	
		IntMatrix result = new IntMatrix(this.getRows(),that.getCols());
		for (int i=0; i<result.getRows(); i++) {
			for (int j=0; j<result.getCols(); j++) {
				int ele = 0;
				for (int k=0; k<this.getCols(); k++) {
					 ele= this.getValue(i, k)* that.getValue(k,j);
				}
				result.setValue(i, j, ele);
			}
		}
		return result;
	}
	
	public IntMatrix exponentiate(int e) {
		// Raises this square matrix to e power
		// Does not check parameters.
		// Uses iterative squaring to run in O(log e)
		// matrix multiplies.
		
		IntMatrix result = identity(this.getRows());
	/*	IntMatrix square = this;
		while (e.compareTo(int.ZERO)>0) {
			if (e.mod(new int("2")).compareTo(int.ONE)==0) {
				result = result.multiply(square);
			}
			e = e.divide(new int("2"));
			square = square.multiply(square);
		}*/
		return result;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter the total number of rows  for the Matrix1");
		int rows1= in.nextInt();
		System.out.println("enter the total number of columns  for the Matrix1");
		int cols1= in.nextInt();
		IntMatrix bm1 = new IntMatrix(rows1,cols1);
		bm1.setMatrix(fill(bm1,in));
		
	
		Scanner in2 = new Scanner(System.in);
		System.out.println("enter the total number of rows  for the Matrix2");
		int rows2= in.nextInt();
		System.out.println("enter the total number of columns  for the Matrix2");
		int cols2= in.nextInt();
		IntMatrix bm2 = new IntMatrix(3,5);
		bm2.setMatrix(fill(bm2,in2));
		//in2.close();
		IntMatrix bm= bm1.multiply(bm2);
		print2DMatrix(bm);
	}
	
	
	private static void print2DMatrix(IntMatrix bm ){
		  int[][] bmArray=  bm.getMatrix();
		System.out.println(Arrays.deepToString( bmArray));
	    int totalCols = bm.getCols(); // Total columns 			
        int totalRows = bm.getRows(); // Total rows
        int[] bigIntegerrowArr = new int[totalRows-1];
        int twoDm[][]= bm.getMatrix();
        int i,j,k=1;
        for(i=0;i<totalRows;i++) {
            for(j=0;j<totalCols;j++) {
            	   System.out.println( twoDm[i][j]);

            }
        }

        for(int[]  row : twoDm) {
            printRow(row);
        }
	}
	public static void printRow(int[]  row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
	
	public static int[][] fill(IntMatrix bm,Scanner in) {
		int[][] matrix = bm.getMatrix();	
		
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.println("enter the element["+row+"]["+col+"] for the Matrix");
				int elm = in.nextInt();
				matrix[row][col] =  elm;
			}
			System.out.println();
		}

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.println(matrix[row][col]);
			}
			System.out.println();
		}
		return matrix;

	}
}
