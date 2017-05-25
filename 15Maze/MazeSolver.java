import java.util.*;

public class MazeSolver {
    private Maze board;
    private boolean animate;
    private Frontier f;
    private int x1;
    
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
	x1 = x;
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
	    board.getStart().setAStar(true);
	    board.getEnd().setAStar(true);
	}
	f.add(board.getStart());
	while(f.getSize() > 0) {
	    Location current = f.next();
	    board.set(current.getRow(),current.getCol(),'.');
	    for (Location n: getValidNeighbors(current)) {
		//System.out.println(n.getAStar());
		//System.out.println(n.getDistToGoal() + n.getDistToStart());
		if (isEnd(n)) {
		    board.getEnd().setPrev(current);
		    Location c = board.getEnd().getPrevious();
		    int x12 = 0;
		    while (c != null) {
			x12 ++;
			board.set(c.getRow(), c.getCol(), '@');
			c = c.getPrevious();
			if(animate){
			    System.out.println(board.toString(30));
			}
		    }
		    board.set(board.getStart().getRow(),board.getStart().getCol(),'S');
		    board.set(board.getEnd().getRow(),board.getEnd().getCol(),'E');
		    //System.out.println("number of steps: " + x12);
		    return;
		}
		else {
		    if(x == 3){
			n.setAStar(true);
		    }
		    f.add(n);
		    board.set(n.getRow(),n.getCol(),'?');
		}
		
	    }
	    if(animate){
		System.out.println(board.toString(15));
	    }
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

	boolean b = true;
	if (x1 == 2) {
	    b = false;
	}

	Location[] x = {
	    new Location(r - 1,c,current,Location.getDistance(r - 1,c,board.getStart()),Location.getDistance(r - 1,c,board.getEnd()),b),
	    new Location(r + 1,c,current,Location.getDistance(r + 1,c,board.getStart()),Location.getDistance(r + 1,c,board.getEnd()),b),
	    new Location(r,c - 1,current,Location.getDistance(r,c - 1,board.getStart()),Location.getDistance(r,c - 1,board.getEnd()),b),
	    new Location(r,c + 1,current,Location.getDistance(r,c + 1,board.getStart()),Location.getDistance(r,c + 1,board.getEnd()),b)
	};
	
	for (Location i : x) {
	    if (board.get(i.getRow(),i.getCol()) == ' ' || board.get(i.getRow(),i.getCol()) == 'E') {
		ans.add(i);
	    }
	}
	return ans;
    }
 
    public String toString() {
	return board.toString();
    }

    public static void main(String[] args){	
	MazeSolver m = new MazeSolver("data5.txt", false);
	m.solve(3);
	System.out.println(m);	
    }
}
