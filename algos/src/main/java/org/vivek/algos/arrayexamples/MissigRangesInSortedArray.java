package org.vivek.algos.arrayexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissigRangesInSortedArray {
   static  int MAX_LIMIT =100;
	public MissigRangesInSortedArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int [] arr = new int[] {0, 1, 3, 50, 75};
		 System.out.println(findMissingRanges( arr));
		 
		 System.out.println(findMissingRanges( arr,0,75));

	}

	static String findMissingRanges(int[] arr) {
		System.out.println("Array "+ Arrays.toString(arr) );
		Range r = new Range();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {		
			int diff = Math.abs(i - arr[i]);
			if(r.getLower()==null){
				r.setLower(i);				
			}
			r.setHigher(arr[i]);
			System.out.println("Pricesssing"  + i);
			
			if (diff > 0) {
				if (diff == 1) {					
					r.setHigher(arr[i]);
					sb.append(String.valueOf(r.getHigher()-1)).append(",");
					  System.out.println(sb.toString());
					  resetNextExpected(r);									
				} else {					    
						r.setHigher(arr[i]);
					    sb.append(String.valueOf(r.getLower())).append("-").append(r.getHigher()-1).append(",");
					    System.out.println(sb.toString());
					    resetNextExpected(r);
				}
			}else {				
				System.out.println("Difference between " + r.getLower() + " and " + r.getHigher() + " is =" + diff);
				resetNextExpected(r);
			}
			
		}
		if (arr.length < MAX_LIMIT){
			 sb.append(String.valueOf(arr[arr.length-1]+1)).append("-").append(MAX_LIMIT);
		}
		return sb.toString();

	}

	private static void resetNextExpected(Range r) {
		r.setLower(r.getHigher()+1);
		r.clear();
	}
	
	static List<String> findMissingRanges(int[] A, int lower, int upper) {
	        List<String> result = new ArrayList<String>();
	        int pre = lower - 1;
	        for(int i = 0 ; i <= A.length  ; i++){
	        	 int after =0;
	        	if( i == A.length) {//last index
	        		after =upper + 1;
	        	}else {
	        		after = A[i];
	        	}
	          
	            if(pre + 2 == after){
	                result.add(String.valueOf(pre + 1));
	            }else if(pre + 2 < after){
	                result.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
	            }
	            pre = after;
	        }
	        System.out.println(Arrays.deepToString(result.toArray()));
	        return result;
	    }
	
	
	
}
class Range{
	Integer lower;
	Integer higher;
	public Integer getLower() {
		return lower;
	}
	public void setLower(Integer lower) {
		this.lower = lower;
	}
	public Integer getHigher() {
		return higher;
	}
	public void setHigher(Integer higher) {
		this.higher = higher;
	}
	void clear(){
		
		this.higher = null;
	}
	
}