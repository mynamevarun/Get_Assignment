package p6;
import java.util.*;

/**
 * This class contains the methods which are to be performed on a polynomial. 
 * As polynomials are immutable so this class is also immutable
 * @author Bhavya Bhatia

 */

public class Polynomial {

	private int[] polynomials;
	private int polynomialDegree;
	
	/**
	 * Constructor to initialize the array and the degree
	 * @param polynomial is the input array which contains the coefficients of the input polynomial
	 */
	
	Polynomial(int[] polynomial){
		
		this.polynomials = polynomial;
		this.polynomialDegree = polynomial.length-1;
	}
	
	/**
	 * This methods evaluates the given polynomial with the given number
	 * @param x is the number through which the polynomial is to be evaluated
	 * @return {float} evaluation of the polynomial
	 */
	
	public float evaluate(float value) {
		
		if(polynomials.length < 1) {
			throw new AssertionError("Array is Empty");
		}
		
		float evaluation = (float) 0.0;
		
		for(int i = polynomialDegree; i>=0; --i) {
			
			evaluation += (float) (polynomials[i] * Math.pow(value, i));
		}
		return evaluation;
	}
	
	/**
	 * This method calculates the degree of the polynomial
	 * @return {int} degree of the polynomial
	 */
	
	public int degreeOfPolynomial() {
		
		if (polynomials.length < 1) {
			throw new AssertionError("Array is empty");
		}
		return polynomialDegree;
		
	}
	
	/**
	 * This method adds two polynomials
	 * @param inputPolynomial1 is the first polynomial number
	 * @param inputPolynomial2 is the second polynomial number
	 * @return {String} the added polynomial number
	 */
	
	public String addPolynomial(Polynomial inputPolynomial2) {
		
		if(polynomials.length <1 || inputPolynomial2.polynomials.length <1) {
			throw new AssertionError("Array is Empty");
		}
		int maxLength = Math.max(polynomialDegree +1 , inputPolynomial2.polynomialDegree +1);
		int minLength = Math.min(polynomialDegree +1 , inputPolynomial2.polynomialDegree +1);
		
		Polynomial sum = new Polynomial(new int[maxLength]);
		
		for (int i = 0; i < minLength; ++i) {
			sum.polynomials[i] = polynomials[i]
					+ inputPolynomial2.polynomials[i];

		}
		if(maxLength == inputPolynomial2.polynomials.length) {
			for(int i= minLength; i<maxLength;i++) {
				sum.polynomials[i] = inputPolynomial2.polynomials[i];
			}
		}
		else {
			for(int i=minLength; i<maxLength; i++) {
				sum.polynomials[i] = polynomials[i];
			}
		}
		
		return getPolyString(sum);
		
	}
	
	/**
	 * This method Multiply two polynomials
	 * @param inputPolynomial1 is the first polynomial number
	 * @param inputPolynomial2 is the second polynomial number
	 * @return {String} the added polynomial number
	 */
	
	public String multiplyPolynomail(Polynomial inputPolynomial2) {
		
		if (polynomials.length < 1
				|| inputPolynomial2.polynomials.length < 1) {
			throw new AssertionError("Array is empty");
		}
		
		Polynomial multipliedPolynomial = new Polynomial(new int[polynomialDegree
		                                         				+ inputPolynomial2.polynomialDegree + 1]);
		for(int i=0; i<= polynomialDegree; i++) {
			for(int j=0; j<= inputPolynomial2.polynomialDegree; j++) {
				multipliedPolynomial.polynomials[i+j] += polynomials[i] * inputPolynomial2.polynomials[j]; 
			}
		}
		
		return getPolyString(multipliedPolynomial);
	}
	
	/**
	 * This method constructs the polynomial string with the help of coefficients
	 * @param inputPolynomial is the polynomial whose string is to be constructed
	 * @return {String} Constructed String	
	 */
	
	public String getPolyString(Polynomial inputPolynomial) {
		if (inputPolynomial.polynomials.length < 1) {
			throw new AssertionError("Array is empty");
		}
		StringBuilder dispalyString = new StringBuilder();
		for (int i = inputPolynomial.polynomials.length - 1; i > 0; i--) {
			dispalyString.append(inputPolynomial.polynomials[i]
					+ "x^" + i + "+");
		}
		dispalyString.append(inputPolynomial.polynomials[0]);
		return dispalyString.toString();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		int choice,size;
		
	while(true) {
		
		System.out.println("1.Evaluate: ");
		System.out.println("2.Get Degree: ");
		System.out.println("3.Add two polynomial: ");
		System.out.println("4.Multiply two polynomial: ");
		System.out.println("5.Exit: ");
		
		System.out.print("Enter your choice: ");
		choice = sc.nextInt();
		switch(choice) {
		
		case 1:
			System.out.println("Enter the size of array: ");
			size = sc.nextInt();
			int value;
			int []polynomial1 = new int[size];
			for(int i=0;i< size;i++) {
				System.out.println("Enter "+(i+1)+" element: ");
				polynomial1[i] = sc.nextInt();
			}
			System.out.println("Enter the value of variable: ");
			value = sc.nextInt();
			Polynomial poly = new Polynomial(polynomial1);
			System.out.println("The evaluation of polynomial is: "+poly.evaluate(value));
			break;
			
		case 2:
			System.out.println("Enter the size of array: ");
			size = sc.nextInt();
			int []polynomial2 = new int[size];
			for(int i=0;i< size;i++) {
				System.out.println("Enter "+(i+1)+" element: ");
				polynomial2[i] = sc.nextInt();
			}
			Polynomial poly2 = new Polynomial(polynomial2);
			System.out.println("The degree of polynomial is "+poly2.degreeOfPolynomial());
			break;
			
		case 3:
			System.out.println("Enter the size of array: ");
			size = sc.nextInt();
			int []polynomial3 = new int[size];
			for(int i=0;i< size;i++) {
				System.out.println("Enter "+(i+1)+" element: ");
				polynomial3[i] = sc.nextInt();
			}
			System.out.println("Enter the size of 2 array: ");
			size = sc.nextInt();
			int []polynomial4 = new int[size];
			for(int i=0;i< size;i++) {
				System.out.println("Enter "+(i+1)+" element: ");
				polynomial4[i] = sc.nextInt();
			}
			Polynomial poly3 = new Polynomial(polynomial3);
			Polynomial poly4 = new Polynomial(polynomial4);
			System.out.println("The addition of two array is: "+poly3.addPolynomial(poly4));
			break;
			
		case 4:
			System.out.println("Enter the size of array: ");
			size = sc.nextInt();
			int []polynomial5 = new int[size];
			for(int i=0;i< size;i++) {
				System.out.println("Enter "+(i+1)+" element: ");
				polynomial5[i] = sc.nextInt();
			}
			System.out.println("Enter the size of 2 array: ");
			size = sc.nextInt();
			int []polynomial6 = new int[size];
			for(int i=0;i< size;i++) {
				System.out.println("Enter "+(i+1)+" element: ");
				polynomial6[i] = sc.nextInt();
			}
			Polynomial poly5 = new Polynomial(polynomial5);
			Polynomial poly6 = new Polynomial(polynomial6);
			System.out.println("The addition of two array is: "+poly5.multiplyPolynomail(poly6));
			break;
			
		case 5:
			System.exit(0);
			
			
			}
		
		}
	}
}
