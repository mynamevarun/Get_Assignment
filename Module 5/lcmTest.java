package p5;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class lcmTest {
	
	@Test                    // Junit test for Lcm method
	public void Lcm_Positive_Test() {
		//we expect that it returns TRUE
		HcfAndLcm junit = new HcfAndLcm();
		int result = junit.calculateLcm(2,3);
	    assertEquals(6,result);
	}
	
	@Test                    
	public void Lcm_Negative_Test() {
		
		HcfAndLcm junit = new HcfAndLcm();
		int result = junit.calculateLcm(0,0);
	    assertEquals(0,result);
	}
	
}