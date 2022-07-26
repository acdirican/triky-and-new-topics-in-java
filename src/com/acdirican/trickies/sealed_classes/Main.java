package com.acdirican.trickies.sealed_classes;

/**
 * A sealed class or interfaces is a construct that strictly determines (limits)
 * constructs that can extend or implement it.
 * 
 * It uses sealed modifier and and permits cluase. The permits clause should be
 * defined after any extends or implements clauses: - sealed : to seal a
 * construct - permits: to give a list of permitted constructs Any construct
 * that extends or implements a sealed construct must declare itself as - if
 * it's a class: final, sealed, non-sealed - if it's an interface: sealed or
 * non-sealed
 * 
 * @author Ahmet Cengizhan Dirican
 *
 */

sealed interface Flower permits Rose, Daisy {
	void grow();
}

non-sealed interface Rose extends Flower {

}

non-sealed class Daisy implements Flower {

	@Override
	public void grow() {
		// TODO Auto-generated method stub

	}

}

class RedRose implements Rose {

	@Override
	public void grow() {
		// TODO Auto-generated method stub

	}

}

public class Main {
	public static void main(String[] args) {
		
	}
}
