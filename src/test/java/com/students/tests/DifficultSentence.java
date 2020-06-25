package com.students.tests;

public class DifficultSentence {
	
	public static void main(String[] args) {
		String str="We are gkkkk";
		System.out.print(calDiff(str,str.length()));
	}

	
	static int calDiff(String str,int n)
	{
		int count_cons=0;
		int count_vowels=0;
		int consec_cons=0;
		int hard_word=0;
		int easy_word=0;
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)!=' ' && isVowel(Character.toLowerCase(str.charAt(i))))
			{
				count_vowels++;
				consec_cons=0;
			}
			else if(str.charAt(i)!=' ')
			{
				count_cons++;
				consec_cons++;
			}
			else if(consec_cons==4)
			{
				hard_word++;
				while(i<str.length() && str.charAt(i)!=' ')
				{
					i++;
				}
				count_cons=0;
				count_vowels=0;
				consec_cons=0;
			}
			else if(i<str.length() && str.charAt(i)==' ')
			{
				if(count_cons>count_vowels)
				{
					hard_word++;
				}
				else
				{
					easy_word++;
				}
				
				count_cons=0;
				count_vowels=0;
				consec_cons=0;
			}
		}
		return 5*hard_word+3*easy_word;
	}
	
	static boolean isVowel(char ch)
	{
		return (ch=='a'|| ch=='e'|| ch=='i'|| ch=='o'|| ch=='u');
		
	}
}
