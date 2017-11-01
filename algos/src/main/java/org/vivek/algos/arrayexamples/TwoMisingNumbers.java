package org.vivek.algos.arrayexamples;

/*
 * Problem


 You are given an array of natural numbers from 1 to n in an array where two numbers are missing.
 So the given array size is n-2. You will have to find the two missing numbers.


 Solution


 We can use a hash map or marker array of size n to solve this problem in O(n) time. 
 But that would use O(n) extra space. We can solve this problem in O(n) time and using constant extra space.

 We will calculate the sum of n-2 numbers and sum of the n-2 numbers squared in one iteration. 
 As we know the sum of all numbers from 1 to n is n*(n+1) / 2. 
 And the sum of all numbers squared from 1 to n is n*(n+1)*(2n+1) / 6.
 So we can find the sum and squared sum of the missing number by subtracting it from total sum and squared sum of n numbers.
 So now we know a+b and a^2+b^2. 
 From this we can calculate a and b, the two missing numbers.

 */
import java.util.ArrayList;
import java.util.List;

public class TwoMisingNumbers {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 100; ++i)
			list.add(i);
		list.remove(new Integer(12));
		list.remove(new Integer(79));
		Integer[] missing = getTwoMissingNumbers(list);
		System.out.println(missing[0] + "," + missing[1]);
	}

	private static Integer[] getTwoMissingNumbers(List<Integer> list) {
		int n = list.size() + 2;
		int expectedSum = n * (n + 1) / 2;
		int expectedSquaredSum = n * (n + 1) * (2 * n + 1) / 6;
		int sum = 0;
		int squaredSum = 0;
		for (int num : list) {
			sum += num;
			squaredSum += num * num;
		}
		int xplusy = expectedSum - sum;
		int xsquareplusysquare = expectedSquaredSum - squaredSum;
		int twoxy = xplusy * xplusy - xsquareplusysquare;
		int xminusy = (int) Math.sqrt(xsquareplusysquare - twoxy);
		int x = (xplusy + xminusy) / 2;
		int y = (xplusy - xminusy) / 2;
		return new Integer[] { x, y };
	}

}