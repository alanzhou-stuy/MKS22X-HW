import java.util.*;

public class FrontierQueue implements Frontier {
    private LinkedList<Location> list;
    private int size;

    public FrontierQueue() {
	list = new LinkedList<Location>();
    }

    public void add(Location l) {
	list.add(l);
	size ++;
    }
    
    public Location next() {
	size --;
	return list.removeFirst();
    }
    

    public int getSize() {
	return size;
    }
    
}
