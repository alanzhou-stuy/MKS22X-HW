import java.util.*;

public class StackFrontier implements Frontier {
    private Stack<Location> s;
    private int size;
    
    public StackFrontier() {
	s = new Stack<Location>();
    }
    
    public void add (Location l) {
	size ++;
	s.push(l);
    }

    public Location next() {
	size --;
	return s.pop();
    }
    
    public int getSize() {
	return size;
    }


}
