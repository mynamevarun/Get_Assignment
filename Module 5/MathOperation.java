package p5;
import java.util.*;

class HcfAndLcm{
	
	static int multiple=0; //using static variable to hold the value
	
	/**
	 * Function to return the lcm of two numbers using recursion
	 * @param two numbers as input
	 * @return   return the lcm of two numbers
	 */
	public int lcm_of_two_number(int x,int y) {
		
		multiple+=y;
		
		//base case
		if((multiple%x==0) && (multiple%y==0)) {
			return multiple;
		}
		else {
			return lcm_of_two_number(x,y);
		}
	}
	
	/**
	 * Function to return the HCF of two numbers using recursion
	 * @param  two numbers as input
	 * @return   return the HCF of two numbers
	 */
	public int hcf_of_two_number(int num1,int num2) {
		
		// base case
		if(num1%num2==0) {
			return num2;
		}
		
		return hcf_of_two_number(num2,num1%num2); // recursive call to function 
	}
}



public class MathOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HcfAndLcm hl = new HcfAndLcm();
		Scanner sc = new Scanner(System.in);
		int choice,num1,num2;
	
	while(true) {
			
		
		System.out.println("1.Find Lcm of two number: ");
		System.out.println("2.Find Hcf of two number: ");
		System.out.println("3.Exit: ");
		
		System.out.println("Enter your choice: ");
		choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:
			
			System.out.println("Enter number 1: ");
			num1 = sc.nextInt();
			System.out.println("Enter number 2: ");
			num2 = sc.nextInt();
			// check if number is positive or not
			if(num1 <=0 || num2<=0) { 
				System.out.println("The number should be Positive! RETRY. ");
				break;
			}
			System.out.println("The Lcm of two number is : "+hl.lcm_of_two_number(num1, num2));
			break;
			
		case 2:
			System.out.println("Enter number 1: ");
			num1 = sc.nextInt();
			System.out.println("Enter number 2: ");
			num2 = sc.nextInt();
			// check if number is positive or not
			if(num1 <=0 || num2<=0) {
				System.out.println("The number should be Positive! RETRY. ");
				break;
			}
			System.out.println("The Hcf of two number is : "+hl.hcf_of_two_number(num1, num2));
			break;
		case 3:
			System.exit(0);
		}
	}
	}

}
