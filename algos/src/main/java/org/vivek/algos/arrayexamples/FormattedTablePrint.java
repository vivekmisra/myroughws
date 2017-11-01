package org.vivek.algos.arrayexamples;

public class FormattedTablePrint {

	public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
    	
        print2DMatrix(2,3);
    }

	private static void print2DMatrix(int rows,int columns) {
		int twoDm[][]= new int[rows][columns];
        int i,j,k=1;

        for(i=0;i<rows;i++) {
            for(j=0;j<columns;j++) {
                twoDm[i][j]=k;
                k++;
            }
        }

        for(int[] row : twoDm) {
            printRow(row);
        }
	}

}
