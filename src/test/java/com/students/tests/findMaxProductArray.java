package com.students.tests;

public class findMaxProductArray {

	public static void main(String[] args) {
		int arr[]= {1,-2,-3,0,7,-8,-2};
		int n=arr.length;
		System.out.println(findMaxSubArray(arr,n));
	}
	
	static int min(int x,int y)
	{
		return (x<y)?x:y;
	}
	
	static int max(int x,int y)
	{
		return (x>y)?x:y;
	}
	
	static int findMaxSubArray(int arr[],int n)
	{
		int max_ending_here=1;
		int min_ending_here=1;
		int max_so_far=1;
		int flag=0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>0)
			{
				max_ending_here=max_ending_here*arr[i];
				min_ending_here=min(max_ending_here*arr[i],1);
				flag=1;
			}
			
			else if(arr[i]==0)
			{
				max_ending_here=1;
				min_ending_here=1;
			}
			
			else 
			{
				int temp=max_ending_here;
				max_ending_here=max(min_ending_here*arr[i],1);
				min_ending_here=temp*arr[i];
				
			}
			
			if (max_so_far<max_ending_here)
			{
				max_so_far=max_ending_here;
			}
		}
		
		if(max_so_far==1 && flag==0)
		{
			return 0;
		}
		return max_so_far;
		
	}
	
	
}
