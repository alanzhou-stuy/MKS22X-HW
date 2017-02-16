public class KnightBoard {
    private int[][]board,secBoard;
    private int num = 0;

    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRows][startingCols];

    }
	
    public String toString() {
	String a = new String();
	for (int i = 0; i < board.length; i++ ) {
	    for (int j = 0; j < board[0].length; j++) {
		if (board[i][j] < 9) {
		    board[i][j] += 1;
		    a += " " + board[i][j] + " ";
		}
		else if (board[i][j] >= 9) {
		    board[i][j] += 1;
		    a += "" + board[i][j] + " ";
		}
		if (j == board[0].length - 1) {
		    a += "\n";
		}
	    }
	}
	return a;
    } 


    public boolean solve() {
	return solveH(0,0);
    }

    private boolean solveH(int row ,int col) {
	if (num  == board.length * board[0].length) {
	    return true;
	}
	if (!check(row,col)) {
	    return false;
	}
	if (!(board[row][col] == 0)) {
	    return false;
	}
	else {
	    board[row][col] = num;
	    num += 1;
	    if (solveH(row - 1, col - 2) ||
		solveH(row - 2, col - 1) || 
		solveH(row - 2, col + 1) || 
		solveH(row + 2, col - 1) ||
		solveH(row + 1, col + 2) ||
		solveH(row + 2, col + 1) || 
		solveH(row + 1, col + 2) || 
		solveH(row - 1, col + 2)  ){
		return true;
	    }
	    else {
		num -= 1;
		board[row][col] = 0;
		return false;
	    }
	}
    }

    public boolean check(int row, int col) {
	if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
	    return true;
	}else {
	    return false;
	}
    }

    public static void main(String[] args) {
        KnightBoard board = new KnightBoard(5,5);
	System.out.println(board.solve());
	System.out.println(board);
    }
} 
