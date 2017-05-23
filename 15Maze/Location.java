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

    public Location getPrevious() {
	return previous;
    }
    
    public void setPrev(Location prev) {
	previous = prev;
    }

    public int getDistToStart() {
	return distToStart;
    }

    public int getDistToGoal() {
	return distToGoal;
    }
    
    public static int getDistance(int row, int col, Location next){
	return Math.abs(row - next.getRow()) + Math.abs(col - next.getCol());
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
	if(aStar){
	    return (distToStart + distToGoal) - (other.distToStart + other.distToGoal);
	} else {
	    return (distToGoal) - (other.distToGoal);
	}
    }
}
