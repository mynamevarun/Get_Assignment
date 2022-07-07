package p6;
import java.util.*;


final class IntSet{
	private final int[]arr;
	
	
	/**
	 * A constructor to construct final int[] arr
	 * @param setArr which contain set of unique values between 1 to 1000
	 */
	public IntSet(int[] setArr) {
		
		
		arr = new int[setArr.length];
		
		for( int i = 0 ; i < arr.length ; i++) {
			
			arr[i] = setArr[i];
			
		}
	}
	
	/**
	 * To get the values of immutable array arr
	 * @return return the array arr
	 */
	public int[] getSet() {
		return arr;
	}
	
	/**
	 * Check if the given element is belong to the set or not
	 * @param element element to check if it is belong to the set or not
	 * @return true/false if the element belong to the set or not
	 */
	public boolean isMember(int element) {
		//Check if an element is present in the set or not
		for( int i = 0 ; i < arr.length ; i++) {
			if( arr[i] == element ) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * It return the size of the set
	 * @return size of the set
	 */
	public int size() {
		//Return the size of the set
		return arr.length;
	}
	
	/**
	 * Check if the passed set is the subset of the particular set or not
	 * @param s which is the set given for checking subset condition of the particular set 
	 * @return true/false if the given set is the subset of particular set or not
	 */
	public boolean isSubSet(IntSet s) {
		
		int[] subArr = s.getSet();
		//Check every element of a set into another set
		for(int i = 0 ; i < subArr.length ; i++ ) {
			if( !isMember(subArr[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Find the complement of the given set
	 * @return an array of complement of the particular set
	 */
	public int[] getComplement() {
		
		int[] complement = new int[ 1000 - arr.length ];
		int j = 0;
		//Find complement of the set with the universal set contain values 1 to 1000
		for( int i = 1 ; i <= 1000 ; i++) {
			if(!isMember(i)) {
				complement[j] = i;
				j++;
			}
		}
		
		return complement;
	}
	
	/**
	 * Count the number of items which are common to both the sets
	 * @param sArr the set from which you have to count common elements
	 * @return count of common elements to both sets
	 */
	public int countCommon(int[] sArr) {
		int count = 0 ;
		//Count the common elements in two sets
		for( int i = 0 ; i < sArr.length ; i++ ) {
			if(isMember(sArr[i])) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Return an array of intersection of two sets
	 * @param s set of which you have to find the intersection with the base set
	 * @return an array of intersection of both the sets
	 */
	public int[] intersection(IntSet s) {
		
		int[] sArr = s.getSet();
		int countCommon = countCommon(sArr);
		
		int[] intersectArr = new int[countCommon];
		
		//Find intersection of two sets
		for(int i = 0, j = 0  ; i < sArr.length ; i++) {
			if(isMember(sArr[i])) {
				intersectArr[j] = sArr[i];
				j++;
			}
		}
		
		return intersectArr;
	}
	
	/**
	 * Find the union of the both the sets
	 * @param s set of which you have to find the union with the base set 
	 * @return an array of the union of both the sets
	 */
	public int[] union(IntSet s) {
		
		int[] sArr = s.getSet();
		
		int countCommon = countCommon(sArr);
		
		int i,j;
		
		int[] unionArr = new int[sArr.length+arr.length - countCommon];
		
		//Find union of two sets
		for(i=0 ; i < arr.length ; i++) {
			unionArr[i] = arr[i];
		}
		
		for( j=0 ; j< sArr.length ; j++) {
			if(!isMember(sArr[i])) {
				unionArr[i] = sArr[j];
				i++;
			}
		}
		
		
		return unionArr;
	}
	
	/**
	 * Find the difference of the both the sets
	 * @param s set of which you have to find the difference with the base set 
	 * @return an array of the difference of both the sets

	 */
	public int[] difference(IntSet s) {
		
		int[] sArr = s.getSet();
		int countCommon = countCommon(sArr);
		
		int[] difference = new int[arr.length-countCommon];
		
		//Find difference of two sets
		for(int i= 0,j = 0 ; i<arr.length ; i++) {
			if(!s.isMember(arr[i])) {
				difference[j] = arr[i];
				j++;
			}
		}
		
		return difference;
	}
	
	
	
}

public class ADT {
	
	/**
	 * Method to check the availability of the element in the array
	 * @param arr given array in which we have to find the element
	 * @param index the index boundary up to which we have to check the array
	 * @param element the element we have to find
	 * @return true/false if an element is present of not
	 */
	static boolean isPresent(int[] arr, int index, int element) {
		for(int i = 0 ; i < index ; i++) {
			if(arr[i] == element ) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Take a set as input and return it
	 * @param numberOfElements number of elements in the set 
	 * @return a set of values
	 */
	static int[] inputSet(int numberOfElements ) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter elements in the Set ( elements must be unique and 1 <= element <= 1000 ):");
		System.out.println();
		
		int[] setArr = new int[numberOfElements];
		
		int element;
		
		for(int i = 0 ; i < numberOfElements ;  ) {
			System.out.println();
			System.out.print("Enter "+ (i+1) + " element : ");
			element = scn.nextInt();
			
			if((!isPresent(setArr, i, element)) && ( element >= 1) && (element <= 1000) ) {
				setArr[i] = element;
				i++;
			}
		}
		
		return setArr;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int numberOfElements, element, choice;
		
		System.out.println("Enter number of elements in the base set : ");
		numberOfElements = scn.nextInt();
		
		int[] arr = inputSet(numberOfElements);
		
		IntSet intSet = new IntSet(arr);
		
		IntSet testSet ;
		
		while(true) {
			
			
			System.out.println("1. Check an element belogs to a set or not ");
			System.out.println("2. Check size of the base set ");
			System.out.println("3. Check condition of subset for a set ");
			System.out.println("4. Find Complement of the set ");
			System.out.println("5. Find Union of sets ");
			System.out.println("6. Find Intersection of sets ");
			System.out.println("7. Find Difference of sets ");
			System.out.println("8. Exit ");
			System.out.println("Enter Your Choice :  ");
				
			choice = scn.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter an element : ");
				element = scn.nextInt();
				
				if(intSet.isMember(element)) {
					System.out.println("Item is belong to base set");
				}
				else {
					System.out.println("Item is not belong to base set");
				}
				
				
				break;
			case 2:
				int size = intSet.size();
				System.out.println("Size of base set : "+ size);
				
				break;
			case 3:
				System.out.println("Enter number of elements in the set : ");
				numberOfElements = scn.nextInt();
				
				arr = inputSet(numberOfElements);
				
				testSet = new IntSet(arr);
				
				if(intSet.isSubSet(testSet)) {
					System.out.println("This set is a subset of the base set");
				}
				else {
					System.out.println("This set is not a subset of the base set");
				}
				
				break;
			case 4:
				
				int[] complement = intSet.getComplement();
				
				System.out.print("Compliment : ");
				for( int i = 0 ; i < complement.length ; i++) {
					
					System.out.print(complement[i] + " ");
					if(complement[i] % 100 == 0) {
						System.out.println();
					}
				}
					
				break;
			case 5:
				System.out.println("Enter number of elements in the set : ");
				numberOfElements = scn.nextInt();
				
				arr = inputSet(numberOfElements);
				
				testSet = new IntSet(arr);
				
				int[] union = intSet.union(testSet);
				
				System.out.println("Union : ");
				
				for( int i = 0 ; i < union.length ; i++) {
					
					System.out.print(union[i] + " ");
					
				}
				
				break;
			case 6:
				
				System.out.println("Enter number of elements in the set : ");
				numberOfElements = scn.nextInt();
				
				arr = inputSet(numberOfElements);
				
				testSet = new IntSet(arr);
				
				int[] intersection = intSet.intersection(testSet);
				
				System.out.println("Intersection : ");
				
				for( int i = 0 ; i < intersection.length ; i++) {
					
					System.out.print(intersection[i] + " ");
					
				}
				
				break;
			case 7:
				System.out.println("Enter number of elements in the set : ");
				numberOfElements = scn.nextInt();
				
				arr = inputSet(numberOfElements);
				
				testSet = new IntSet(arr);
				
				int[] difference = intSet.intersection(testSet);
				
				System.out.println("Difference : ");
				
				for( int i = 0 ; i < difference.length ; i++) {
					
					System.out.print(difference[i] + " ");
					
				}
				break;
			case 8:
				scn.close();
				System.exit(0);
			}
			
		}
	}

}
