package p5;
import java.util.*;

class searching{
	/**
	 * Implementation of Recursive Linear Search
	 * @param arr[] - array of integer type
	 * @param start - starting index of array.
	 * @param last - ending index of array
	 * @param noToSearch- value to be search
	 * @return index i such that arr[i] == noToSearch and if not then return -1
	 */
	public int LinearSearch(int arr[], int start, int last,int noToSearch ) {
		
		if(last<start) {
			return -1;
		}
		if(arr[start]==noToSearch) {
			return start;
		}
		if(arr[last] == noToSearch) {     
			return last;
		}
		return LinearSearch(arr,start+1,last-1,noToSearch);     
	}
	
	/**
	 * Implementation of Recursive Binary Search
	 * @param arr[] - array of integer type
	 * @param start - starting index of array.
	 * @param last - ending index of array
	 * @param noToSearch - value to be search in array
	 * @return  index i such that arr[i] == noToSearch and if not then return -1
	 */
	public int BinarySearch(int arr[], int start, int last, int noToSearch) {
		
		if(last >= start) {
			int mid = start +(last-start)/2;
			
			if(arr[mid]==noToSearch) {
				return mid;
			}
			
			// If element is smaller than mid, then it can
            // only be present in left subarray
			if(arr[mid] > noToSearch) {
				return BinarySearch(arr,start,mid-1,noToSearch);
			}
			
			// Else the element can only be present
            // in right subarray
			else {
				return BinarySearch(arr,mid+1,last,noToSearch);
			}
		}
		return -1;
	}
}



public class Search {
	
	public static void getInput(int[] arr){
		Scanner sc = new Scanner(System.in);
		 System.out.println("Enter Array elements: ");
		
		 for(int i=0;i<arr.length;i++) {
			 System.out.println("Enter "+(i+1)+" element");
			 arr[i] = sc.nextInt();
		 }
		}
	public static void sortArray(int[] arr){
		int temp;
		int num = arr.length;
		for (int i = 0; i < num - 1; i++) {
            for (int j = i + 1; j < num ; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                 }
            }
		}
     }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searching sh = new searching();
		Scanner sc = new Scanner(System.in);
		int arr[];
		int choice,noOfElements,noToSearch;
		
		while(true) {
			
			System.out.println("1.Linear Search: ");
			System.out.println("2.Binary Search: ");
			System.out.println("3.Exit: ");
			
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter number of elemets of array: ");
				noOfElements = sc.nextInt();
				arr = new int[noOfElements];
				getInput(arr);
				System.out.println("Enter value to be searched: ");
				noToSearch = sc.nextInt();
				
				int result = sh.LinearSearch(arr, 0,noOfElements-1, noToSearch);
				if (result == -1)
		            System.out.println("Element not present");

				else
		            System.out.println("Element found at index "
		                               + result);
				break;
				
			case 2:
				System.out.println("Enter number of elemets of array: ");
				noOfElements = sc.nextInt();
				arr = new int[noOfElements];
				getInput(arr);
				sortArray(arr); // to sort the array
				
				System.out.println("Enter value to be searched: ");
				noToSearch = sc.nextInt();
				
				result = sh.BinarySearch(arr, 0,noOfElements-1, noToSearch);
				if (result == -1)
		            System.out.println("Element not present");

				else
		            System.out.println("Element found at index "
		                               + result);
				break;
				
			case 3:
				System.exit(0);
				
			}
		}
    }
}