package org.vivek.algos.arrayexamples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

	public NextGreaterElement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] left = new int[] { 4, 1, 2 };
		int[] right = new int[] { 1, 3, 4, 2 };
		
		/*int[] left = new int[] { 2,4};
		int[] right = new int[] { 1,2,3,4 };*/
		int[] a = nextGreaterElement(left, right);
		System.out.println(Arrays.toString(a));
	}

	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<Integer>();
        for (int num : nums) {//1,3,4,2
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }

}
