package com.java8.predictae;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Student
{
	String name;
	int marks;
	Student(String name,int marks)
	{
		this.name=name;
		this.marks=marks;
		
	}
}
public class Test2 {
	
	public static void main(String[] args) {
		ArrayList<Student> l=new ArrayList<Student>();
		populate(l);
		Function<Student,String> f=s1->{int marks=s1.marks;
		                                 if(marks>=85)
		                                 {
		                                	 return "A[Distinction]";
		                                 }
		                                 else if(marks>=60)
		                                 {
		                                	 return "B[FirstClass]";
		                                 }
		                                 else if(marks>=50)
		                                 {
		                                	 return "C[SecondClass]";
		                                 }
		                                 else if(marks>=35)
		                                 {
		                                	 return "E[ThirdGrade]";
		                                 }
		                                 else
		                                 {
		                                	 return "Faile";
		                                 }
		
		};
	 for(Student s:l)
	 {
		 System.out.println(s.name);
		 System.out.println(f.apply(s));
	 }
	 
	 Predicate<Student> p=s->s.marks>=60;
	 
	 for(Student s:l)
	 {
		 if(p.test(s))
		 {
			 System.out.println(s.name);
		 }
	 }
	 
	 ArrayList<Student> l1=new ArrayList<Student>();
		populate(l1);
		Predicate<Student> p4=s->s.marks>60;
		Function<Student,String> f8=s->{
			int mark=s.marks;
			if(mark>=80)
			{
				return "A";
			}
			else if(mark>=60)
			{
				return "B";
			}
			else if(mark>=50)
			{
				return "C";
			}
			else if(mark>=35)
			{
				return "E";
			}else
			{
				return "fail";
			}
		    };
					
		    Consumer<Student> c=stu->{
				System.out.println("name"+stu.name);
				System.out.println("marks"+stu.marks);
				System.out.println(f.apply(stu));
			};  
			
			for(Student s:l1)
			{
				if(p.test(s))
				{
					c.accept(s);
				}
			}
			
			Supplier<Date> so=()->new Date();
			System.out.println(so.get());
	}
	
	public static void populate(ArrayList<Student> l)
	{
		l.add(new Student("Sunny",100));
		l.add(new Student("Bunny",65));
		l.add(new Student("Chinny",55));
		l.add(new Student("Vinny",45));
		l.add(new Student("Pinny",25));
		
	}

}
