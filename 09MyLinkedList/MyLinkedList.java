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
	for (LNode current = start; current.next() != null; end.next()) {
	    answer += "" + current.value() + ", ";
	}
	return answer += "]";
    }
    
    public boolean add(int value) {
	try {
	    if (size == 0) {
		LNode x = new LNode(value);
		start = x;
		end = start;
		size += 1;
	    }else {
		LNode x = new LNode(value);
		end.nextLNode(x);
		end = end.next();
		size += 1;
	    }
	    return true;
	} 
	catch (Exception e){
	    System.out.println("Invalid");
	    return false;
	}
    }

    public int size() {
	return size;
    } 
    
    private class LNode {
	public int value;
	private LNode next, previous;
	
	public LNode (int x) {
	    value = x;
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
