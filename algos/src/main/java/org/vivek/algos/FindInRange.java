package org.vivek.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class FindInRange {
	
	
	public FindInRange() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = new long[] {5, 1, 6, 15};
		NavigableMap<Long, Range> map = new TreeMap<Long, Range>();
		for (long l : arr) {
			if (l < 10) {
				map.put(0L, new Range(7, 2));
			}
		}// 0..3 => 0
		
		List<Long> arrList = new ArrayList<Long>();
		
		 long rangeValue = lookUp(map, 0L);
		for (Map.Entry<Long, Range> entry : map.entrySet()) {
		    Long key = entry.getKey();
		    Range range = entry.getValue();
		    long val = lookUp(map, 0L);
			if (val == 0l) {
				arrList.add(range.getValue());
			}
		  
		  
		   
		}
			
		
		for( long l : arrList){
		  System.out.println(" element="+ l);
		}
		

	}
	
    static long lookUp(NavigableMap<Long, Range> map,Long key){
    	 
    	 Long returnValue = new Long(0);
		
		// To do a lookup for some value in 'key'
				Map.Entry<Long,Range> entry = map.floorEntry(key);
				if (entry == null) {
				    // too small
				} else if (key <= entry.getValue().upper) {
					 returnValue= entry.getValue().value;
				} else {
				    // too large or in a hole
					 returnValue =1L;
				}
		return  returnValue;
	
	}
	
}


