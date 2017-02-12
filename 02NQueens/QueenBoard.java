public class QueenBoard{
    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    public void solve() {
	solveH(0);
    }

    private boolean solveH(int col){
	if (col == board.length) {
	    return true;
	}
	for (int i = 0; i < board.length; i++) {
	    if (board[col][i] == 0) {
		placeQueen(col,i);
		return solveH(col + 1);
	    }
	    if((i != 0) && (board[col][i] != 0)) {
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
	    for (int i = 0; i == board.length; i++) {
		if (i != row) {
		    board[col][i] ++;
		}
	    }
	    for(int i = 0; i == board.length; i++) {
		if (i != col) {
		    board[i][row] ++;
		}
	    }
	}
    }

    
    /*
    public void countSolutions(){
    }
    
    public int getCount() {
	
    }
    */
    public String toString(){
    	return "";
    }


}
