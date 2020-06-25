package com.students.tests;

import java.util.LinkedList;
import java.util.Queue;

public class JumpNUM {

	public static void main(String[] args) {
		JumpNUM obj=new JumpNUM();
		int x=25;
		obj.findJumpNumbs(x);
	}
	
	 void findJumpNumbs(int x)
	{
		System.out.println(0);
		
		for(int i=1;i<=9 && i<=x;i++)
		{
			this.find(i,x);
		}
	}
	
	 void find(int num,int x)
	{
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(num);
		while(!q.isEmpty())
		{
			int num1=q.peek();
			q.poll();
			if(num1<=x)
			{
				System.out.println(num1+" ");
				int last_digit=num1%10;
				
				if(last_digit==0)
				{
					q.add((num1*10)+(last_digit+1));
				}
				else if(last_digit==9)
				{
					q.add((num1*10)+(last_digit-1));
				}
				else
				{
					q.add((num1*10)+(last_digit-1));
					q.add((num1*10)+(last_digit+1));
				}
			}
			
		}
	}
}
