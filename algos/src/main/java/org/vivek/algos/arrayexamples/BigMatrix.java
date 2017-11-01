package org.vivek.algos.arrayexamples;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class BigMatrix {
	private BigInteger[][] matrix;
	
	/**
	 * Build a BigMatrix from an integer array.
	 * @param theIntArray
	 */
	public BigMatrix(int[][] theIntArray) {
		matrix = new BigInteger[theIntArray.length][];
		for (int i=0; i<theIntArray.length; i++) {
			matrix[i] = new BigInteger[theIntArray[i].length];
			for (int j=0; j<theIntArray[i].length; j++)
				matrix[i][j] = new BigInteger(""+theIntArray[i][j]);
		}
	}
	
	/**
	 * Build a BigMatrix of the specified size, filled with BigInteger zeroes.
	 * @param rows
	 * @param cols
	 */
	public BigMatrix(int rows, int cols) {
		matrix = new BigInteger[rows][];
		for (int i=0; i<rows; i++) {
			matrix[i] = new BigInteger[cols];
			for (int j=0; j<cols; j++)
				matrix[i][j] = BigInteger.ZERO;
		}
	}
	
	

	public BigInteger[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(BigInteger[][] matrix) {
		this.matrix = matrix;
	}

	/**
	 * Builds an nxn identity matrix.
	 * @param n
	 * @return
	 */
	public static BigMatrix identity(int n) {
		BigMatrix result = new BigMatrix(n,n);
		for (int i=0; i<n; i++) result.setValue(i, i, BigInteger.ONE);
		return result;
	}
	
	public BigInteger getValue(int i, int j) {
		return matrix[i][j];
	}
	
	public void setValue(int i, int j, BigInteger v) {
		matrix[i][j] = v;
	}
	
	public int getRows() {
		return matrix.length;
	}
	
	public int getCols() {
		return matrix[0].length;
	}
	
	public BigMatrix multiply(BigMatrix that) {
	
		BigMatrix result = new BigMatrix(this.getRows(),that.getCols());
		for (int i=0; i<result.getRows(); i++) {
			for (int j=0; j<result.getCols(); j++) {
				BigInteger sum = BigInteger.ZERO;
				for (int k=0; k<this.getCols(); k++) {
					sum = sum.add(this.getValue(i,k).multiply(that.getValue(k,j)));
				}
				result.setValue(i, j, sum);
			}
		}
		return result;
	}
	
	public BigMatrix exponentiate(BigInteger e) {
		// Raises this square matrix to e power
		// Does not check parameters.
		// Uses iterative squaring to run in O(log e)
		// matrix multiplies.
		
		BigMatrix result = identity(this.getRows());
		BigMatrix square = this;
		while (e.compareTo(BigInteger.ZERO)>0) {
			if (e.mod(new BigInteger("2")).compareTo(BigInteger.ONE)==0) {
				result = result.multiply(square);
			}
			e = e.divide(new BigInteger("2"));
			square = square.multiply(square);
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter the total number of rows  for the Matrix1");
		int rows1= in.nextInt();
		System.out.println("enter the total number of columns  for the Matrix1");
		int cols1= in.nextInt();
		BigMatrix bm1 = new BigMatrix(rows1,cols1);
		bm1.setMatrix(fill(bm1,in));
		
	
		Scanner in2 = new Scanner(System.in);
		System.out.println("enter the total number of rows  for the Matrix2");
		int rows2= in.nextInt();
		System.out.println("enter the total number of columns  for the Matrix2");
		int cols2= in.nextInt();
		BigMatrix bm2 = new BigMatrix(3,5);
		bm2.setMatrix(fill(bm2,in2));
		//in2.close();
		BigMatrix bm= bm1.multiply(bm2);
		print2DMatrix(bm);
	}
	
	
	private static void print2DMatrix(BigMatrix bm ){
		  BigInteger[][] bmArray=  bm.getMatrix();
		System.out.println(Arrays.deepToString( bmArray));
	    int totalCols = bm.getCols(); // Total columns 			
        int totalRows = bm.getRows(); // Total rows
        BigInteger[] bigIntegerrowArr = new BigInteger[totalRows-1];
        BigInteger twoDm[][]= bm.getMatrix();
        int i,j,k=1;
        for(i=0;i<totalRows;i++) {
            for(j=0;j<totalCols;j++) {
            	   System.out.println( twoDm[i][j]);

            }
        }

        for(BigInteger[]  row : twoDm) {
            printRow(row);
        }
	}
	public static void printRow(BigInteger[]  row) {
        for (BigInteger i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
	
	public static BigInteger[][] fill(BigMatrix bm,Scanner in) {
		BigInteger[][] matrix = bm.getMatrix();	
		
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.println("enter the element["+row+"]["+col+"] for the Matrix");
				BigInteger elm = in.nextBigInteger();
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
