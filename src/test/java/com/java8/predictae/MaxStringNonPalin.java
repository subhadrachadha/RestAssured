package com.java8.predictae;

public class MaxStringNonPalin {
public static void main(String[] args) {
	String s="ababcd";
	System.out.println(findMaxlen(s));
}

static int findMaxlen(String s)
{
	char arr[]=s.toCharArray();
	int len=0,max1=0,res=0;
	for(int i=0;i<arr.length-1;i++)
	{
		if(arr[i]==arr[i+1])
		{
			len++;
		}
		
		else if(i>0 && arr[i+1]==arr[i-1])
		{
			len=1;
		}
		else
		{
			len++;
		}
		max1=Math.max(max1,len+1);
	}
	
	if(max1==1)
	{
		return 0;
	}
	else
	{
		return max1;
	}
	
	
	
}
}
