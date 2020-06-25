package com.students.tests;

public class findSetBitPos {
	public static void main(String[] args) {
		int n=16;
		System.out.println(findBit(n));
	}
	
	static int findBit(int n)
	{
		if(!(PowerOfN(n)))
		{
			return -1;
		}
		
		int i=1,pos=1;
		
		while((i&n)==0)
		{
			i=i<<1;
			pos++;
		}
		
		return pos;
	}
	
	static boolean PowerOfN(int n)
	{
		return ((n>0) && (n & (n-1))==0?true :false);
	}

}
