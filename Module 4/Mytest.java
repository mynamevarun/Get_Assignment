package p4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Mytest {

	@Test                    // Junit test for maxMirror method
	public void maxMirror_Positive_Test() {
		//we expect that it returns TRUE
		ArrayOperation junit = new ArrayOperation();
		int [] arr = {1,2,3,8,9,3,2,1};
		int result = junit.maxMirror(arr);
	    assertEquals(3,result);
	}
	
	@Test
	public void maxMirror_Negative_Test() {    
		//we expect that it returns FALSE
		ArrayOperation junit = new ArrayOperation();
		int [] arr = {1,2,3,8,9,3,2,1};
		int result = junit.maxMirror(arr);
		assertEquals(4,result);    
	}
	
	@Test                          // Junit test for clumpArray method
	public void clumpArray_Positive_Test() {
		//we expect that it returns TRUE
		ArrayOperation junit = new ArrayOperation();
		int [] num = {1,2,2,3,4,4};
		int result = junit.clumpArray(num);
	    assertEquals(2,result);
	}
	
	@Test
	public void clumpArray_Negative_Test() {
		//we expect that it returns TRUE
		ArrayOperation junit = new ArrayOperation();
		int [] nums = {1,2,2,3,4,4};
		int result = junit.clumpArray(nums);
	    assertEquals(1,result);
	}
	
	@Test                               //Junit test for spliArray method
	public void splitArray_Positive_Test() {
		//we expect that it returns TRUE
		ArrayOperation junit = new ArrayOperation();
		int [] num = {1,1,1,2,1};
		int result = junit.clumpArray(num);
	    assertEquals(3,result);
	}
	
	@Test
	public void splitArray_Negative_Test() {
		//we expect that it returns TRUE
		ArrayOperation junit = new ArrayOperation();
		int [] nums = {1,1,1,2,1};
		int result = junit.clumpArray(nums);
	    assertEquals(1,result);
	}
	
	
	
	

}
