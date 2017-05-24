import java.util.*;

public class FrontierPriorityQueue implements Frontier{
    private MyHeap heap;
    private boolean aStar;

    public FrontierPriorityQueue() {
	heap = new MyHeap();
    }

    public FrontierPriorityQueue(boolean aStar1) {
	heap = new MyHeap(true);
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

