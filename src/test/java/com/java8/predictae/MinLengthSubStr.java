package com.java8.predictae;

public class MinLengthSubStr {
public static void main(String[] args) {
	String s="efecfefd";
	int k=4;
	System.out.println(findMinLength(s,k));
}

static String findMinLength(String s,int k)
{
	int st=0;
	int end=0;
	int distEmt=0;
	int minlen=s.length();
	int n=s.length();
	int curlen=0;
	int startInd=0;
	int[] cnt=new int[26];
	for(int i=0;i<s.length();i++)
	{
		cnt[i]=0;
	}
	
	while(end<n)
	{
		cnt[s.charAt(end)-'a']++;
		if(cnt[s.charAt(end)-'a']==1)
		{
			distEmt++;
		}
		
		if(distEmt>k)
		{
			while(st<end && distEmt>k)
			{
				if(cnt[s.charAt(st)-'a']==1)
				{
					distEmt--;
				}
				cnt[s.charAt(st)-'a']--;
				st++;
			}
			
		}
		
		if(distEmt==k)
		{
			while(st<end && cnt[s.charAt(st)-'a']>1)
			{
				cnt[s.charAt(st)-'a']--;
				st++;
			}
			
			curlen=end-st+1;
			if(curlen<minlen)
			{
				minlen=curlen;
				startInd=st;
			}
			
		}
		
		end++;
		
		
	}
	return (s.substring(startInd,startInd+minlen));
}
}
