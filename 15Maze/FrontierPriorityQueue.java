import java.util.*;

public class FrontierPriorityQueue implements Frontier{
    private MyHeap heap;
    private boolean aStar;

    public FrontierPriorityQueue() {
	this(true);
    }

    public FrontierPriorityQueue(boolean aStar1) {
	heap = new MyHeap(aStar1);
	aStar = aStar1;
    }
    
    public Location next(){
        return heap.next();
    }
    
    public void add(Location l){
	if(aStar){
	    l.setAStar(true);
	    heap.add(l);
	} 
	else {
	    l.setAStar(false);
	    heap.add(l);	
	}
    }

    public int getSize(){
	return heap.getSize();
    }


}

