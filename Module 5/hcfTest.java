package p5;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class hcfTest {

	@Test                    // Junit test for Hcf method
	public void Hcf_Positive_Test() {
		//we expect that it returns TRUE
		HcfAndLcm junit = new HcfAndLcm();
		int result = junit.calculateHcf(10,5);
	    assertEquals(5,result);
	}
	
	@Test                   
	public void Hcf_Negative_Test() {
	
		HcfAndLcm junit = new HcfAndLcm();
		int result = junit.calculateHcf(0,0); // handling the zero case
	    assertEquals(0,result);
	}

}
