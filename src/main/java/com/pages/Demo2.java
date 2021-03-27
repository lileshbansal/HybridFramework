package com.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee {

	int salary;
	String name;
	int exp;

	public Employee(int salary1, String name1, int exp1) {

		this.salary = salary1;
		this.name = name1;
		this.exp = exp1;
	}

}

public class Demo2 {

	public static void main(String args[]) {
		
		List<Integer> ar = new ArrayList<Integer>(Arrays.asList(1,543,653,25,1,75,543));
		System.out.println(ar.stream().distinct().collect(Collectors.toList()));
		
		Employee e1 = new Employee(100000, "ABC", 5);
		Predicate<Employee> p1 = emp -> (emp.salary > 5000 && emp.exp > 3);
		System.out.println("first test is " + p1.test(e1));

		List<Employee> al = new ArrayList<Employee>();
		al.add(new Employee(100000, "John", 1));
		al.add(new Employee(232000, "Mike", 5));
		al.add(new Employee(807897, "kapil", 3));
		al.add(new Employee(980928, "vijay", 10));

		for (Employee k : al) {
			System.out.println("second test is " + k.name + " " + k.salary + " " + p1.test(k));
		}

		// And, OR and Negate methods
		// predicate pre defined interface
		
		int arr[] = { 56, 87, 32, 6, 7 };
		Predicate<Integer> p2 = i -> i % 2 == 0;
		Predicate<Integer> p3 = i -> i > 50;

		for (int a : arr) {

			// System.out.println("P2 number is " + p2.test(a));

			if (p2.and(p3).test(a))
				System.out.println("And number is " + a);

			if (p2.or(p3).test(a))
				System.out.println("OR number is " + a);

			if (p2.negate().test(a))
				System.out.println("negate number is " + a);
		}

		// Function pre defined interface
		Function<Employee, Integer> fn = l -> {
											int sal =l.salary;
											if(sal>1000 && sal<50000) return sal*10;
											else if(sal>50000 && sal<20000) return sal*2;
											else return sal;
		};
		
		for (Employee k : al) {
			System.out.println("Function is  " + k.name + " "+ fn.apply(k));
		}
		
		// predicate pre defined interfaceand function
		
		Predicate<Integer> p4 = k -> (k>100000);
		
		for (Employee k1 : al) {
			if(p4.test(k1.salary)) System.out.println("Function k1 is  " + k1.name + " "+ fn.apply(k1));
		}
		
		
		
		//Consumer function
		Consumer <Employee> p5 = a-> System.out.println("consumer is " + a.name);
		
		
		for (Employee k2 : al) {
			int val = fn.apply(k2);
			if(p4.test(val)) {
				p5.accept(k2);
			}
		}
		
		Consumer <String> c1 = a-> System.out.println("hello " + a);
		Consumer <String> c2 = a-> System.out.println("tata " + a);
		Consumer <String> c3 = a-> System.out.println("bye " + a);
		c1.andThen(c2).andThen(c3).accept("week");
		Consumer <String> c4 = c1.andThen(c2).andThen(c3);
		c4.accept("qq");
	}
}