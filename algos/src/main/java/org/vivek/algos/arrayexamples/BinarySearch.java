package org.vivek.algos.arrayexamples;

public class BinarySearch {

	public BinarySearch() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 4,5,7,9,10,33};
		int found = binarySearch( arr,0, arr.length-1, 33);
		 System.out.println("found ="+ found);    	
	}
	
	public static int binarySearch(int[] arr, int start, int end, int value) {

	    int mid = (start + end) / 2;
	    System.out.println(" Mid index is ="+ mid);    	
	    if (start > end) {
	        return -1;
	    } else if (arr[mid] == value) {
	        return arr[mid];
	    } else if (arr[mid] < value) {
	    	System.out.println(" array["+ mid +"]  has value ="+ arr[mid]+ " and is less than "+ value);
	        return binarySearch(arr,  mid + 1,end, value);
	    } else {
	    	System.out.println(" array["+ mid +"]  has value ="+ arr[mid]+ " and is more than "+ value);
	        return binarySearch(arr, start, mid - 1, value);
	    }
	 }

}
