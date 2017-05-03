public class MyHeap() {
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

    public void add (String s) {
	array[size + 1] = s;
	size ++;
	pushUp();
    }

    public String remove() {
	size --;
	array[1];
    }

    public String peek() {
	return array[1];
    }

    private void pushUp() {

    }

    private void pushDown() {

    }
}
