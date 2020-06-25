package com.student.base;
// Destination 
import java.util.*; 
import java.lang.*; 


public class GFG {
	// A Dynamic Programming based 
	// Java program to find minimum 
	// number of jumps to reach 

	
		
	// Function that returns the min 
	// number of jump to reach the 
	// destination 
	public static int minJumps(int arr[], int N) 
	{ 
		int MAX = 10; 
		
		// We consider only those Fibonacci 
		// numbers which are less than n, 
		// where we can consider fib[30] 
		// to be the upper bound as this 
		// will cross 10^5 
		int[] fib = new int[30]; 
		fib[0] = 0; 
		fib[1] = 1; 
		
		for (int i = 2; i < 12; i++) 
		fib[i] = fib[i - 1] + fib[i - 2]; 
		
		// DP[i] will be storing the minimum 
		// number of jumps required for 
		// the position i. So DP[N+1] will 
		// have the result we consider 0 
		// as source and N+1 as the destination 
		int[] DP = new int[N + 2]; 
		
		// Base case (Steps to reach source is) 
		DP[0] = 0; 

		// Initialize all table values as Infinite 
		for (int i = 1; i <= N + 1; i++) 
			DP[i] = MAX; 

		// Compute minimum jumps required 
		// considering each Fibonacci 
		// numbers one by one. 

		// Go through each positions 
		// till destination. 
		for (int i = 1; i <= N + 1; i++) 
		{ 

			// Calculate the minimum of that 
			// position if all the Fibonacci 
			// numbers are considered 
			for (int j = 1; j < 30; j++) 
			{ 

				// If the position is safe 
				// or the position is the 
				// destination then only we 
				// calculate the minimum 
				// otherwise the cost is 
				// MAX as default 
				if ((i == N + 1 || 
					arr[i - 1] == 1) && 
					i - fib[j] >= 0) 
					DP[i] = Math.min(DP[i], 1 + 
									DP[i - fib[j]]); 
			} 
		} 

		// -1 denotes if there is 
		// no path possible 
		if (DP[N + 1] != MAX) 
			return DP[N + 1]; 
		else
			return -1; 
	} 

	// Driver Code 
	public static void main (String[] args) 
	{ 
		int[] arr = new int[]{ 0, 0, 0, 1, 1, 0, 
								1, 0, 0, 0, 0 }; 
		int n = 11; 
		int ans = minJumps(arr, n); 
		System.out.println(ans); 
	} 
	

	// This code is contributed by Mehul 

}
