package com.ynov.microservices.oo;

public class Point {

	private int x;
	static String z;
	
	public static String getZ() {
		return z;
	}

	public static void setZ(String z) {
		Point.z = z;
	}
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	
	
}
