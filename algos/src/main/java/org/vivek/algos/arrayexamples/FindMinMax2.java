/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/FindMinMax.php.html
 */

package org.vivek.algos.arrayexamples;

import java.util.Arrays;

public class FindMinMax2 {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 1, 2, 6, 9, 2, 10, 11, 12 };
		System.out.println(arr.length);
		MinMax result = findMinMaxRecursive(arr, 0, arr.length - 1);
		System.out.println("maximum= " + result.max);
		System.out.println("minimum= " + result.min);
	}

	private static MinMax findMinMaxRecursive(int[] arr, int startIndex, int endIndex) {
		System.out.println(" int arr[] ="+ Arrays.toString(arr));
		System.out.println(" arr has  startIndex  =" + startIndex + " and endIndex =" + endIndex);
		int midIndex = (startIndex + endIndex) / 2;
		System.out.println("midIndex is ="+ midIndex + "..and array[" + midIndex + "]  has value =" + arr[midIndex]);
		if (startIndex > endIndex) {
			return null;
		}
		if (startIndex == endIndex) {
			System.out.println(" arr has  startIndex  :" + startIndex + " = endIndex :" + endIndex);
			MinMax m = new MinMax(arr[startIndex], arr[startIndex]);
			System.out.println(" Returning MinMax="+ m);
			return m;
		} else {
			MinMax left;
			MinMax right;
			System.out.println(" Calculating MinMax left...startIndex  =" + startIndex + " and endIndex =" + endIndex);
			left = findMinMaxRecursive(arr, startIndex, midIndex);
			System.out.println(" Calculated MinMax left  =" + left );
			System.out.println(" ..Now Calculating MinMax left...startIndex  =" + startIndex + " and endIndex =" + endIndex);
			right = findMinMaxRecursive(arr, midIndex + 1, endIndex);
			System.out.println(" Calculated MinMax right  =" + right );
			if (left == null){
				System.out.println("  MinMax left is null so returning right  =" + right );
				return right;
			}else if (right == null){
				System.out.println("  MinMax right is null so returning left" + left);
				return left;
			}else {
				System.out.println(" Math.min(left.min) where left.min ="
						+ left.min);
				System.out.println(" Math.min(right.min) where right.min ="
						+ right.min);
				System.out.println(" Math.min(left.max) where left.max ="
						+ left.max);
				System.out.println(" Math.min(right.max) where right.max ="
						+ right.max);
				MinMax m = new MinMax(Math.min(left.min, right.min), Math.max(
						left.max, right.max));
				System.out.println(" Finnaly returning MimMax= ="
						+ m);
				return m;
				
			}
		}
	}
}

class MinMax {
	public int min;
	public int max;

	public MinMax(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public String toString() {
		return "MinMax [min=" + min + ", max=" + max + "]";
	}
	
}
