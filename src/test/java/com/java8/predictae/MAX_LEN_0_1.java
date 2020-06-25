package com.java8.predictae;
import java.io.*; 
import java.util.*; 

public class MAX_LEN_0_1 {
	// Java Code for finding the length of 
	// the longest balanced substring 

	

	 
		public static void main(String args[])throws IOException 
		{ 
			String str = "101001000"; 
				
		// Create a map to store differences 
		//between counts of 1s and 0s. 
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); 
		
		// Initially difference is 0; 
				map. put(0, -1); 
				int res =0; 
				int count_0 = 0, count_1 = 0; 
				for(int i=0; i<str.length();i++) 
				{ 
					// Keep track of count of 0s and 1s 
					if(str.charAt(i)=='0') 
						count_0++; 
					else
						count_1++; 

			// If difference between current counts 
			// already exists, then substring between 
			// previous and current index has same 
			// no. of 0s and 1s. Update result if this 
			// substring is more than current result. 

					if(map.containsKey(count_1-count_0)) 
						res = Math.max(res, (i - map.get(count_1-count_0))); 
		
			// If the current difference is seen first time. 
					else
						map.put(count_1-count_0,i); 
					
				} 
				
				System.out.println("Length of longest balanced sub string = "+res); 
		} 
	 

}
