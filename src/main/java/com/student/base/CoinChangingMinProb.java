package com.student.base;

public class CoinChangingMinProb {
	
	public static void main(String[] args) {
		int total=11;
		int coins[]= {1,5,6,8};
		CoinChangingMinProb obj=new CoinChangingMinProb();
		System.out.println(obj.getMinimumCoinToFormTotal(coins, total));
	}

	
	
	public int getMinimumCoinToFormTotal(int coins[],int total)
	{
		int T[]=new int[total+1];
		int R[]=new int[total+1];
		for(int i=1;i<=total;i++)
		{
			T[i]=Integer.MAX_VALUE-1;
			R[i]=-1;
		}
		
		for(int i=0;i<=coins.length-1;i++)
		{
			for(int j=1;j<=total;j++)
			{
				if(j>=coins[i])
				{
					if(T[j-coins[i]]+1<T[j])
					{
						T[j]=1+T[j-coins[i]];
						R[j]=i;
					}
				}
			}
		}
		printCoinsCombination(R,coins);
		return T[total];
	}
	
	static void printCoinsCombination(int R[],int coins[])
	{
		int start=R.length-1;
		while(start!=0)
		{
			int i=R[start];
			System.out.println(coins[i]+" ");
			start=start-coins[i];
		}
	}
}
