import java.util.*;

public class MazeSolver {
    private Maze board;
    private boolean animate;
    private Frontier f;
    
    public MazeSolver(String filename) {
	this(filename,false);
    }

    public MazeSolver(String filename, boolean a) {
	board = new Maze(filename);
	animate = a;

    }

    public void solve() {
	solve(1);
    }

    public void solve(int x) {
	if(x == 0){
	    f = new StackFrontier();
	}
	else if(x == 1){
	    f = new FrontierQueue();
	}
	else if(x == 2){
	    f = new FrontierPriorityQueue(false);
	}
	else if(x == 3){
	    f = new FrontierPriorityQueue(true);
	}
	f.add(board.getStart());
	while(f.getSize() > 0) {
	    Location current = f.next();
	    board.set(current.getRow(),current.getCol(),'.');
	    for (Location n: getValidNeighbors(current)) {
		if (isEnd(n)) {
		    board.getEnd().setPrev(current);
		    Location c = board.getEnd().getPrevious();
		    while (c != null) {
			c = c.getPrevious();
			board.set(c.getRow(), c.getCol(), '@');
		    }
		    board.set(board.getStart().getRow(),board.getStart().getCol(),'S');
		    board.set(board.getEnd().getRow(),board.getEnd().getCol(),'E');

		    return;
		}
		else {
		    f.add(n);
		    board.set(n.getRow(),n.getCol(),'?');
		}
	    }
	}
	if (animate == true) {
	    System.out.println(board.toString());
	}
    }

    private boolean isEnd(Location current) {
	return (current.getRow() == board.getEnd().getRow() && current.getCol() == board.getEnd().getCol());
    }
    
    private ArrayList<Location> getValidNeighbors(Location current) {
	ArrayList <Location> ans = new ArrayList<Location>();
	int r,c;
	r = current.getRow();
	c = current.getCol();

	Location[] x = {
	    new Location(r - 1,c,current,Location.getDistance(r - 1,c,board.getStart()),Location.getDistance(r - 1,c,board.getEnd()),false),
	    new Location(r + 1,c,current,Location.getDistance(r + 1,c,board.getStart()),Location.getDistance(r + 1,c,board.getEnd()),false),
	    new Location(r,c - 1,current,Location.getDistance(r,c - 1,board.getStart()),Location.getDistance(r,c - 1,board.getEnd()),false),
	    new Location(r,c + 1,current,Location.getDistance(r,c + 1,board.getStart()),Location.getDistance(r,c + 1,board.getEnd()),false)
	};
	
	for (Location i : x) {
	    if (board.inBounds(i) && board.isValid(i)) {
		ans.add(i);
	    }
	}
	return ans;
    }
 
    public String toString() {
	return board.toString();
    }

    public static void main(String[] args){	
	MazeSolver m = new MazeSolver("data0.txt", true);
	m.solve(0);
	System.out.println(m);	
    }
}
