import java.util.*;

public class RunningMedian{
    int size;
    MyHeap min;
    MyHeap max;
    
    public RunningMedian() {
	min = new MyHeap(true);
	max = new MyHeap(false);
	size = 0;
    }

    public void add(int x) {
	if (size == 0) {
	    min.add(x);
	    size ++;
	}
	else if (x < getMedian()) {
	    min.add(x);
	    size ++;
	    if (min.size - max.size > 1) {
		max.add(min.remove());
	    }
	}
	else {
	    max.add(x);
	    size ++;
	    if (max.size - min.size > 1) {
		min.add(max.remove());
	    }
	}
    }

    public double getMedian() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	else if (min.size - max.size == 1) {
	    return min.peek();
	}
	else if (max.size - min.size == 1) {
	    return max.peek();
	}
	else {
	    return (min.peek() + max.peek()) / 2.0;
	}
    }

    public static void main(String[]args) {
	RunningMedian test = new RunningMedian();
	test.add(7);
	System.out.println(test.getMedian());
	test.add(701);
	System.out.println(test.getMedian());
	test.add(71);
	test.add(72);
	test.add(73);
	test.add(17);
	test.add(799);
	System.out.println(test.getMedian());
    }
}
