package com.pages;

import java.util.function.*;

import java.util.Date;

@FunctionalInterface
interface cab {
	public void c(int a);
}

@FunctionalInterface
interface abc {
	public int c1(int a);
}

interface sum {
	public int add(int a, int b);
}


public class ANB {

	public static void main(String args[]) {
		
		cab bb1 = (int a)->  System.out.println(a *a);
		bb1.c(5);
		
		cab bb = a->  System.out.println(a *a);
		bb.c(9);
		
		abc n = (a)->  a *a;
		System.out.println(n.c1(3));
		
		abc c = n1 -> { return n1*n1;};
		System.out.println(c.c1(8));

		sum s = (a,b)-> a+b;
		System.out.println(s.add(2, 3));
		sum s2 = (a,b)-> {System.out.print("a+b is ");
							return (a+b);};
		System.out.println(s2.add(2,0));
		
		//Predcate pre defined interface
		
		Predicate <Integer> p = r-> r>10;
		System.out.println(p.test(100));	
		
		Predicate <String> p1 = l -> l.length() >10;
		System.out.println(p1.test("hello"));
		
		String names[] = {"fvf","rvfveve","ergghjghghjghjghjrefwf","hkhkjlkjkljkl"};
		
		for(String f:names){
			if(p1.test(f)) {
				System.out.println("string is longer than 10");
			}
			
		} 
		
		//Function pre defined interface
		
		Function <Integer,Integer> p2 = l -> l*l;
		System.out.println("Function is  " + p2.apply(4));
		
		Function <String,Integer> p3 = l -> l.length();
		System.out.println("Function is  " + p3.apply("hello"));
		
		//Function chaining -- andThen(), compose()
		Function <Integer,Integer> p4 = l -> l*2;
		Function <Integer,Integer> p5 = l -> l*l*l;
		
		System.out.println("Function andthen is  " + p4.andThen(p5).apply(2));
		
		System.out.println("Function compose is  " + p4.compose(p5).apply(2));

		
		//Consumer pre defined interface
		Consumer <String> p6 = a-> System.out.println(a);
		p6.accept("bye");
		
		//Supplier pre defined interface
		Supplier <Date> s1 = ()-> new Date();
		System.out.println("s1 is " + s1.get());
	}
			
}