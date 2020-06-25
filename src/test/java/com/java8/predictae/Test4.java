package com.java8.predictae;

import java.util.Scanner;
import java.util.function.Function;

public class Test4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter user name");
		String username=sc.next();
		Scanner sc1=new Scanner(System.in);
		System.out.println("enter password");
		String password=sc1.next();
		Function<String,String> f1=s->s.substring(0,5);
		Function<String,String> f2=s->s.toLowerCase();
		if(f1.andThen(f2).apply(username).equals("durga")&& password.equals("java"))
		{
			System.out.println("valid user");
		}
		else
		{
			System.out.println("not a valid user");
		}
		
		Function<String,String> f=Function.identity();
		String s=f.apply("manu");
		System.out.println(s);
		
	}

}
