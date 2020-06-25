package com.restassured.examples.jsonassert;

public class LengthOfNonREp {
	public static void main(String[] args) {
		String str="ABDEFGABEF";
		System.out.println(maxLength(str));
		
	}
	
	
	static int maxLength(String str)
	{
		int NO_OF_CHARS=256;
		int cur_len=1;
		int max_len=1;
		int prev_index;
		int[] visited=new int[NO_OF_CHARS];
		for(int i=0;i<NO_OF_CHARS;i++)
		{
			visited[i]=-1;
		}
		visited[str.charAt(0)]=0;
		
		for(int i=1;i<str.length();i++)
		{
			prev_index=visited[str.charAt(i)];
			
			if(prev_index==-1)
			{
				cur_len++;
			}
			else
			{
				if(cur_len>max_len)
				{
					max_len=cur_len;
				}
				cur_len=i-prev_index;
				
			}
			visited[str.charAt(i)]=i;
		}
		
		if(max_len>cur_len)
		{
			cur_len=max_len;
		}
		
		return max_len;
	}

}
