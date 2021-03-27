package com.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;


class TestEmployee {

	int salary;
	String name;
	int exp;

	public TestEmployee(int salary1, String name1, int exp1) {

		this.salary = salary1;
		this.name = name1;
		this.exp = exp1;
	}
	
	public String getname() {
		return name;
	}
	
	public int getsalary() {
		return salary;
	}

}

public class Streams {

	public static void main(String args[]) {

		List<Integer> al1 = new ArrayList<Integer>(Arrays.asList(1,56,3,5,4));
		List<Integer> al2 = new ArrayList<Integer>();
		
		//Streams using filter method
		
		al2 = al1.stream().filter(n->n%2==0).collect(Collectors.toList()); //Predicate
		System.out.println("list is " + al2);
		
		//OR
		
		al1.stream().filter(n->n%2==0).forEach(n->System.out.println("n is " + n));  //consumer
		al1.stream().filter(n->n%2==0).forEach(System.out::println);  //consumer
		
		List<String> al3 = new ArrayList<String>(Arrays.asList("mike","hello","tuesday","qwerty","monday"));
		List<String> al4 = new ArrayList<String>();
		al2.clear();
		al4 = al3.stream().filter(n->n.length()>5 && n.length()<8).collect(Collectors.toList()); //Predicate
		System.out.println("list is " + al4);
		al3.stream().filter(n->n.length()>5 && n.length()<8).forEach(System.out::println);  //consumer
		
		List<TestEmployee> al5 = new ArrayList<TestEmployee>();
		al5.add(new TestEmployee(100000, "John", 1));
		al5.add(new TestEmployee(232000, "Mike", 5));
		al5.add(new TestEmployee(807897, "kapil", 3));
		al5.add(new TestEmployee(980928, "vijay", 10));
		
		al5.stream().filter(p->p.salary>50000).forEach(p->System.out.println("name is " + p.name));
		
		
		//Map collection
		List<String> al6 = new ArrayList<String>(Arrays.asList("mike","qwerty","monday"));
		List<String> al7 = new ArrayList<String>();
		al7 = al6.stream().map(n->n.toUpperCase()).collect(Collectors.toList());
		System.out.println(al7);
		
		al6.stream().map(n->n.length()).forEach(n->System.out.println(n));
		
		Set<Integer> al8 = new HashSet<Integer>(Arrays.asList(32,342,523,6,432,2));
		al8.stream().map(n->n*2).forEach(n->System.out.println("nnnnnnnnnnn is" + n));
		
		al8.stream().filter(n->n>400).map(n->n.intValue()).forEach(n->System.out.println("n is " + n));
		
		
		//flatmap
		List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(32,10));
		List<Integer> l2 = new ArrayList<Integer>(Arrays.asList(78,55));
		List<Integer> l3 = new ArrayList<Integer>(Arrays.asList(65,90));
		List<List<Integer>> l4 =Arrays.asList(l1,l2,l3);
		
		List<Integer> l5 = l4.stream().flatMap(x-> x.stream()).map(n->n+10).collect(Collectors.toList());
		System.out.println("list is " + l5);
		
		List<TestEmployee> ll1 = new ArrayList<TestEmployee>();
		ll1.add(new TestEmployee(1000, "John", 1));
		ll1.add(new TestEmployee(6500, "mike", 10));
		
		List<TestEmployee> ll2 = new ArrayList<TestEmployee>();
		ll2.add(new TestEmployee(6722, "loo", 2));
		ll2.add(new TestEmployee(2134, "yui", 65));
		
		List<List<TestEmployee>> ll3 =Arrays.asList(ll1,ll2);
		
		ll3.stream().flatMap(x->x.stream()).map(o->o.name).collect(Collectors.toList()).forEach(n->System.out.println("n222 is " + n));
		
		
		//Methods available
		
		//Distinct remove duplicates
		List<String> all1 = new ArrayList<String>(Arrays.asList("mike","hello","tuesday","hello","monday"));
		all1.stream().distinct().collect(Collectors.toList()).forEach(n->System.out.println("n333 is " + n));
		
		//Count 
		long c = all1.stream().count();
		System.out.println("long c is  " + c);
		
		//limit remove duplicates
				List<String> am  = all1.stream().limit(4).collect(Collectors.toList());
				System.out.println("list c is  " + am);
				
		//min
				Optional aa =all1.stream().min((val1,val2)-> {return val1.compareTo(val2);});
				System.out.println(aa.get());
				
		//max
		
				Optional aaa =all1.stream().max((val1,val2)-> {return val1.compareTo(val2);});
				System.out.println(aaa.get());
		//reduce		
				Optional aaaa =all1.stream().reduce((val1,val2)-> {return val1+val2;});
				System.out.println(aaaa.get());
		//toarray		
				Object aaaaa[] =all1.stream().toArray();
				System.out.println(aaaaa.length);
		//SORTED
				//ascending order by default
				List<String> bb =all1.stream().sorted().collect(Collectors.toList());
				System.out.println("list is " +bb);				
				//ascending order by default
				List<String> bb1 =all1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
				System.out.println("revrselist is " +bb1);
		//anymatch
				boolean bbb = all1.stream().anyMatch(x->x.length()>5);//takes predicate
				System.out.println("bbb is " +bbb);
				
				//allmatch
				boolean bbbb = all1.stream().allMatch(x->x.length()>5);//takes predicate
				System.out.println("bbbb is " +bbbb);
				
				//nonematch
				boolean bbbbb = all1.stream().noneMatch(x->x.length()>5);//takes predicate
				System.out.println("bbbbb is " +bbbbb);
				
				//allmatch
				Optional bbbbbb = all1.stream().findAny();//takes predicate
				System.out.println("bbbbbb is " +bbbbbb.get());
				
				//allmatch
				Optional bbbbbbb = all1.stream().findFirst();//takes predicate
				System.out.println("bbbbbbb is " +bbbbbbb.get());
				
				
				//parallel streams
				
				//doing with sequential tehcnique
				al5.stream().filter(x->x.salary>100000).limit(2).forEach(n->System.out.println("name is " + n.getname() + " sal is " + n.getsalary()));
				
				
				//doing with parallel stream tehcnique
				al5.parallelStream().filter(x->x.salary>100000).limit(2).forEach(n->System.out.println("nameee is " + n.getname() + " salll is " + n.getsalary()));
				
				//convert stream to parallel stream
				al5.stream().parallel().filter(x->x.salary>100000).limit(2).forEach(n->System.out.println("nae is " + n.getname() + " sl is " + n.getsalary()));
				
				
				
				
	}
}