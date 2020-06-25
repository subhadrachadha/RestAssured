package com.students.loggingexamples;

public class PatternWithoutLoop {
public static void main(String[] args) {
	int n=16;
	boolean flag=true;
	printPattern(n,n,flag);
}

static void printPattern(int n,int m ,boolean flag )
{
	System.out.println(m+" ");
	
	if(flag==false && n==m)
	{
		return;
	}
	
	
	if(m-5>0 && flag==true)
	{
		printPattern(n,m-5,true);
	}
	else
	{
		printPattern(n,m+5,false);
	}
	
}

}
