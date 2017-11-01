package org.vivek.algos.sorting;

public class SelectionSort {

	public SelectionSort() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] data;
		data = new int[] { 2, 7, 4, 1, 5, 3 };
		sort(data);
		System.out.println();
		System.out.println("Sorted data:");
		display(data);

	}

	static void sort(int arr[]) {
		int iMinIdx = 0;

		for (int out = 0; out < arr.length - 1; out++) {
			iMinIdx = out;
			for (int in = out + 1; in < arr.length; in++) {
				System.out.println();
				System.out.println(" Is arr[in]="+ arr[in] +"<arr[iMinIdx]="+ arr[iMinIdx]);
				
				if (arr[in] < arr[iMinIdx]) {
					iMinIdx = in;
					
				}
				
				
				
			}
			swap(out, iMinIdx, arr);
		}
	}

	static void display(int[] arr) {
		int i = 0;
		int j = 0;
		for (int d : arr) {
			System.out.print(d);
			j++;
			if (j < arr.length) {
				System.out.print(",");
			}
		}
	}

	static void swap(int org, int tgt, int[] data) {
		int temp = data[org];
		data[org] = data[tgt];
		data[tgt] = temp;

	}

}
