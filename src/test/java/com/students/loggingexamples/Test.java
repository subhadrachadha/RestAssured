package com.students.loggingexamples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class Test {
	public static void main(String[] args) {
		Predicate<Integer> p=I->I>10;
		System.out.println(p.test(100));
		System.out.println(p.test(10));
		//System.out.println(p.test("durga"));
		
		Predicate<Collection> p1=c->c.isEmpty();
		ArrayList<String> A=new ArrayList<>();
		A.add("A");
		System.out.println(p1.test(A));
		
		String[] names= {"Kareena","Manoj","Miral"};
		Predicate<String> startswithk=s->s.charAt(0)=='K';
		for(String name:names)
		{
			if(startswithk.test(name))
			{
				System.out.println(name);
			}
		}
		
	}

}
