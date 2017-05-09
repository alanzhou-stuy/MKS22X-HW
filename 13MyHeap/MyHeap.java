import java.util.*;

public class MyHeap {
    String[] array;
    int constant;
    int size;

    public MyHeap() {
	array = new String[17];
	size = 0;
	constant = 1;
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

    public String remove() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	String temp = array[1];
	array[1] = array[size];
	array[size] = null;
	size --;
	pushDown();
	return temp;
    }
    private void pushDown() {
	for (int i = 1; i * 2 < size; i = i *2) {
	    String val = array[i];
	    if (array[i * 2] != null || array[i * 2 + 1] != null) {
		if (array[i * 2].compareTo(array[i * 2 + 1]) * constant >= 0) {
		    if (val.compareTo(array[i * 2]) * constant <= 0) {
			array[i] = array[i * 2];
			array[i * 2] = val;
		    }
		    else {
			break;
		    }
		}
		else if (val.compareTo(array[i * 2 + 1]) * constant <= 0) {
		    array[i] = array[i * 2 + 1];
		    array[i * 2 + 1] = val;
		}
		else {
		    break;
		}
	    }
	    else {
		if (array[i].compareTo(array[i * 2]) * constant >= 0) {
			array[i] = array[i * 2];
			array[i * 2 ] = val;
		    }
		else {
		    break;
		}
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
	test.add("a ");
	test.add("b ");
	test.add("c ");
	test.add("d ");
	test.add("e ");
	System.out.println(test);
	test.remove();
	System.out.println(test);
	test.remove();
	System.out.println(test);
	test.remove();
	System.out.println(test);
	test.remove();
	System.out.println(test);
	test.remove();
	System.out.println(test);
    }
    
}
