package com.java8.predictae;

import java.util.function.Function;

public class Test1 {
public static void main(String[] args) {
	String s="durga software solution hyderbad";
	Function<String,String> f=s1->s1.replaceAll(" ","");
	System.out.println(f.apply(s));
}
}
