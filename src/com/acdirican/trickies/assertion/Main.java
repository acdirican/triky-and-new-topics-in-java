package com.acdirican.trickies.assertion;

/**
 * Java assertion (assert) is to check the correctness of any assumptions 
 * that have been made in the program. 
 * 
 * #How:
 * Assertion is realized using the assert statement in your code. 
 * While executing an assertion, we assume that it to be true.
 * If the assertion fails, JVM throws AssertionError error.
 * 
 * We can use an assert statement with a Boolean expression and 
 * can write in two different ways which are as follows:
 * Assert expression;
 * Assert expression1: expression2;
 * 
 * #Why/When
 * Java assertion is used for testing purposes or catching bugs. 
 * Assertions are generally used to check logically impossible situations 
 * Assertions are generally disabled at run-time.
 * No use in production code.
 * 
 * To enable assertion in Java
 * 		java –ea Main.java
 * 		Java –enableassertions Main.java
 * 
 * To disable  assertion in Java
 * 		java –da Main.java
 * 		Java –disableassertions Main.java 
 *
 * #Eclipse:
 * Put the -ea or -da into Run Configuration > Arguments > VM Argutments 
 * 
 * @author Ahmet Cengizhan Dirican
 *
 */
public class Main {
	
	
	public static void main(String[] args) {
		//test1(25); // error
		test1(50);
		int num = 0;
		//num = test2(null); // error
		System.out.println("Num:" + num);
		num = test2("123");
		System.out.println("Num:" + num);
	}
	
	
	private static int test2(String value) {
		assert value != null || value=="": "Parameter is null";
		return Integer.parseInt(value);
	}

	private static void test1(int weight) {
		int limit = 30;	
	    assert weight >= limit : "Under weight";
	    
	    System.out.println("Weight is "+ weight);
		
	}
	
}
