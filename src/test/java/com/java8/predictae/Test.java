package com.java8.predictae;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

class Employee
{
	String name;
	String designation;
	double salary;
	String city;
	
	Employee(String name,String designation,double salary,String city)
	{
		this.name=name;
		this.designation=designation;
		this.salary=salary;
		this.city=city;
	}
	
	public String toString()
	{
		String s=String.format("(%s,%s,%.2f,%s)",name,designation,salary,city);
		return s;
	}
}

public class Test {
	public static void main(String[] args) {
		ArrayList<Employee> list=new ArrayList<>();
		populate(list);
		
		//System.out.println(list);
		
		Predicate<Employee> p=emp->emp.designation.equals("Manager");
		display(p,list);
		
		Predicate<Employee> p2=emp->emp.city.equals("Bangalore");
		display(p2,list);
		
		Predicate<Employee> p3=emp->emp.salary<20000;
		display(p3,list);
		
		Predicate<Employee> p4=Predicate.isEqual(new Employee("Durga","CEO",30000,"Hyderabad"));
		display(p4,list);
		
		ArrayList<Employee> al=new ArrayList<Employee>();
		populate(al);
		Function<ArrayList<Employee>,Double> f=emp1->{
			double total=0;
			for(Employee e: emp1)
			{
				total=total+e.salary;
			}
			
			return total;
		};
	
	
	
	ArrayList<Employee> l1=new ArrayList<Employee>();
	populate(l1);
	System.out.println("Employee Before Increment");
	System.out.println(l1);
	
	System.out.println("Employee After Increment of salary");
	Predicate<Employee> emp2=emp3->emp3.salary<3500;
	Function<Employee,Employee> f2=emp5->{
		emp5.salary=emp5.salary+477;
		return emp5;
	};
	
	ArrayList<Employee> l3=new ArrayList<Employee>();
	Employee sa;
	for(Employee e:l1)
	{
		if(emp2.test(e))
		{
			sa=f2.apply(e);
			System.out.println(sa.salary);
			l3.add(e);
		}
	}
	System.out.println(l3);
	}
	
	static void populate(ArrayList<Employee> list)
	{
		list.add(new Employee("Durga","CEO",30000,"Hyderabad"));
		list.add(new Employee("Sunny","Manager",20000,"Banagalore"));
		list.add(new Employee("Chuchu","Lead",10000,"Hyderabad"));
		list.add(new Employee("Tinku","SSE",3000,"Hyderabad"));
		list.add(new Employee("Chintu","QA",1000,"Hyderabad"));
	}
	
	public static void display(Predicate<Employee> p,ArrayList<Employee> list)
	{
		for(Employee e:list)
		{
			if(p.test(e))
			{
				System.out.println(e);
			}
		}
		System.out.println();
		
	}

}
