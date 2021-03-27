package pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import io.github.bonigarcia.wdm.WebDriverManager;




public class test {
	
	public static void run() {
		
		int count=0;
		try {
			count++;
		}
		catch(Exception e) {
			count++;
		}
		finally {
			++count;
			
		}
		
	}
	@FunctionalInterface
	 interface ABV
	 {
		 void run();
		default public void run1() {
		}
	}
	
	static int run(int num) {
		
		int reversenum =0;
		while( num != 0 )
		{
		    reversenum = reversenum * 10;
		    reversenum = reversenum + num%10;
		    num = num/10;
		}
		return reversenum;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
/*		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		run();
		int a11=10;int b11=12;
		a11=b11--;
		System.out.println("a11 isssssssss" +a11);
		System.out.println("b11 isssssssss" +b11);
			
		List<Integer> ar3  = new ArrayList<Integer>(Arrays.asList(-15,12,1,26,9,-15,9));
		
		Map<Object, Long> ar4 = ar3.stream().collect(Collectors.groupingBy(n->n, Collectors.counting()));
		System.out.println("a is " +ar4);
		//palandrome of anumber
		//While Loop: Logic to find out the reverse number
		int aa= run(232);
		if(aa==232) {
			System.out.println("pallandrome");
		}
		else
			System.out.println("not a pallandrome");
		
String str = "Welcome To Edureka";
String[] strArray = str.split(" ");
for (String temp: strArray){
	char[] s1 = temp.toCharArray();
	for (int j = s1.length-1; j>=0; j--)
{System.out.print(s1[j]);}
System.out.print(" ");
}
		
String str1 = "Welcome";	
for (int i=str1.length()-1;i>=0;i--){
	 System.out.print(str1.charAt(i));
	
}
		
		
		
		
		int arr[]= {2,63,2,6,3,63};
		Set<Integer> ar = new LinkedHashSet<Integer>();
		for(int i:arr) {
			ar.add(i);
		}
		System.out.println(ar.stream().sorted().collect(Collectors.toSet()));
	System.out.println("set is " +ar);
	
	
	
int a=10,b=20;
int temp;
temp =a;
a=b;
b=temp;

//check for prime number
int m=0,flag =0, n=10;

for(int i=2;i=<n/2;i++) {
	m=n%i;
	if(m==0) {
		flag=1;
		break;
		
	}
}
if(flag==1) {
	System.out.println("not a prime number");
}
else System.out.println("is  a prime number");

System.out.println("a and b are " +a +" " + b);*/

//print prime numbers
int n=25;int flag;
for (int i = 1; i <= n; i++) {
	 
    // Skip 0 and 1 as they are
    // niether prime nor composite
    if (i == 1 || i == 0)
        continue;

    // flag variable to tell
    // if i is prime or not
    flag = 1;

    for (int j = 2; j <= i / 2; ++j)
    {
        if (i % j == 0)
        {
            flag = 0;
            break;
        }
    }

    // flag = 1 means i is prime
    // and flag = 0 means i is not prime
    if (flag == 1)
        System.out.print(i + " ");
}
}

/*a=a+b;
b=a-b;
a=a-b;
System.out.println("a and b are " +a +" " + b);
	

System.out.println("Input your number and press enter: ");
//This statement will capture the user input
Scanner in = new Scanner(System.in);
//Captured input would be stored in number num
num = in.nextInt();


		//int ar[] = {12,4,0,0,7,5};
		//int ar[] = {1,0,2,4,0,5,7};

int ar[] = {1,7,2,0,4,5,0};
	int a1[]= {0,0,7};
	int count  =0;
	for(int i=0;i<ar.length;i++) {
		System.out.println("i is " + i);
		for(int j=count;j<a1.length;j++) {
			System.out.println("j is " + j);
			if(ar[i] == a1[j]) {
				System.out.println("count is " + count);
				++count;
				//j=count;
				break;
			}
			break;
		}
	}
	if(count==3) {
		System.out.println("success");
	}
	else
		System.out.println("No success");
	}*/

}
