public class MyLinkedList {
    LNode start;
    LNode end;
    int size;

    public MyLinkedList() {
	size = 0;
	start = null;
	end = null;
    }

    //not done
    private LNode getNthNode(int index){
	if(index < 0 || index >= size) {
	    throw(new IndexOutOfBoundsException());
	}
	else {
	    LNode p = start;
	    int x = index;
	    while(x > 0){
		p = p.next;
		x--;
	    }
	    return p;
	}
    }
    
    public int set(int index, int value) {
	LNode target = getNthNode(index);
	int ans = target.value;
	target.value = value;
	return ans;
    }

    private void remove(LNode target){
	if (target == start && target == end) {
	    start = null;
	    end = null;
	    size = 0;
	}
	else if (target == start) {
	    target.next.previous = null;
	    target.next = null;
	    start = target.next.previous;
	    size --;
	}
	else if (target == end) {
	    target.previous.next = null;
	    target.previous = null;
	    end = target.previous.next;
	    size --;
	}
	else {
	    //System.out.println(target.previous.next.value);
	    //System.out.println(target.next.value);
	    //System.out.println(target.next.previous.value);
	    // System.out.println(target.previous.value);
	    
	    target.previous.next = target.next;
	    target.next.previous = target.previous;
	    size --;
	}
    }

    public int remove(int index){
	if (index <= 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode temp = start;
	int counter = 0; 
	int answer = 0; 
	while (counter != index) {
	    counter ++;
	    temp = temp.next;
	    }
	answer = temp.value;
	remove(temp);
	size --;
	return answer;
	}

    public String toString() {
	String answer = "[";
	LNode current = start;
	while (current != null) {
	    answer += "" + current.value;
	    if (current.next != null) {
		answer += ", ";
	    }
	    current = current.next;
	}
	return answer += "]";
    }

    public int get(int index) {
	return getNthNode(index).value;
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
	    previous = null;
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
	
	public String toString(){
	    return value+"";
	}


    }
    public static void main(String[] args) {
	MyLinkedList a = new MyLinkedList();
	a.add(3);
	a.add(4);
	a.add(5);
	System.out.println(a.size());
	System.out.println(a.get(2));
	System.out.println(a);
	System.out.println(a.getNthNode(2));
	a.remove(1);
	System.out.print(a);
    }


}
