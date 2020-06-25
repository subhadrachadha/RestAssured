package com.java8.predictae;

import java.util.ArrayList;
import java.util.function.Consumer;

class Move
{
	String name;
	String hero;
	String heroin;
	public Move(String name,String hero,String heroin)
	{
		this.name=name;
		this.hero=hero;
		this.heroin=heroin;
	}
}

public class Moview {
	public static void main(String[] args) {
	 ArrayList<Move> m=new ArrayList<>();
	 populate(m);
	 Consumer<Move> c=move->{
		 System.out.print(move.hero+",");
		 System.out.print(move.heroin+",");
		 System.out.print(move.name);
	 };
	 
	 for(Move m1:m)
	 {
		 c.accept(m1);
		 System.out.println(" ");
	 }
	 
	 
	 
	}
	
	static void populate(ArrayList<Move> l1)
	{
		l1.add(new Move("chitu","manu","subu"));
		l1.add(new Move("bahubali","prabhas","subu"));
	}
	

}
