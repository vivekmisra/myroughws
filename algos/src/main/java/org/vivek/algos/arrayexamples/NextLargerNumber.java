/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/NextLargerNumber.php.html
Problem

Given a number whose digits are unique, find the next larger number that can be formed with those digits.
Solution

If all the digits are in increasing order from right to left, then no larger number is possible as that is
 the largest number possible with those digits. If they are not in increasing order form right to left then a larger number 
 is possible. We need to find the first decreasing sequence from right side. Then we can bring the larger number in place of the smaller number. 
After that if we arrange the remaining digits in increasing order, next bigger number will be formed.
 */

package org.vivek.algos.arrayexamples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextLargerNumber {

	/**
	 * given a number whose digits are unique find the next bigger number formed
	 * by those digits
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		/*System.out.println("insert one number whose digits are unique");
		String input = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			System.out.println("Not a valid number");
			return;
		}*/
		String input = "7124";
		if (input.length() == 1) {
			System.out.println("no greater number possible");
			return;
		}
		List<Integer> digits = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); ++i) {
			Integer digit = Integer.parseInt(input.substring(i, i + 1));
			if (digits.contains(digit)) {
				System.out.println("All digits are not unique");
				return;
			} else {
				digits.add(digit);
			}
		}

		int rightBiggerIndex = -1;
		int leftSmallerIndex = -1;
		System.out.println(" digits.size() ="+  digits.size() );
		for (int rightDigit = digits.size() - 1; rightDigit > 0	&& rightBiggerIndex == -1; --rightDigit) {
			System.out.println("rightDigit="+ rightDigit);
			for (int leftDigit = rightDigit - 1; leftDigit >= 0; --leftDigit) {
				System.out.println("leftDigit="+ leftDigit);
				if (digits.get(rightDigit) > digits.get(leftDigit)) {
					rightBiggerIndex = rightDigit;
					leftSmallerIndex = leftDigit;
					break;
				}
			}
		}
		if (rightBiggerIndex == -1 || leftSmallerIndex == -1) {
			System.out.println("no greater number possible");
			return;
		}
		System.out.println("rightBiggerIndex="+ rightBiggerIndex);
		System.out.println("leftSmallerIndex="+ leftSmallerIndex);
		swap(digits, rightBiggerIndex, leftSmallerIndex);
		System.out.println("After swapping="+Arrays.toString(digits.toArray()));
		sort(digits, leftSmallerIndex + 1, digits.size() - 1);
		System.out.println("After sort="+Arrays.toString(digits.toArray()));
		for (int num : digits) {
			System.out.print(num);
		}

	}

	private static void sort(List<Integer> digits, int startIndex, int endIndex) {
		if (startIndex == endIndex)
			return;
		for (int k = startIndex; k < endIndex; ++k)
			for (int l = startIndex + 1; l <= endIndex; ++l) {
				if (digits.get(k) > digits.get(l))
					swap(digits, k, l);
			}

	}

	private static void swap(List<Integer> digits, int i, int j) {
		Integer temp = digits.get(i);
		digits.set(i, digits.get(j));
		digits.set(j, temp);
	}
}
