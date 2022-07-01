package p4;
import java.util.*;

/* This is ArrayOperation Class and its aim to do various type of operation on arrays
 * 
 * 
 */
class ArrayOperation{
	/**
	 * To calculate the maximum length of mirror image in an array
	 * @param array of positive integers
	 * @return   return the maximum length of mirror image
	 */
	public int maxMirror(int nums[]) {
		
		int length = nums.length;
		int mirrorLength=0;
		int maxMirrorLength  = 0;
		
		for(int i=0;i<length;i++) {
			mirrorLength=0;
			for(int j = length-1; j>-1 && i + mirrorLength < length; j--) {
				 if(nums[i + mirrorLength] == nums[j]) {
					 mirrorLength++;
				 }
				 else {
					 if(mirrorLength > 0) {
						 maxMirrorLength = Math.max(maxMirrorLength, mirrorLength);
						 mirrorLength=0;
					 }
				 }
			}
			maxMirrorLength = Math.max(maxMirrorLength, mirrorLength);
		}
		 
		 return maxMirrorLength;
	}
	
	/**
	 * To calculate the number of clumps in an array
	 * Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. 
	 * @param array of positive integers
	 * @return   return the number of clump in an array.
	 */
	public int clumpArray(int nums[]) {
		boolean match = false;
		int count=0;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]==nums[i+1] && !match) {
				count++;
				match = true;
			}
			else {
				match=false;
			}
		}
		return count;
	}
	
	/**
	 * To find the index if there is a place to split the input array so
	 *  that the sum of the numbers on one side is equal to the sum of the numbers on the other side 
	 * @param array of positive integers
	 * @return   return the index if not found then return -1.
	 */
	public int splitArray(int nums[]) {
		
		int leftSum=0;
		for(int i=0;i<nums.length;i++) {
			
			leftSum +=nums[i];
			int rightSum=0;
			
			for(int j=i+1;j<nums.length;j++) {
				rightSum += nums[j];
			}
			
			if(leftSum == rightSum) {
				return i+1;    // returning the j index;
			}
		}
		return -1;
	}
	
	/**
	 * an array that contains exactly the same numbers as the input array, 
	 * but rearranged so that every X is immediately followed by a Y. Do not move X within array, but every other number may move .
	 * @param array of positive integers
	 * @return   return the rearranged array.
	 */
	
	 public int[] arrayXYPosition(int[] nums,int x,int y) {

		 int t=0;
		  for(int i=0; i< nums.length ; i++)
		     for(int j=0;j<nums.length ; j++)

		     if(nums[i]==y && nums[j]==x)
		     {
		      t=nums[j+1];
		      nums[j+1]=nums[i];
		      nums[i]=t;
		     }
		     return nums;
		}
	 
	 
}


public class ArrOperation {
	
	public static void getInput(int[] arr){
		Scanner sc = new Scanner(System.in);
		 System.out.println("Enter Array elements: ");
		
		 for(int i=0;i<arr.length;i++) {
			 System.out.println("Enter "+(i+1)+" element");
			 arr[i] = sc.nextInt();
		 }
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr;
		ArrayOperation ap = new ArrayOperation();
		int choice,noOfElemets;
		
		
	while(true) {
		
		System.out.println("\n");
		System.out.println("1.Find the length of mirror section: ");
		System.out.println("2.Find the number of clumps: ");
		System.out.println("3.Arrange XY in array: ");
		System.out.println("4.Find split array index: ");
		System.out.println("5.Exit: ");
		
		System.out.println("Enter your choice: ");
		choice = sc.nextInt();
		switch(choice) {
		
		case 1:
			System.out.println("Enter number of elemets of array: ");
			noOfElemets = sc.nextInt();
			arr = new int[noOfElemets];
			getInput(arr);
			
			try {
				assert arr.length>0:"Array length never be empty";   // assertion for length = 0 
			}
			catch(AssertionError e) {
				System.out.println(e);
				break;
			}
			
			int largestLength = ap.maxMirror(arr);
			System.out.println("The Largest Mirror Length in the array is: "+largestLength);
			break;
			
		case 2:
			System.out.println("Enter number of elemets of array: ");
			noOfElemets = sc.nextInt();
			arr = new int[noOfElemets];
			getInput(arr);
			
			try {
				assert arr.length>0:"Array length never be empty";   // assertion for length = 0 
			}
			catch(AssertionError e) {
				System.out.println(e);
				break;
			}
			int clumpLength = ap.clumpArray(arr);
			System.out.println("The Number of clumps in an array is: "+clumpLength);
			break;
			
		case 3:
			System.out.println("Enter number of elemets of array: ");
			noOfElemets = sc.nextInt();
			arr = new int[noOfElemets];
			getInput(arr);
			
			System.out.println("Enter fixed element: ");
			int x = sc.nextInt();
			System.out.println("Enter movable element: ");
			int y = sc.nextInt();
			
			try {
				assert arr.length>0:"Array length never be empty"; // assertion for length = 0
				assert x!=y:"fixed and movable element should be equal";
			}
			catch(AssertionError e) {
				System.out.println(e);
				break;
			}
			System.out.println( "Position is arranged: "+Arrays.toString(ap.arrayXYPosition(arr, x, y)));
			break;
			
		case 4:
			System.out.println("Enter number of elemets of array: ");
			noOfElemets = sc.nextInt();
			arr = new int[noOfElemets];
			getInput(arr);
			
			try {
				assert arr.length>0:"Array length never be empty";   // assertion for length = 0 
			}
			catch(AssertionError e) {
				System.out.println(e);
				break;
			}
			System.out.println("The split index is: "+ap.splitArray(arr));
			break;
		
		case 5:
			
			System.exit(0);
			
		}
		
	}
 }
}
