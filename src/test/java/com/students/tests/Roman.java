package com.students.tests;

public class Roman {
	
	public static int subNote(char ch1,char ch2,char[] ch,int i)
	{
		ch[i++]=ch1;
		ch[i++]=ch2;
		return i;
		
	}
	
	public static int subDigit(char c,int number,int i,char[] ch)
	{
	
		for(int k=0;k<number;k++)
		{
			ch[i++]=c;
		}
		
		return i;
	}
	
	static void convertDecimalNo(int number)
	{
		int i=0;
		char[] c=new char[10001];
		while(number!=0)
		{
			if(number>=1000)
			{
				i=subDigit('M',number/1000,i,c);
				number=number%1000;
			}
			else if(number>=500)
			{
				if(number<900)
				{
					i=subDigit('D',number/500,i,c);
					number=number%500;
				}
				else
				{
					i=subNote('C','M',c,i);
					number=number%900;
				}
			}
			else if(number >=100)
			{
				if(number<400)
				{
					i=subDigit('C',number/100,i,c);
					number=number%100;
				}
				
				else
				{
					i=subNote('C','D',c,i);
					number=number%400;
				}
			}
			else if(number >=50)
			{
				if(number<90)
				{
					i=subDigit('L',number/50,i,c);
					number=number%50;
				}
				else
				{
					i=subNote('X','C',c,i);
					number=number%90;
					
				}
			}
			else if(number>=10)
				if(number <40)
				{
					i=subDigit('X',number/10,i,c);
					number=number%10;
				}
				else
				{
					i=subNote('X','L',c,i);
					number=number%10;
				}
			
			else if(number >=5)
			{
				if(number <9)
				{
					i=subDigit('V',number/5,i,c);
					number=number%5;
				}
				else
				{
					i=subNote('I','X',c,i);
					number=0;
				}
			}
			else if(number>=1)
				if(number<4)
				{
					i=subDigit('I',number/1,i,c);
					number=0;
				}
				else
				{
					i=subNote('I','V',c,i);
					number=0;
				}
		}
		
		for(int j=0;j<i;j++)
		{
			System.out.print(c[j]);
		}
		
		
		
	}
public static void main(String[] args) {
	int decimalNo=3549;
	convertDecimalNo(decimalNo);
}


}
