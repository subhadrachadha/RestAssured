package com.students.tests;

import java.util.ArrayList;
import java.util.HashMap;

class Pair1
{
	int first;
	int second;
	Pair1(int a,int b)
	{
		first=a;
		second=b;
		
	}
	

}

public class findZeroSum {
	public static void main(String[] args) {
		int arr[]= {6,3,-1,-3,4,-2,2,4,6,-12,-7};
		int n=arr.length;
		
		ArrayList<Pair1> out=findSubArrays(arr,n);
		for(int i=0;i<out.size();i++)
		{
			Pair1 p=out.get(i);
			System.out.println(p.first+","+p.second);
		}
		
	}

	private static ArrayList<Pair1> findSubArrays(int[] arr, int n) {
		int sum=0;
		HashMap<Integer,ArrayList<Integer>>  map=new HashMap<Integer,ArrayList<Integer>>();
		
		ArrayList<Pair1> out=new ArrayList<Pair1>();
	
		
		for(int i=0;i<arr.length;i++)
		{
			ArrayList<Integer> al=new ArrayList<Integer>();
			sum=sum+arr[i];
			
			if(sum==0)
				out.add(new Pair1(0,i));
			
			if(map.containsKey(sum))
			{
				al=map.get(sum);
				for(int it=0;it<al.size();it++)
				{
					out.add(new Pair1(al.get(it)+1,i));
				}
				
			}
			else
			{
			al.add(i);
			map.put(sum,al);
			}
			
		}
		
		return out;
	}

}
