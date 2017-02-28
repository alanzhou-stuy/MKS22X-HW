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
	solutionCount = -1;
    }

    public void solve() {
	solveH(0,false);
    }

    private boolean solveH(int col,boolean counting){
	if (col == board.length) {
	    if (counting) {
		solutionCount += 1;
		return false;
	    }else {
		return true;
	    }
	}
	for (int i = 0; i < board.length; i++) {
	    if (board[col][i] == 0) {
		placeQueen(col,i);
		if (solveH(col + 1,counting)) {
		    if (!counting) {
			return true;
		    }
		    else {
			solutionCount += 1;
			return false;
			}
		}else {
		removeQueen(col,i);
		}
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
	    board[col][row] = -1;
	    for(int i = 0; i < board.length; i++) {
		if (i != col) {
		    board[i][row] += 1; 
		}
		if ((i != col) && (i - col + row >= 0) && (i - col + row < board.length)) {
		    board[i][i - col + row] += 1;
		}
		if ((i != col) && ((-1 * i) + col + row >= 0) && ((-1 * i) + col + row < board.length)) {
		    board[i][(-1 * i) + col + row] += 1;
		}
	    }
	}
	if (num == 1) {
	    board[col][row] += 1;
	    for(int i = 0; i < board.length; i++) {
		if (i != col) {
		    board[i][row] -= 1;
		}
		if ((i != col) && (i - col + row >= 0) && (i - col + row < board.length)) {
		    board[i][i - col + row] -= 1;
		}
		if ((i != col) &&  ((-1 * i) + col + row >= 0) && ((-1 * i) + col + row < board.length)) {
		    board[i][(-1 * i) + col + row] -= 1;
		}
	    }
	}
    }

    
    
    public int getSolutionCount(){
	return solutionCount;
    }

    public void countSolutions() {
	board = new int[board.length][board.length];
	solutionCount += 1;
	solveH(0,true);
    }
    
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
	QueenBoard board = new QueenBoard(10);
	
        board.solve();
	System.out.println(board);
	board.countSolutions();
	System.out.println(board.getSolutionCount());

    }
}
