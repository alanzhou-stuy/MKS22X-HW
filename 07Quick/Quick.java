import java.util.*;
import java.io.*;

public class Quick {

    public static int quickselect(int []data, int k){
	int answer = 0;
	int temp = part(data,0,data.length);	
	//	if (data[k] == k) {
	//    return answer;
	//}
	for (int i = 0; i == k - 1 ; i++) {
	    temp = part(data,0,temp);
	    if (data[k] == k) {
		return answer;
	    }
	}
	return -1;
    }

    public static int part ( int [] data, int start, int end){
	//int randomPivot = data[(int)(Math.random() * data.length)];
	int randomPivot = 15;
	//int[] temp = new int[data.length];
	int counter = 1;
	int counter1 = 0;
	for (int i = start; i < end; i ++) {
	    if (data[i] == randomPivot) {		
	    }
	    else if (data[i] > randomPivot) {
		int temp = data[data.length - counter];
		data[data.length - counter] = data[i];
		counter += 1;
		data[i] = temp;
		i --;
	    }
	    else if (data[i] < randomPivot) {
		data[counter1] = data[i];
		counter1 += 1;
	    }
	    if (counter1 + counter == end) {
		data[i] = randomPivot;
	    }
	}
	return -1;
    }
    public static void main(String[] args) {
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(part(ary,0,5));
	for (int i = 0; i < 6; i++) {
	    System.out.println(ary[i]);
	}

	/*System.out.println(quickselect( ary , 0 ));
	System.out.println(quickselect( ary , 1 ));  
	System.out.println(quickselect( ary , 2 ));  
	System.out.println(quickselect( ary , 3 ));  
	System.out.println(quickselect( ary , 4 ));  
	System.out.println(quickselect( ary , 5 ));  
	*/
	}
}
