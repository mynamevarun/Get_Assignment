package p9;

import java.util.Date;

/**
 * This interface declares function of various shape.
 * 
 */
public interface Shape {

	double getArea();

	double getPerimeter();

	Point getOrigin();

	boolean isPointEnclosed(Point givenPoint);

	Date getTimeStamp();

	String getShapeType();

	double getOriginDistance();

	static enum ShapeType {
		SQUARE, RECTANGLE, CIRCLE, TRIANGLE;
	}
}
