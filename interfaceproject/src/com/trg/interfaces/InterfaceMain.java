package com.trg.interfaces;

import java.text.DecimalFormat;

public class InterfaceMain {

	public static void main(String[] args) {

		Rectangle r = new Rectangle(34, 12);
		showDetails(r);

		// r.displayDetails(); // calling default method of Shape interface

		Square s = new Square(30.5);
		showDetails(s);

		Circle c = new Circle(10.4);
		showDetails(c);
	}

	static void showDetails(Shape s) {

		if (s instanceof Rectangle)
			System.out.println("Shape: Rectangle");

		if (s instanceof Square)
			System.out.println("Shape: Square");

		if (s instanceof Circle)
			System.out.println("Shape: Circle");

		DecimalFormat df = new DecimalFormat("00000.00");
		System.out.println("Area: " + df.format(s.getArea()));
		System.out.println("Perimeter: " + df.format(s.getPerimeter()));
	}
}
