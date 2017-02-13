public class QueenBoard{
    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j <board.length; j++) {
		board[i][j] = 0;
	    }
	}
    }

    public boolean solve() {
	return solveH(0);
    }

    private boolean solveH(int col){
	if (col == board.length) {
	    return true;
	}
	for (int i = 0; i < board.length; i++) {
	    if (board[col][i] == 0) {
		board[col][i] = -1;
		placeQueen(col,i);
		return solveH(col + 1);
	    }
	    if((col != 0) && (board[col][i] != 0)) {
		removeQueen(col,i);
		return solveH(col - 1);
	    }
	}
	return false;
    }

    private void placeQueen(int col, int row){	
	setRestrictions(0,col,row);
    }

    private void removeQueen(int col,int row) {
	setRestrictions(1,col,row);
    }

    private void setRestrictions(int num,int col,int row) {
	if (num == 0) {
	    for (int i = 0; i <  board.length; i++) {
		if (i != row) {
		    board[col][i] ++;
		}
	    }
	    for(int i = 0; i < board.length; i++) {
		if (i != col) {
		    board[i][row] ++;
		}
	    }
	    /* for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board.length; j++) {
		    if ( (col - i) || (col + i) && (row + i) || (row - i))
		}
	    }
	    */
	}
	if (num == 1) {
	    for (int i = 0; i <  board.length; i++) {
		if (i != row) {
		    board[col][i] --;
		}
	    }
	    for(int i = 0; i < board.length; i++) {
		if (i != col) {
		    board[i][row] --;
		}
	    }
	    /* for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board.length; j++) {
		    if ( (col - i) || (col + i) && (row + i) || (row - i))
		}
	    }
	    */
	}
    }

    
    /*
    public void countSolutions(){
    }
    
    public int getCount() {
	
    }
    */
    public String toString(){
    	String ans = "";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j <board.length; j++) {
	        if (board[i][j] == -1) {
		    ans += "Q ";
		}
		else {
		    ans += "_ ";
		}
		if (j == board.length - 1) {
		    ans += "\n";
		}
	    }
	}
	return ans;
    }

    public static void main(String[] args) {
	QueenBoard board = new QueenBoard(4);
	System.out.println(board.solve());
	System.out.println(board.toString());
    }
    
}
