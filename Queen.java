
public class Queen{


	/**
	*	Check if a chessboard is safe if placing a Queen in row,col
	*	@param chessboard current state of the board to check
	* 	@param row place a Queen at this row
	*	@param col place a Queen at this col
	*	@return true if the board is still safe, false otherwise
	*/

	public static boolean isSafe(int[][] chessboard, int row, int col) {
   	
		int N = chessboard.length;     
		
		//check row
		for(int i=0; i < N ; i++) {
			if(chessboard[row][i] == 1) {
				return false;
			}
		}
      
    //check column
    for(int i=0; i < N; i++) {
      if(chessboard[i][col] == 1) {
        return false;
      }
    }

    //check upper left diagonal
    int r = row;
    for(int c=col; c >= 0 && r >= 0; c--, r--) {
      if(chessboard[r][c] == 1) {
        return false;
      }
    }
      
    //check upper right diagonal
    r = row;
    for(int c=col; c < N && r >= 0; r--, c++) {
      if(chessboard[r][c] == 1) {
        return false;
      }
    }
      
    //check lower left diagonal
    r = row;
    for(int c=col; c>=0 && r < N; r++, c--) {
        if(chessboard[r][c] == 1) {
          return false;
      }
    }

    //check lower right diagonal
    for(int c=col; c < N && r < N; c++, r++) {
      if(chessboard[r][c] == 1) {
        return false;
      }
    }

    return true;

  }


	/**
	*	print the chessboard
	*	@param chessboard the current state of the board
	*/
 
	public static void print(int [][] chessboard){
		
    for(int i = 0; i <	chessboard.length; i ++){
      System.out.print("--");
    }
    System.out.println();
		for (int[] row: chessboard){
			for(int i = 0; i < row.length; i++){
				System.out.print((row[i]==1)? "Q ": ". ");
			}
      System.out.println();
		}

    for(int i = 0; i <	chessboard.length; i ++){
        System.out.print("--");
    }
    System.out.println();

	}

	/**
	*	reursive method to place queens in the chessboard
	*	@param chessboard the current state of the board
	*	@param queens number of queens left to be place
	*/

	public static void NQueen(int[][] chessboard, int queens){

      int N = chessboard.length;
		//System.out.println (queens);
		if (queens == 0){
			print(chessboard);
		}
		else {
			for(int i = 0; i < N; i++){
				
				if(isSafe(chessboard, N - queens,i )){
         
					chessboard[N - queens][i]=1;
					//print(chessboard);
					NQueen(chessboard, queens-1);
					chessboard[N - queens][i]= 0;
					//System.out.println("backtrack");
					//print(chessboard);
				}
			}
		}
	}




	public static void main(String [] args){

		if(args.length !=1){
			System.out.println("Usage: java Queen N");
			return;
		}
		
		int N = Integer.parseInt(args[0]);
		int [][]  board = new int[N][N];
		
		NQueen(board,N);



	}

}
