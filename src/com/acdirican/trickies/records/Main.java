package com.acdirican.trickies.records;

import java.util.Objects;

/**
 * Record: To overcome boilerplate code. It allows us to have immutable objects
 * writing very little code.
 * 
 * A record - can have multiple constructors - can have static attributes and
 * methods - implements interfaces - cannot extends a class because it already
 * extends java.lang.Record - cannot be extended (final)
 * 
 * @author Ahmet Cengizhan Dirican
 *
 */

interface IPoint {
	void print();
}

record Point2D(int x, int y, String name) implements IPoint { // no extention because a record extends java.lang

	public static Point2D ZERO = new Point2D();

	public Point2D {
		Objects.requireNonNull(name);
	}

	public Point2D() {
		this(0, 0, "P");
	}

	public static int dist(Point2D p) {
		return (int) Math.sqrt(p.x * p.x + p.y * p.y);
	}

	@Override
	public void print() {
		System.out.println(this);

	}

};

public class Main {
	public static void main(String[] args) {

		Point2D z = Point2D.ZERO;
		System.out.println(z);
		Point2D p = new Point2D(3, 4, "X");
		System.out.println(p);

		p.print();

		System.out.println("Super class of the Point2D: " + Point2D.class.getSuperclass());
	}
}
