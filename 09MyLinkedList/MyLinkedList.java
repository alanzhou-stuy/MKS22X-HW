import java.util.*;

public class MyLinkedList implements Iterable<Integer>{
    private LNode start;
    private LNode end;
    private int size;

    public MyLinkedList() {
	size = 0;

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
	return new subClass(this);
    }

    private class subClass implements Iterator <Integer> {
	int index;
	LNode x;
	
	public subClass(MyLinkedList z) {
	    x = z.start;
	    index = 0;
	}

	public boolean hasNext() {
	    return x.next != null;
	}

	public Integer next() {
	    if (index == 0) {
		index ++;
		return x.value;
	    }
	    else {
		if (hasNext()) {
		    x = x.next;
		    index ++;
		    return x.value;
		}
		else {
		    throw new NoSuchElementException();
		}
	    }
	}
	
       

	public void remove() {
	    throw new UnsupportedOperationException();
	}
	
    }

    
    private LNode getNthNode(int index){
	if(index < 0 || index > size - 1) {
	    throw new IndexOutOfBoundsException();
	}
	LNode p = start;
	while (index > 0) {
	    if (index < size()) {
		p = p.next;
		index --;
	    }
	}
	return p;
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
	    end = end.previous;
	    end.next = null;
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
	while (counter < index) {
	    counter ++;
	    temp = temp.next;
	    }
	answer = temp.value;
	remove(temp);
	return answer;
    }
    
    public int indexOf(int value){
	LNode node = start;
	int x = 0;
	while (node.next != null) {
	    if (node.getValue() == value) {
		return x;
	    }
	    node = node.next;
	    x ++;
	}
	if (node.getValue() == value) {
	    return x;
	} 
	return -1;

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

    public void add(int index,int value){
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	}
	else  {
	    LNode new1 = new LNode(value);
	    if (index == 0) {
		if ( size == 0) {
		    start = new1;
		    end = new1;
		    size ++;
		}
		else {
		    new1.next = start;
		    start.previous = new1;
		    start = new1;
		    size ++;
		}
	    }
	    else if (index == size) {
	         end.next = new1;
		 new1.previous = end;
		 end = new1;
		 size ++;
	    }
	    else {
		new1.previous = getNthNode(index - 1);
		new1.next = getNthNode(index);
		getNthNode(index).previous = new1;
		getNthNode(index - 1).next = new1;
		size ++;
	    }
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

    public int set(int index, int val) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	else {
	    getNthNode(index).value = val;
	    return val;
	}
    }
    
    public int size() {
	return size;
    } 
    
    public static void main(String[] args) {
	
	//Testing: constructor, toString, size, add, get, remove
	
	MyLinkedList a= new MyLinkedList();
	System.out.println(a.toString()+"\nSize: "+a.size());//[], size=0
	for(int i=0; i<20; i++){
	    a.add(i);
	    if(a.get(a.size()-1)%2==0)
		a.remove(a.size()-1);
	    //System.out.println(a);//Check if all nums arent odd
	}
	
	System.out.println(a+"\nSize: "+a.size());//odds 0-20 in order, size=10
	
	//Testing: set, indexOf, add(i,v); reinforce others
	for(int i=0; i<10; i++){
	    a.set(i,i*100);
	}
	
	System.out.println(a+"\nSize: "+a.size());//mulitples of 100, size=10
	for(int i=0; i<10; i++){
	    a.set(i,a.indexOf(i*100));
	}
	
        System.out.println(a+"\nSize: "+a.size());//0-9 in order, size=10
	a.remove(1);
	a.add(1,1);
	for(int i=0; i<10; i++){
	    a.add(0,i*-1-1);
	}
	a.add(a.size(),10);
	
	System.out.println(a+"\nSize: "+a.size());//-10-10 in order, size=21
    }
}
