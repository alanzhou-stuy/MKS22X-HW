import java.util.*;

public class MyLinkedList <Integer> implements Iterable<Integer>{
    private LNode start;
    private LNode end;
    private int size;

    public MyLinkedList() {
	size = 0;
	start = null;
	end = null;
    }
    
    private class LNode {
	public int value;
	private LNode next, previous;
	
	public LNode (int x) {
	    value = x;
	    next = null;
	    previous = null;
	}

	public int getValue() {
	    return value;
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

    public Iterator<Integer> iterator() {
	return new subClass();
    }

    public class subClass implements Iterator <Integer> {

	public boolean hasNext() {
	    return true;
	}

	public Integer next() {
	    return start.getValue();
	}

	public void remove() {
	    throw new UnsupportedOperationException();
	}
	
    }

    
    private LNode getNthNode(int index){
	if(index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException());
    }
    else {
	    LNode p = start;
	    for (int i = 0; i < index; i++) {
		start = start.next;
	    }
    }
    return ans;
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
	    target.previous.next = target.next;
	    target.next.previous = target.previous;
	    size --;
	}
    }

    public int remove(int index){
	if (index < 0 || index >= size) {
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


    public int indexOf(int value){
	return 1;
    }

    public void add(int index,int value){
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode new1 = new LNode(value);
	if (size == 0) {
	    start = new1;
	    end = new1;
	    size ++;
	}
	else if (index == 0) {
	    new1.next = start;
	    start.previous = new1;
	    start = new1;
	    size ++;
	}
	else if (index == size) {
	    end.next = new1;
	    new1.previous = end;
	    end = new1;
	    size ++;
	}
	else {
	    LNode temp = new LNode(size);
	    int x = 0;
	    while ( x < index) {
		temp = temp.next;
	    }
	    temp.next = new1;
	    new1.previous = temp;
	    new1.next = temp;
	    temp.previous = new1;
	    size ++; 
	}
    }
    
    public boolean add(int x) {
	add(size,x);
	return true;
    }

    private void addAfter(LNode location, LNode toBeAdded) {
	location.previous = toBeAdded;
	location.next = toBeAdded.next;
	toBeAdded.next = location;
	toBeAdded.next.previous = location;
	size++;
    }
    
    public int size() {
	return size;
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
