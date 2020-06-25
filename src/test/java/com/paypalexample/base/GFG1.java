package com.paypalexample.base;

public class GFG1 {
	// Java implementation of the approach 

		// Function to print the array after removing 
		// k consecutive elements such that the sum 
		// of the remaining elements is maximized 
		static void maxSumArr(int arr[], int n, int k) 
		{ 
			int cur = 0, index = 0; 

			// Find the sum of first k elements 
			for (int i = 0; i < k; i++) 
				cur += arr[i]; 

			// To store the minimum sum of k 
			// consecutive elements of the array 
			int min = cur; 
			for (int i = 0; i < n - k; i++) { 

				// Calculating sum of next k elements 
				cur = cur - arr[i] + arr[i + k]; 

				// Update the minimum sum so far and the 
				// index of the first element 
				if (cur < min) { 
					cur = min; 
					index = i + 1; 
				} 
			} 

			// Printing result 
			for (int i = 0; i < index; i++) 
				System.out.print(arr[i] + " "); 
			for (int i = index + k; i < n; i++) 
				System.out.print(arr[i] + " "); 
		} 

		// Driver code 
		public static void main(String[] args) 
		{ 
			int arr[] = { -1, 1, 2, -3, 2, 2 }; 
			int n = arr.length; 
			int k = 3; 

			maxSumArr(arr, n, k); 
		} 
	

}
