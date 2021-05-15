package com.trg.interfaces;

public class InterfaceMain {

	public static void main(String[] args) {

		Rectangle r = new Rectangle(34, 12);
		// showDetails(r);

		r.displayDetails();
		
		Square s = new Square(30.5);
//		showDetails(s);
		r.displayDetails();
		
		Circle c = new Circle(10.4);
		// showDetails(c);

		c.displayDetails();

	}

	static void showDetails(Shape s) {

		if (s instanceof Rectangle)
			System.out.println("Shape: Rectangle");

		if (s instanceof Square)
			System.out.println("Shape: Square");

		if (s instanceof Circle)
			System.out.println("Shape: Circle");

		System.out.println("Area: " + s.getArea());
		System.out.println("Perimeter: " + s.getPerimeter());
	}
}
