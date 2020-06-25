package DP;

public class Spiral {
	public static void main(String[] args) {
		int R=3;
		int C=6;
		int a[][]= {{1,2,3,4,5,6},
				    {7,8,9,10,11,12},
				    {13,14,15,16,17,18}};
				
		spiral(R,C,a);
	
	}
	
	public static void spiral(int R,int C ,int a[][])
	{
		int k=0,l=0,m=R,n=C;
		
		while(k<m && l<n)
		{
			for(int i=l;i<n;i++)
			{
				System.out.println(a[k][i]+" ");
			}
			k++;
			
			for(int i=k;i<m;i++)
			{
				System.out.println(a[i][n-1]+" ");
			}
			n--;
			
			if(k<m)
			{
				for(int i=n-1;i>=l;--i)
				{
					System.out.println(a[m-1][i]+" ");
				}
				m--;
			}
			
			if(l<n)
			{
				for(int i=m-1;i>=k;--i)
				{
					System.out.println(a[i][l]+" ");
				}
			}
			l++;
		}
		
	}

}
