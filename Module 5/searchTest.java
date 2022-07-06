package p5;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class searchTest {

	@Test                   // Junit test for Linear Search method
	public void LinearSearch_Positive_Test() {
		//we expect that it returns TRUE
		searching junit = new searching();
		int arr[] = {2,1,3,4,5};
		int result = junit.LinearSearch(arr,0,4,5);
	    assertEquals(4,result);
	}
	
	@Test                    
	public void LinearSearch_Negative_Test() {
		//we expect that it returns False
		searching junit = new searching();
		int arr[] = {};
		int result = junit.LinearSearch(arr,0,4,5);
	    assertEquals(-1,result);
	}
	
	@Test                   // Junit test for Binary Search method
	public void BinarySearch_Positive_Test() {
		//we expect that it returns TRUE
		searching junit = new searching();
		int arr[] = {2,1,3,4,5,8};
		int result = junit.BinarySearch(arr,0,5,8);
	    assertEquals(5,result);
	}
	
	@Test                    
	public void BinarySearch_Negative_Test() {
		//we expect that it returns False
		searching junit = new searching();
		int arr[] = {};
		int result = junit.BinarySearch(arr,0,0,8);
	    assertEquals(-1,result);
	}
	

}
