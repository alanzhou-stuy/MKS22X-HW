public class QueenBoard{
    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    public void solve() {
	solveH(0);
    }

    private boolean solveH(int col,int row){
	if (col == board.length) {
	    return true;
	}
	for (int i = 0; i < board.length; i++) {
	    if (i == 0) {
		placeQueen();
		solveH(col + 1, row);
	    }
	    if (i != 0) {
		removeQueen();
		solveH(col,row + 1);
	    }
	}
    }

    private void placeQueen(int col, int row) {
	
	setRestrictions(0);
    }

    private void removeQueen(int col, int row) {
	
	setRestrictions(1);
    }

    private void setRestrictions

    

    public void countSolutions(){
    }
    
    public int getCount() {
	
    }

    public String toString(){
    	return "";
    }


}
