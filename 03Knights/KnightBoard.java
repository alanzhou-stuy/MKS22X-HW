public class KnightBoard {
    private int[][]board;
    private int tempc, tempr;

    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRows][startingCols];
    }
	
    public String toString() {
	String a = new String();
	for (int i = 0; i < board.length; i++ ) {
	    for (int j = 0; j < board.length; j++) {
		if (board[i][j] < 10) {
		    a += " " + board[i][j];
		}
		else if (board[i][j] >= 10) {
		    a += "" + board[i][j];
		}
		if (j == board.length - 1) {
		    a += "\n";
		}
	    }
	}
	return a;
    } 

    public void solve() {
	solveH(0,0,0);
    }

    private boolean solveH(int row ,int col, int num) {
	if (num == board.length * board[0].length) {
	    return true;
	}
	if ((row == 0) && (col == 0)) {
	    num = 1;
	}			  
	if (board[row][col] == 0) {
	    board[row][col] = num;
	    tempc = 0;
	    tempr = 0;
	    if (check(row,col)) {
		if (solveH(row + tempr,col + tempc,num + 1)) {
		    return true;
		}
	    }
	    board[row][col] = 0;
	}else {
	    return false;
	}
	return false;
    }

    public boolean check(int row, int col) {
	if ((row + 1  < board.length) && (row + 1 >= 0) && (col + 2 < board.length) && (col + 2 >= 0) && (row + 1 == 0) && (col + 2 == 0)) {
	    tempr = 1;
	    tempc = 2;
	    return true;
	}
	else if ((row - 1  < board.length) && (row - 1 >= 0) && (col - 2 < board.length) && (col - 2 >= 0) && (row - 1 == 0) && (col - 2 == 0)) {
	    tempr = -1;
	    tempc = -2;
	    return true;
	}
	else if ((row + 1  < board.length) && (row + 1 >= 0) && (col - 2 < board.length) && (col - 2 >= 0) &&(row + 1 == 0) && (col - 2 == 0)) {
	    tempr = 1;
	    tempc = -2;
	    return true;
	}
	else if ((row - 1  < board.length) && (row - 1 >= 0) && (col + 2 < board.length) && (col + 2 >= 0) && (row - 1 == 0) && (col + 2 == 0)) {
	    tempr = -1;
	    tempc = 2;
	    return true;
	}
	else if ((row - 2  < board.length) && (row - 2 >= 0) && (col + 1 < board.length) && (col + 1 >= 0) && (row - 2 == 0) && (col + 1 == 0)) {
	    tempr = -2;
	    tempc = 1;
	    return true;
	}
	else if ((row + 2  < board.length) && (row + 2 >= 0) && (col + 1 < board.length) && (col + 1 >= 0) && (row + 2 == 0) && (col + 1 == 0)) {
	    tempr = 2;
	    tempc = 1;
	    return true;
	}
	else if ((row - 2  < board.length) && (row - 2 >= 0) && (col - 1 < board.length) && (col - 1 >= 0) && (row - 2 == 0) && (col - 1 == 0)) {
	    tempr = -2;
	    tempc = -1;
	    return true;
	}
	else if ((row + 2  < board.length) && (row + 2 >= 0) && (col - 1< board.length) && (col - 1 >= 0) &&(row + 2 == 0) && (col - 1 == 0)) {
	    tempr = 2;
	    tempc = -1;
	    return true;
	}/*
	if ( ((row + 1 == 0) && (col + 2 == 0)) ||  ((row - 1 == 0) && (col - 2 == 0)) ||  ((row + 1 == 0) && (col - 2 == 0)) ||  ((row - 1 == 0) && (col + 2 == 0)) ||  ((row - 2 == 0) && (col + 1 == 0)) ||  ((row + 2 == 0) && (col + 1 == 0)) || ((row - 2 == 0) && (col - 1 == 0)) || ((row + 2 == 0) && (col - 1 == 0))) {
	    return true;
	}		*/		
	return false;
    }

    public static void main(String[] args) {
        KnightBoard board = new KnightBoard(5,5);
	board.solve();
	System.out.println(board);
    }
} 
