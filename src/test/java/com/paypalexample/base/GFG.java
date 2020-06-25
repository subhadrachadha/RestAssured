package com.paypalexample.base;

public class GFG {
	// Java implementation of the approach 
	
		
		// Function to return the minimum 
		// steps requried 
		static int MinStep(int a[], int n) 
		{ 
		
			// To store the count of 0s, positive 
			// and negative numbers 
			int positive = 0, 
				negative = 0, 
				zero = 0; 
		
			// To store the ans 
			int step = 0; 
		
			for (int i = 0; i < n; i++) 
			{ 
		
				// If array element is 
				// equal to 0 
				if (a[i] == 0) 
				{ 
					zero++; 
				} 
		
				// If array element is 
				// a negative number 
				else if (a[i] < 0) 
				{ 
					negative++; 
		
					// Extra cost needed 
					// to make it -1 
					step = step + (-1 - a[i]); 
				} 
		
				// If array element is 
				// a positive number 
				else
				{ 
					positive++; 
		
					// Extra cost needed 
					// to make it 1 
					step = step + (a[i] - 1); 
				} 
			} 
		
			// Now the array will 
			// have -1, 0 and 1 only 
			if (negative % 2 == 0) 
			{ 
		
				// As count of negative is even 
				// so we will change all 0 to 1 
				// total cost here will be 
				// count of 0s 
				step = step + zero; 
			} 
			else
			{ 
		
				// If there are zeroes present 
				// in the array 
				if (zero > 0) 
				{ 
		
					// Change one zero to -1 
					// and rest of them to 1 
					// Total cost here will 
					// be count of '0' 
					step = step + zero; 
				} 
		
				// If there are no zeros in the array 
				else
				{ 
		
					// As no 0s are availabe so we 
					// have to change one -1 to 1 
					// which will cost 2 to 
					// change -1 to 1 
					step = step + 2; 
				} 
			} 
		
			return step; 
		} 
		
		// Driver code 
		public static void main (String[] args) 
		{ 
			int a[] = { 0, -2, -1, -3, 4 }; 
			int n = a.length; 
		
			System.out.println(MinStep(a, n)); 
		} 
	 

	// This code is contributed by AnkitRai01 

}
