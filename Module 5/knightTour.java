package p5;
import java.util.*;

public class knightTour {
	
	public static final int N = 8;
	 
    
	/*  Check if `(row, col)` is valid chessboard coordinates.
	 * @params row - number of row
	 * @params col - number of col
	 * @params visited - 2-D array use to store the movement of knight
	 * @returns bool results
	 */ 
   
    private static boolean isValid(int row, int col,int[][] visited)
    {
    	 // Note that a knight cannot go out of the chessboard
    	return ( row >= 0 && row < N && col >= 0 && col < N && visited[row][col] == -1);
    }
 
    // method to print the Resulted 2D array.
    private static void print(int[][] visited)
    {
        for (var r: visited) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println();
    }
     
     /*  Recursive function to perform the knight's tour using backtracking
	 * @params visited- take 2d array of int type which show the position of knight
	 * @params row - row number of knight
	 * @params col - column number if knight
	 * @params pos -  position number of knight
	 * @params xMove - array of total possible moves in x direction
	 * @params yMove - array of possible moves in y direction
	 * @returns True/False: based on to possible to arrange knight or not
	 */ 
    private static boolean knightTour(int[][] visited, int row, int col, int pos,int xMove[],int yMove[])
    {
    	int xNext, yNext;
    	   if (pos == N*N)     //when the total board is covered
    	      return true;
    	   
    	   for (int k = 0; k < N; k++) {
    		      xNext = row + xMove[k];
    		      yNext = col + yMove[k];
    		      
    		      if (isValid(xNext, yNext, visited)) {     //check room is preoccupied or not
    		         visited[xNext][yNext] = pos;
    		         if (knightTour(visited,xNext,yNext,pos+1,xMove,yMove))
    		            return true;
    		         else
    		            visited[xNext][yNext] = -1;// backtracking
    		      }
    		   }
    		   return false;
         }
    
    /*  function to process the knight's tour solutions
	 * @params visited- 2-D array use to store the order of movement of knight
	 * @returns True/False: based on results
	 */ 
    private static boolean findKnightTour(int [][]visited) {
    	
    	for (int x = 0; x < N; x++)     //initially set all values to -1 of solution matrix
    	      for (int y = 0; y < N; y++)
    	         visited[x][y] = -1;
    	
    	   //all possible moves for knight
    	   int xMove[] = {  2, 1, -1, -2, -2, -1,  1,  2 };
    	   int yMove[] = {  1, 2,  2,  1, -1, -2, -2, -1 };
    	   
    	   visited[0][0]  = 0;     //starting from room (0, 0)

    	   if (knightTour(visited,0, 0, 1,xMove, yMove) == false) {
    		   System.out.println("Solution does not exist.");
    	      return false;
    	   } else
    	      print(visited);
    	   return true;
    }
    
 
    public static void main(String[] args)
    {
        // `visited[][]` serves two purposes:
        // 1. It keeps track of squares involved in the knight's tour.
        // 2. It stores the order in which the squares are visited.
        int[][] visited = new int[N][N];
       
        findKnightTour(visited);
    }

}
