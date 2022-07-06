package p5;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NQueenTest {


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
}
