import java.util.*;

public class MyDeque {
    private int front;
    private int end;
    private String[] array;
    private int size;
    
    public MyDeque (int size) {
	array = new String[size];
	front = 0;
	end = 0;
	size = 0;
    }

    public MyDeque () {
	array = new String[10];
	front = 0;
	end = 0;
	size = 0;
    }

    public void addFirst(String str) {
	if (str == null) {
	    throw new NullPointerException();
	}
	else {
	    if (size == array.length) {
		String[] temp =  new String[size * 2];
		int x = front;
		int y = 0;
		while (x != end) {
		    array[y] = array[x];
		    x = (x + 1) % array.length;
		    y ++;
		}
		temp[y] = array[end];
		front = 0;
		end = y;
		array = temp;
	    }
	    if (size != 0) {
		if (front != 0) {
		    front =  front - 1;
		}
		else {
		    front = array.length - 1;
		}
	    }
	    array[front] = str;
	    size ++;
	}
    }

    public void addLast(String str) {
	if ( str == null) {
	    throw new NullPointerException();
	}
	else {
	    if (size != 0) {
		end = (end + 1) % array.length;
	    }
	    if (size == array.length) {
		String[] temp =  new String[size * 2];
		int x = front;
		int y = 0;
		while (x != end) {
		    array[y] = array[x];
		    x = (x + 1) % array.length;
		    y ++;
		}
		temp[y] = array[end];
		front = 0;
		end = y;
		array = temp;
	    }
	    array[end] = str;
	    size ++;
	}
    }

    public String removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	
	String ans = array[front];
	front = (front + 1 ) % array.length;
	size --;
	return ans;
    }

    public String removeLast() {
	if(size == 0){
	    throw new NoSuchElementException();
	    
	}
	
	String ans = array[end];
	end = (array.length + end - 1)% array.length;
	size --;
	return ans;
    }

    public String getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	else {
	    return array[front];
	}

    }

    public String getLast() {
	if(size == 0){
	    throw new NoSuchElementException();
	} else{
	    return array[end];
	}
    }

    public static void main(String[]args){
	MyDeque test = new MyDeque();
	test.addFirst("10");
	test.addLast("20");
	System.out.println(test.getFirst());
	test.removeFirst();
	test.removeLast();
	//System.out.println(test.getFirst());	
    }

}
