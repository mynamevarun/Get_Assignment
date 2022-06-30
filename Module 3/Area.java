package p3;

class areaOperation{
	
	/**
	 * To calculate the area of the triangle
	 * @param Take the height and width of type double 
	 * @return   return the area in double type.
	 */
	public double triangleArea(double height, double width) {
		
		try {
			double area=0;
			
			area = 0.5 * height * width;
			
			return area;
		}
		catch(ArithmeticException e) {
			System.out.println(e);
			return -1d;
		}
		
	}
	
	/**
	 * To calculate the area of the rectangle
	 * @param Take the height and width of type double 
	 * @return   return the area in double type.
	 */
	public double rectangleArea(double height, double width) {
		
		try {
			double area = height * width;
			
			return area;
		}
		catch(ArithmeticException e) {
			System.out.println(e);
			return -1d;
		}
		
	}
	
	/**
	 * To calculate the area of the square
	 * @param Take the width of type double 
	 * @return   return the area in double type.
	 */
	public double squareArea(double width) {
		
		try {
			double area = width*width;
			
			return area;
		}
		catch(ArithmeticException e) {
			System.out.println(e);
			return -1d;
		}
		
	}
	
	/**
	 * To calculate the area of the circle
	 * @param Take the radius of type double 
	 * @return   return the area in double type.
	 */
	public double circleArea(double radius) {
		
		try {
			double pi = 3.14;
			
			double area = pi * radius * radius;
			
			return area;
		}
		catch(ArithmeticException e) {
			System.out.println(e);
			return -1d;
		}
		
		
	}
	
}


public class Area {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		areaOperation op = new areaOperation();
		
		System.out.println(op.triangleArea(5, 0));
		System.out.println(op.rectangleArea(10, 5));
		System.out.println(op.squareArea(5));
		System.out.println(op.circleArea(8));
	}

}
