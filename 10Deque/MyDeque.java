public class MyDeque {
    private int front;
    private int end;
    private String[] array;
    
    public MyDeque (int size) {
	array = new String[size];
	front = 0;
	end = 0;
    }

    public void addFirst(String str) {
	if (front == 0) {
	    if (end != array.size) {
		
	    }
	    else {
		String[] temp =  new String[size * 2];
		for (int i = 0; i < temp.size; i ++ ){
		    temp[i] = array[i];
		}
		array = temp;
	    }
	}
    }

    public void addLast(String str) {

    }

    public String removeFirst(){

    }

    public String removeLast() {

    }

    public String getFirst() {

    }

    public String getLast() {

    }



}
