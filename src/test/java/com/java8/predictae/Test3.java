package com.java8.predictae;

import java.util.function.Function;

public class Test3 {
public static void main(String[] args) {
	Function<String,String> f1=s->s.toUpperCase();
	Function<String,String> f2=s->s.substring(0,5);
	System.out.println(f1.apply("abcdefgh"));
	System.out.println(f2.apply("abcdefgh"));
	System.out.println(f1.andThen(f2).apply("abcdefgh"));
	System.out.println(f1.compose(f2).apply("abcdefgh"));
}
}
