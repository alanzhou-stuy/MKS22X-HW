import java.util.*;

public class MyHeap {
    int[] array;
    int constant;
    int size;

    public MyHeap() {
	array = new int[17];
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
	array = new int[17];
	size = 0;
    }
    
    private void resize() {
	int[] temp = new int[size * 2 + 1];
	for (int i = 1; i < array.length; i++) {
	    temp[i] = array[i];
	}
	array = temp;
    }

    public void add (int s) {
	if (size == array.length) {
	    resize();
	}
	array[size + 1] = s;
	size ++;
	if (size > 1)  {
	    pushUp();
	}
    }

    public int peek() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return array[1];
    }

    private void pushUp() {
	int x = array[size];
	for (int i = size; i > 1; i =  i / 2){
	    if (array[i] * constant >= array[i/2]) {
		    array[i] = array[i/2];
		    array[i/2] = x;
		}
	    else {
		return;
	    } 
	}
    }

    public int remove() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	int temp = array[1];
	array[1] = array[size];
	array[size] = 0;
	size --;
	pushDown();
	return temp;
    }
    private void pushDown() {
	for (int i = 1; i * 2 < size; i = i *2) {
	    int val = array[i];
	    if (array[i * 2] != 0 || array[i * 2 + 1] != 0) {
		if (array[i * 2] * constant >= (array[i * 2 + 1])) {
		    if (val * constant <= (array[i * 2])) {
			array[i] = array[i * 2];
			array[i * 2] = val;
		    }
		    else {
			break;
		    }
		}
		else if (val * constant <= (array[i * 2 + 1])) {
		    array[i] = array[i * 2 + 1];
		    array[i * 2 + 1] = val;
		}
		else {
		    break;
		}
	    }
	    else {
		if (array[i] * constant >= (array[i * 2])) {
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
	test.add(1);
	test.add(2);
	test.add(3);
	test.add(4);
	test.add(5);
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
