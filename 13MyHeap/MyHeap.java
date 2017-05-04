import java.util.*;

public class MyHeap {
    String[] array;
    int constant;
    int size;

    public MyHeap() {
	array = new String[17];
	size = 0;
    }

    public MyHeap(boolean x) {
	if (x) {
	    constant = 1; 
	}
	else {
	    constant = -1;
	}
	array = new String[17];
	size = 0;
    }
    
    private void resize() {
	String[] temp = new String[size * 2 + 1];
	for (int i = 1; i < array.length; i++) {
	    temp[i] = array[i];
	}
	array = temp;
    }

    public void add (String s) {
	if (size == array.length) {
	    resize();
	}
	array[size + 1] = s;
	size ++;
	if (size > 1)  {
	    pushUp();
	}
    }

    public String remove() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	String temp = array[1];
	array[1] = array[size];
	array[size] = null;
	pushDown();
	size --;
	return temp;
    }

    public String peek() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return array[1];
    }

    private void pushUp() {
	String x = array[size];
	for (int i = size; i > 1; i =  i / 2){
	    if (array[i].compareTo(array[i/2]) * constant >= 0) {
		    array[i] = array[i/2];
		    array[i/2] = x;
		}
	    else {
		return;
	    } 
	}
    }

    private void pushDown() {
	for (int i = 1; i < size; i = i *2) {
	    if (array[i].compareTo(array[i + 1]) * constant >= 0) {
		array[i / 2] = array[i];
	    }
	    else {
		array[i / 2] = array[i + 1];
	    }
	}
    }
    
    public String toString() {
	String temp = "";
	for (int i = 1; i <= size; i ++) {
	    temp += " " + array[i];
	}
	return temp;
    }

    public static void main(String[] args) {
	MyHeap test = new MyHeap(true);
	test.add("A ");
	test.add("B ");
	test.add("C ");
	test.add("D ");
	test.add("E ");
	test.add("F ");
	test.add("G ");
	test.add("H ");
	test.remove();
	System.out.println(test);
    }
    
}
