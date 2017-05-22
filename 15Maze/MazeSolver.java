import java.util.*;

public class MazeSolver {
    private Maze board;
    private boolean animate;
    private aStar;
    private Location e;
    private int row, col;
    
    public MazeSolver(String filename) {
	this(filename);
	aStar = false;
    }

    public MazeSolver(String filename, boolean animate) {
	this(filename);
	this(animate);
	astar = false;

    }

    public void solve() {
	solve(1);
    }

    public void solve(int a) {
	Frontier f;
	row = board.getRow();
	col = board.getCol();
	if(x == 0){
	    f = new FrontierStack();
	}
	else if(x == 1){
	    f = new FrontierQueue();
	}
	else if(x == 2){
	    f = new FrontierPriorityQueue();
	}
	else if(x == 3){
	    f = new FrontierPriorityQueue();
	    astar = true;
	}
	e = board.getEnd();
	f.add(board.getStart());
	go();
    }

    public String toString() {
    
    }

    
}
