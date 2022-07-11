package p9;

import java.util.Date;

public class Rectangle implements Shape {
	double length, width;
	Date date;
	Point originPoint;
	Point maxRectanglePoint;

	public Rectangle(double length, double width, Date date, Point originPoint) {
		this.length = length;
		this.width = width;
		this.date = date;
		this.originPoint = originPoint;
		
	}

	@Override
	public double getArea() {
		return length * width;
	}

	@Override
	public double getPerimeter() {
		return (2 * (length + width));
	}

	@Override
	public Date getTimeStamp() {
		return date;
	}

	@Override
	public Point getOrigin() {
		return originPoint;
	}

	

	@Override
	public String getShapeType() {
		return "RECTANGLE";
	}

	
}