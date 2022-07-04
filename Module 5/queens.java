package p5;
import java.util.*;

class arrangeNQueen{
	
	/*A function to check if a queen can be placed on board[row][col]
	 * @params takes 2d array of type int and size of array
	 * @returns bool results
	 */ 
	boolean isSafe(int board[][],int row,int col, int size) {
		
		// checking for each row 
		for(int tempRow = 0; tempRow < row; tempRow++ ) {
			if(board[tempRow][col] == 1) {
				return false;
			}
		}
		
		// check for upper-left diagonal
		int dupRow = row;
		int dupCol = col;
		while(dupRow >=0 && dupCol >=0) {
			if(board[dupRow][dupCol] == 1) {
				return false;
			}
			dupRow--;
			dupCol--;
		}
		
		// checking for upper-right diagonal
		dupRow=row;
		dupCol=col;
		while(dupRow >=0 && dupCol<size) {
			if(board[dupRow][dupCol]==1) {
				return false;
			}
			dupRow--;
			dupCol++;
		}
		return true;
	}
	
	
	/* A recursive utility function to solve N Queen problem
	 * @params takes 2d array of type int and size of array
	 * @returns bool results
	 */ 
	boolean nQueen(int board[][],int row,int size) {
		
		// base case
		if(row==size) {
			return true;
		}
		
		for(int col=0;col<size;col++) {
			
			// Check if queen can be placed on board[row][col]
			if(isSafe(board,row,col,size)) {
				board[row][col] = 1;
				
				  // recur to place rest of the queens
				if(nQueen(board,row+1,size)) {
					return true;
				}
				else {
					// Remove queen from board[row][col]
					board[row][col] = 0;   
				}
			}
		}
		return false;
	}
}

public class queens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		arrangeNQueen qn = new arrangeNQueen();
		Scanner sc = new Scanner(System.in);
		int size;
		System.out.println("Enter the size of board: ");
		size = sc.nextInt();
		
		int [][] board = new int[size][size];
		for(int i=0;i<size;i++) {
			board[i] = new int[size];
			for(int j=0;j<size;j++) {
				board[i][j] = 0;                // initializing the board with 0
			}
		}
		
		boolean result = qn.nQueen(board, 0, size);
		if(result) {
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.print("\n");
			}
		}
	}
}
