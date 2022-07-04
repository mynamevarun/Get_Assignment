package p5;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class RecursionTest {
	
	@Test                    // Junit test for Lcm method
	public void Lcm_Positive_Test() {
		//we expect that it returns TRUE
		HcfAndLcm junit = new HcfAndLcm();
		int result = junit.calculateLcm(2,3);
	    assertEquals(6,result);
	}
	
	@Test                    
	public void Lcm_Negative_Test() {
		//we expect that it returns False
		HcfAndLcm junit = new HcfAndLcm();
		int result = junit.calculateLcm(0,0);
	    assertEquals(0,result);
	}
	
	@Test                    // Junit test for Hcf method
	public void Hcf_Positive_Test() {
		//we expect that it returns TRUE
		HcfAndLcm junit = new HcfAndLcm();
		int result = junit.calculateHcf(10,5);
	    assertEquals(5,result);
	}
	
	@Test                   
	public void Hcf_Negative_Test() {
		//we expect that it returns False
		HcfAndLcm junit = new HcfAndLcm();
		int result = junit.calculateHcf(0,0);
	    assertEquals(0,result);
	}
	
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
		int arr[] = {2,1,3,4,5};
		int result = junit.LinearSearch(arr,0,4,5);
	    assertEquals(1,result);
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
		int arr[] = {2,1,3,4,5,8};
		int result = junit.BinarySearch(arr,0,5,8);
	    assertEquals(1,result);
	}
	
	@Test                   // Junit test for N-Queen method
	public void nQueen_Positive_Test() {
		//we expect that it returns TRUE
		arrangeNQueen junit = new arrangeNQueen();
		int [][] board = new int [][] {
            { 0,  0,  0,  0},
            { 0,  0,  0,  0},
            { 0,  0,  0,  0},
            { 0,  0,  0,  0} 
};

		boolean result = junit.nQueen(board,0,4);
	    assertEquals(true,result);
	}
	
	@Test                    
	public void nQueen_Negative_Test() {
		//we expect that it returns False
		arrangeNQueen junit = new arrangeNQueen();
		int [][] board = new int [][] {
            { 0,  0,  0,  0},
            { 0,  0,  0,  0},
            { 0,  0,  0,  0},
            { 0,  0,  0,  0} 
};
		boolean result = junit.nQueen(board,0,4);
	    assertEquals(false,result);
	}

}
