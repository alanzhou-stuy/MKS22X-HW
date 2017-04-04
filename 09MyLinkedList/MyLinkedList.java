public class MyLinkedList {
    LNode start;
    LNode end;
    int size;

    public MyLinkedList() {
	size = 0;
	start = null;
	end = null;
    }

    public String toString() {
	String answer = "[ ";
	LNode current = start;
	while (current != null) {
	    answer += "" + current.value();
	    if (current.next() != null) {
		answer += ", ";
	    }
	    current = current.next();
	}
	return answer += "]";
    }

    public int get(int index) {
	if(index < 0 || index >= size) {
	    throw(new IndexOutOfBoundsException());
	}
	else {
	    LNode p = start;
	    int x = index;
	    while(x > 0){
		p = p.next();
		x--;
	    }
	    return p.value();
	}
    }
    
    public boolean add(int x) {
	LNode temp = new LNode(x);
	if (start == null && end == null) {
	    start = temp;
	    end = temp;
	    size ++;
	}
	else {
	    end.nextLNode(temp);
	    end = temp;
	    size ++;
	}
	return true;
    }


    public int size() {
	return size;
    } 
    
    private class LNode {
	public int value;
	private LNode next, previous;
	
	public LNode (int x) {
	    value = x;
	    next = null;
	}
	
	public LNode(int x, LNode y) {
	    value = x;
	    next = y;
	}
	
	public void nextLNode(LNode x) {
	    next = x;
	}

	public void previousLNode(LNode x) {
	    previous = x;
	}
	
	public LNode next() {
	    return next;
	}

	public LNode previous() {
	    return previous;
	}

	public int value() {
	    return value;
	}


    }


}
