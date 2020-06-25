package com.java8.predictae;
import java.util.Arrays; 
import java.lang.Math; 
public class Max {
	// Java implementation of the above approach 
	



		// Function to find the length of the longest 
		// substring 
		public static int lenoflongestnonpalindrome(String s) 
		{ 
			// initializing the variables 
			int max1 = 1, len = 0; 
			char[] new_str = s.toCharArray(); 

			for (int i = 0; i < new_str.length - 1; i++) { 
				// checking palindrome of size 2 
				// example: aa 
				if (new_str[i] == new_str[i + 1]) 
					len = 0; 
				// checking palindrome of size 3 
				// example: aba 
				else if (i > 0 && (new_str[i + 1] == new_str[i - 1])) 
					len = 1; 
				else // incrementing length of substring 
					len++; 
				max1 = Math.max(max1, len + 1); // finding maximum 
			} 

			// if there exits single character then 
			// it is always palindrome 
			if (max1 == 1) 
				return 0; 
			else
				return max1; 
		} 

		// Driver Code 
		public static void main(String[] args) 
		{ 
			String s = "ababcd"; 
			System.out.println(lenoflongestnonpalindrome(s)); 
		} 
	

	// This code is contributed by princiraj1992 

}
