package org.vivek.algos.arrayexamples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySumUsingSet {

	 public static void main(String args[]) {
	       prettyPrint(getRandomArray(9), 11);
	       prettyPrint(getRandomArray(10), 12);
	    }
	 
	 public static void printPairs(int[] array, int sum) {

	        for (int i = 0; i < array.length; i++) {
	            int first = array[i];
	            for (int j = i + 1; j < array.length; j++) {
	                int second = array[j];

	                if ((first + second) == sum) {
	                    System.out.printf("(%d, %d) %n", first, second);
	                }
	            }

	        }
	    }




	    /**
	     * Given an array of integers finds two elements in the array whose sum is equal to n.
	     * @param numbers
	     * @param n
	     */
	    public static void printPairsUsingSet(int[] numbers, int n){
	        if(numbers.length < 2){
	            return;
	        }        
	        Set set = new HashSet(numbers.length);
	        
	        for(int value : numbers){
	            int target = n - value;
	            
	            // if target number is not in set then add
	            if(!set.contains(target)){
	                set.add(value);
	            }else {
	                System.out.printf("(%d, %d) %n", value, target);
	            }
	        }
	    }
	    public static void printPairsUsingTwoPointers(int[] numbers, int k){
	        if(numbers.length < 2){
	            return;
	        }
	        Arrays.sort(numbers);
	        
	        int left = 0; int right = numbers.length -1;
	        while(left < right){
	            int sum = numbers[left] + numbers[right];
	            if(sum == k){
	                System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
	                left = left + 1;
	                right = right -1;
	                
	            }else if(sum < k){
	                left = left +1;
	                
	            }else if (sum > k) {
	                right = right -1;
	            }
	        }
	       
	    }
	    


	    
	    /*
	     * Utility method to find two elements in an array that sum to k.
	     */
	    public static void prettyPrint(int[] random, int k){
	        System.out.println("Random Integer array : " + Arrays.toString(random));
	        System.out.println("Sum : " + k);
	        System.out.println("pair of numbers from an array whose sum equals " + k);
	        printPairsUsingSet(random, k);
	    }
	    
	    /**
	     * Utility method to return random array of Integers in a range of 0 to 15
	     */
	    public static int[] getRandomArray(int length){
	        int[] randoms = new int[length];
	        for(int i=0; i<length; i++){
	            randoms[i] = (int) (Math.random()*15);
	        }
	        return randoms;
	    }

	}


	
