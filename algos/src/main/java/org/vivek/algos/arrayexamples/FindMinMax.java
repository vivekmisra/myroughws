/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/FindMinMax.php.html
 */

package org.vivek.algos.arrayexamples;

public class FindMinMax {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 1, 2, 6, 9, 2, 16, 11,18 };
		int[] minmaxArr =getMinMax(arr);
		System.out.println("maximum= " + minmaxArr[0]);
		System.out.println("minimum= " + minmaxArr[1]);
		
		int[] minmaxArray =findMinMax();
		System.out.println("Highest= " + minmaxArray[0]);
		System.out.println("Second Highest= " + minmaxArray[1]);
		System.out.println("Smallest= " + minmaxArray[2]);
		System.out.println("Second Smallest= " + minmaxArray[3]);
		
		 //getMax( arr) ;
	}

	private static int[] getMinMax(int[] arr) {
		int[] minmaxArr = new int[2];
		int max = arr[0];
		int min = arr[0];
		int i =0;
		for (; i < arr.length / 2; i++) {
			int num1 = arr[i * 2];
			int num2 = arr[i * 2 + 1];
			//if (arr[i * 2] >= arr[i * 2 + 1]) {
			if (num1 >= num2) {
				if (num1 > max)
					max = num1;
				if (num2 < min)
					min = num2;
			} else {
				if (num2 > max)
					max = num2;
				if (num1 < min)
					min = num1;
			}
		}
		if (i * 2 < arr.length) {
			int num = arr[i * 2];
			if (num > max)
				max = num;
			if (num < min)
				min = num;
		}
		
		minmaxArr[0] = max;
		minmaxArr[1] = min;
		
		return minmaxArr;
	}
	
	private static int getMax(int[] arr) {
		
		int max=0;
		for (int i=0; i < arr.length ; i++) {
			if(arr[i] >max){
				max= arr[i];
			}
		}
		System.out.println("maximum= " + max);
		return max;
	}
	
	
	private static  int[] findMinMax() {
		int[] minmaxArr = new int[4];
		// array of 10 numbers
		int numbers[] = new int[] { 32, 43, 53, 54, 32, 65, 63, 98, 43, 23 };
		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;

		// Loop over the array
		for (int i = 0; i < numbers.length; i++) {
			// If we've found a new highest number...
			if (numbers[i] > highest) {
				// ...shift the current highest number to second highest
				secondHighest = highest;
				// ...and set the new highest.
				highest = numbers[i];
			} else if (numbers[i] > secondHighest) {
				// Just replace the second highest
				secondHighest = numbers[i];
			} else if (numbers[i] <smallest) {
				secondSmallest= smallest;
				smallest = numbers[i];
			}else if (numbers[i] <secondSmallest) {
				secondSmallest= numbers[i];
			}
		}

		System.out.println("Largest Number is : " + highest);
		minmaxArr[0]=highest;
		System.out.println("Second Largest Number is : " + secondHighest);
		minmaxArr[1]=secondHighest;
		System.out.println("Smallest Number is : " + smallest);
		minmaxArr[2]=smallest;
		System.out.println("Second Smallest Number is : " + secondSmallest);
		minmaxArr[3]=secondSmallest;
		return minmaxArr;
	}

}
