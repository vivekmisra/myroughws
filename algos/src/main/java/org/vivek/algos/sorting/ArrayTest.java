package org.vivek.algos.sorting;


public class ArrayTest {
	
	
	 private int[] arr;               // ref to array a
	   private int nElems;               // number of data items

	public ArrayTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayTest(int ele) {
		// TODO Auto-generated constructor stub
		arr = new int[ele];
		nElems =0;
	}
	
	void insert(int ele){
		arr[nElems] = ele;
		nElems++;
	}
	
	void displayElems(){
		int i =0;
		int j=0;
		for( int d : arr){
			System.out.print(d);
			j++;
			if(j < arr.length){
				System.out.print(",");
			}
		}
	}
	
	
	void swap(int org,int tgt){
		int temp = arr[org];
		arr[org] = arr[tgt];
		arr[tgt] = temp;
				
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int maxSize = 10;            // array size
	      ArrayTest arr;                 // reference to array
	      arr = new ArrayTest(maxSize);  // create the array

	      arr.insert(77);               // insert 10 items
	      arr.insert(99);
	      arr.insert(44);
	      arr.insert(55);
	      arr.insert(22);
	      arr.insert(88);
	      arr.insert(11);
	      arr.insert(00);
	      arr.insert(66);
	      arr.insert(33);

	      arr.displayElems();                // display items
	}

}
