package com.java8.predictae;

public class Generator {
	public static void main(String[] args) {
		String str="123123";
		System.out.println(findLength(str));
	}
	
	static int findLength(String str)
	{
		int n=str.length();
		int res=0;
		for(int i=0;i<=n-2;i++)
		{
			int l=i,r=i+1;
			int lsum=0,rsum=0;
			
			while(l>=0 && r<n)
			{
				lsum=lsum+str.charAt(l)-'0';
				rsum=rsum+str.charAt(r)-'0';
				if(lsum==rsum)
				{
					res=Math.max(res,r-l+1);
					
				}
				else
				{
					l--;
					r++;
					
				}
			}
			
		}
		return res;
	}

}
