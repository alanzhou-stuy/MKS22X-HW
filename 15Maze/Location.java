public class Location implements Comparable<Location>{
    private int row,col;
    private int distToGoal;
    private int distToStart;
    private Location previous;
    private boolean aStar;
    
    public Location(int r, int c, Location previous1, int distToStart1, int distToGoal1, boolean aStar1) {
	row = r;
	col = c;
	previous = previous1;
	distToStart = distToStart1;
	distToGoal = distToGoal1;
	aStar = aStar1;
    }

    public int getDistToStart() {
	return distToStart;
    }

    public int getDistToGoal() {
	return distToGoal;
    }

    public int getRow() {
	return row;
    }

    public int getCol() {
	return col;
    }

    public boolean getAStart() {
	return aStar;
    }
    
    public int compareTo(Location other) {
	if (aStar) {
	    if (distToStart + distToGoal == other.getDistToStart() + getDistToGoal()) {
		return 0;
	    }
	    else if (distToStart + distToGoal > other.getDistToStart() + getDistToGoal()) {
		return 1;
	    }
	    else  {
		return -1;
	    }
	}
	else {
	    if (distToGoal == other.getDistToGoal()) {
		return 0;
	    }
	    else if (distToGoal > other.getDistToGoal()) {
		return 1;
	    }
	    else {
		return -1;
	    }
	}
    }
}
