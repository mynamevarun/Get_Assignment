package p7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class sparseMatrixOperationTest {

	@Test
	public void testTranspose1() {
		int[][] inputMatrix = { { 0, 4, 0 }, { 1, 0, 0 }, { 0, 0, 5 } };
		SparseMatrixOperations sparseMatrix = new SparseMatrixOperations(
				inputMatrix);
		int transposeResult[][] = { { 0, 1, 0 }, { 4, 0, 0 }, { 0, 0, 5 } };
		int [][] tm = sparseMatrix.transposeOfSparseMatrix();
		assertArrayEquals(transposeResult,
				tm);
	}

	@Test
	public void testTranspose2() {
		int[][] inputMatrix = { {} };
		SparseMatrixOperations sparseMatrix = new SparseMatrixOperations(
				inputMatrix);
		int transposeResult[][] = { { 0, 1, 0 }, { 4, 0, 0 }, { 0, 0, 5 } };
		int [][] tm = sparseMatrix.transposeOfSparseMatrix();
		assertEquals("array cannot be null",
				tm);
	}

	// This methods tests isSymmetric method
	@Test
	public void testIsSymmetric1() {
		SparseMatrixOperations sparseMatrix = new SparseMatrixOperations(
				new int[][] { { 4, 0, 0 }, { 0, 1, 0 }, { 0, 0, 5 } });
		assertEquals(true, sparseMatrix.isSparseMatrixSymmetric());
	}

	@Test
	public void testIsSymmetric2() {
		SparseMatrixOperations sparseMatrix = new SparseMatrixOperations(
				new int[][] { { 0, 4, 0 }, { 1, 0, 0 }, { 0, 0, 5 } });
		assertEquals(false, sparseMatrix.isSparseMatrixSymmetric());
	}

	// This methods tests addSparseMatrices method
	@Test
	public void testAdd1() {
		int matrix1[][] = { { 0, 4, 0 }, { 1, 0, 0 }, { 0, 0, 5 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 0 }, { 0, 0, 5 } };
		int addResult[][] = { { 0, 5, 0 }, { 5, 0, 0 }, { 0, 0, 10 } };
		SparseMatrixOperations spareMatrix1 = new SparseMatrixOperations(
				matrix1);
		assertArrayEquals(addResult, spareMatrix1.addTwoSparseMatrices(matrix2));
	}

	@Test
	public void testAdd2() {
		int matrix1[][] = { { 0, 4, 0 }, { 1, 0, 0 }, { 2, 0, 5 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 8 }, { 0, 0, 5 } };
		int addResult[][] = { { 0, 5, 0 }, { 5, 0, 8 }, { 2, 0, 10 } };
		SparseMatrixOperations spareMatrix1 = new SparseMatrixOperations(
				matrix1);
		
		assertArrayEquals(addResult, spareMatrix1.addTwoSparseMatrices(matrix2));
	}

	
	// This methods tests multiplySparseMatrices method
	@Test
	public void multiplyPositiveTest() {
		int matrix1[][] = { { 0, 4, 0 }, { 1, 0, 0 }, { 2, 0, 5 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 8 }, { 0, 0, 5 } };
		int multiplyResult[][] = { { 16, 0, 32 }, { 0, 1, 0 }, { 0, 2, 25 } };
		SparseMatrixOperations spareMatrix1 = new SparseMatrixOperations(
				matrix1);
	
		assertArrayEquals(multiplyResult,
				spareMatrix1.multiplySparseMatrix(matrix2));
	}

	@Test
	public void multiplyNegativeTest() {
		int matrix1[][] = { { 0, 4, 0, 9 }, { 1, 0, 0, 6 }, { 2, 0, 5, 8 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 8 }, { 0, 0, 5 } };
		
		SparseMatrixOperations spareMatrix1 = new SparseMatrixOperations(
				matrix1);
		
		assertEquals("Ever array needs same length...",
				spareMatrix1.multiplySparseMatrix(matrix2));
	}

}
