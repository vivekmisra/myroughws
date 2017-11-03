package org.vivek.algos.stringexamples;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RemoveRepeatedChars {

	public RemoveRepeatedChars() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "baab";

		s = stripContinuosChars(s);
		System.out.println("Final s=" + s);
	}

	private static String stripContinuosChars(String s) {
		s = s + " "; // Adding a space at the end of the word
		int l = s.length(); // Finding the length of the word
		String ans = ""; // Variable to store the final result
		char ch1, ch2;
		int[] counts = new int[256]; // maximum value of an ASCII character
		System.out.println("s=" + s);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < l - 1; i++) {
		
			ch1 = s.charAt(i); // Extracting the first character
			ch2 = s.charAt(i + 1); // Extracting the next character
			// Adding the first extracted character to the result if the current and the
			// next characters are different
			System.out.println("ch1=" + ch1);
			System.out.println("ch2=" + ch2);
			System.out.println("counts[" + ch1 + "]=" + counts[ch1]);
			System.out.println("org ans=" + s);
			System.out.println("updated ans=" + sb.toString());
			if ((ch1 != ch2)) {
				counts[ch1]++;
				String current = sb.toString();
				int ind = current.indexOf(ch1);
				if (counts[ch1] > 1 && ind >=0) {
					System.out.println("current ans=" + current);
					current = current.replaceAll(String.valueOf(ch1), current);
					sb.append(current);
					System.out.println("updated ans=" + sb.toString());
				} else {
					sb.append(ch1);
					System.out.println("updated ans=" + sb.toString());
				}
				System.out.println("counts[" + ch1 + "]=" + counts[ch1]);
			} else {
				counts[ch1] = counts[ch1] + 2;
				System.out.println("counts[" + ch1 + "]=" + counts[ch1]);
				i = i + 1;
			}
		}
		return sb.toString();
	}

	private static String stripContinuosChars2(String s) {
		String pattern = "(\\w){2}";
		s = s.replaceFirst(pattern, "aa");
		System.out.println("after Nows =" + s);

		return s;
	}

}
