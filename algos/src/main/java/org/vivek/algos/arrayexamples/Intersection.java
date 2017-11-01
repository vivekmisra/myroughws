package org.vivek.algos.arrayexamples;

public class Intersection {

	public Intersection() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int arr1[] = {1, 2, 4, 5, 6};
		  int arr2[] = {2, 3, 5, 7};
		  int m = arr1.length;
		  int n = arr2.length;
		 int [] intersectedArray= printIntersection(arr1, arr2, m,  n);
		 for(int i : intersectedArray){
			 System.out.print("Here="+i);
		}

	}
	 
	/* Function prints Intersection of arr1[] and arr2[]
	   m is the number of elements in arr1[]
	   n is the number of elements in arr2[] */
	static int[] printIntersection(int arr1[], int arr2[], int m, int n){
	  int i = 0, j = 0;
	 int total = m+n;
	  int [] intersectedArray= new int[total];
		while (i < m && j < n) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr2[j] < arr1[i]) {
				j++;
			} else {/* if arr1[i] == arr2[j] */

				System.out.print(arr2[j++]);
				intersectedArray[i] = arr2[j++];
				i++;
			}
		}
		return intersectedArray;
	}

}
