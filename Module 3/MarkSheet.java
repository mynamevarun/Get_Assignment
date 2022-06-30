package p3;
import java.util.*;

class gradesCalculation{
	
	/**
	 * To calculate the avergaes of grades of students
	 * @param Take the array of grades of float type
	 * @return   return the average grades.
	 */
	public float avgOfGrades(float grades[]) {
		
		try {
			float avg = 0;
			int len = grades.length;
			for(int i=0;i<len;i++) {
				avg += grades[i];
			}
			avg = avg/len;
			return avg;
		}
		catch(ArithmeticException e) {
			System.out.println(e);
			return -1f;
		}
	}
	
	/**
	 * To calculate the maximum of grades of students
	 * @param Take the array of grades of float type
	 * @return   return the maximum grade.
	 */
	public float maxOfGrades(float grades[]) {
		
		try {
			float max=Integer.MIN_VALUE;;
			for(int i=0;i<grades.length;i++) {
				if(grades[i] > max) {
					max = grades[i];
				}
			}
			return max;
		}
		catch(ArithmeticException e) {
			System.out.println(e);
			return -1f;
		}
	}
	
	/**
	 * To calculate the minimum of grades of students
	 * @param Take the array of grades of float type
	 * @return   return the minimum grade.
	 */
	public float minOfGrades(float grades[]) {
		
		try {
			float min=Integer.MAX_VALUE;;
			for(int i=0;i<grades.length;i++) {
				if(grades[i] < min) {
					min = grades[i];
				}
			}
			return min;
		}
		catch(ArithmeticException e) {
			System.out.println(e);
			return -1f;
		}
	}
	
	/**
	 * To calculate the percentage of students who scored >= 40 marks
	 * @param Take the array of grades of float type
	 * @return   return the percent.
	 */
	public float percentage(float grades[]) {
		try {
			float len = grades.length;
			float count=0;
			for(int i=0;i<len;i++) {
				if(grades[i]>=40) {
					count++;
				}
			}
			float percent = count/len *100;
			
			return percent;
		}
		catch(ArithmeticException e) {
			System.out.println(e);
			return -1f;
		}
	}
}

public class MarkSheet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Number of Students: ");
		int noOfStudent = sc.nextInt();
		
		float [] grades = new float[noOfStudent];
		System.out.println("Enter Grades of "+noOfStudent+" Students: " );
		for(int i=0;i<noOfStudent;i++) {
			grades[i] = sc.nextFloat();
		}
		
		gradesCalculation gc = new gradesCalculation();
		
		System.out.println("Average Grade is: ");
		System.out.printf("%.2f", gc.avgOfGrades(grades));
		System.out.println("\n");
		System.out.println("Maximum of all Grades is: ");
		System.out.printf("%.2f",gc.maxOfGrades(grades));
		System.out.println("\n");
		System.out.println("Minimum of all Grades is: ");
		System.out.printf("%.2f", gc.minOfGrades(grades));
		System.out.println("\n");
		System.out.println("Percentage is : ");
		System.out.printf("%.2f", gc.percentage(grades));
	}
}
