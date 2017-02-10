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
	for (int i = col i < board.length; i++) {
	    for (int j = row; j < board.length; j++) {

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
