package com.trg.interfaces;

public interface Shape {

	double getArea();
	double getPerimeter();
	
	default  void displayDetails() {
		System.out.println("Areaa: "+getArea());
		System.out.println("Perimeter: "+getPerimeter());	
	}
	
}
