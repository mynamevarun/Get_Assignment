package p9;

import java.util.Date;

public class Circle implements Shape {

	double radius;
	Date date;
	Point originPoint;
	Point center;

	public Circle(double radius, Date date, Point originPoint) {
		this.radius = radius;
		this.date = date;
		this.originPoint = originPoint;
		
	}

	@Override
	public double getArea() {
		return (Math.PI * radius * radius);
	}

	@Override
	public double getPerimeter() {
		return (2 * Math.PI * radius);
	}

	@Override
	public Point getOrigin() {
		return originPoint;
	}

	@Override
	public boolean isPointEnclosed(Point givenPoint) {

		if (getDistance(center, givenPoint) < radius) {
			return true;
		}
		return false;
	}

	@Override
	public Date getTimeStamp() {
		return date;
	}

	@Override
	public String getShapeType() {
		return "CIRCLE";
	}

	@Override
	public double getOriginDistance() {

		return Math.sqrt((originPoint.x - 0) * (originPoint.x - 0) // x^2-y^2
				+ (originPoint.y - 0) * (originPoint.y - 0));
	}

	
}
