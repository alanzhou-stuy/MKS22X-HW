import java.util.*;
import java.io.*;

public class Quick {

    public static int quickselect(int []data, int k){
	return helper (data,k,0,data.length - 1 );
    }

    public static int helper(int[] data,int k, int start, int end) {
	if ( start == end ){
	    return data[start];
	}
	int temp = part(data,start,end);
	if (temp == k) {
	    return data[temp];
	}
	else if (k < temp) {
	    return helper(data,k,start,temp - 1);
	}
	else {
	    return helper(data,k,temp + 1, end);
	}
	
    }

    /* public static int part ( int [] data, int start, int end){
	int randomPivot = data[(int)(start + Math.random() * (end - start + 1) )];
	//int randomPivot = 0;
	int counter1 = 0;
	int counter = 0 ;
	for (int i = start; i <= end ; i ++) {
	    if (data[i] < randomPivot) {
		//System.out.println(i + ":" + counter1);
		data[counter1] = data[i];
		counter1 += 1;
	    }
	    if (data[i] > randomPivot) {
		int temp = data[data.length  - 1 - counter];
		data[data.length - 1 - counter] = data[i];
		counter += 1;
		data[i] = temp;
		i --;
	    }
	    if (counter  + counter1 == end - start) {
		data[i] = randomPivot; 
		System.out.println("Pivot: " + randomPivot);
		return i;
	    }
	   
	}
	System.out.println("Pivot: " + randomPivot + "\nCounter1: " + counter1);
	return -1;
    }
    */

    public static int part ( int [] data, int start, int end){
	int answer = 0;
	int[] temp = new int[data.length];
	int randomPivot = data[(int)(start + Math.random() * (end - start + 1) )];	
	int counter1 = end;
	int counter = start;
	for (int i = start; i <= end ; i ++) {
	    //if (data[i] == randomPivot) {	
	    //}
	    if (data[i] < randomPivot) {
		temp[counter] = data[i];
		counter ++;
	    }
	    if (data[i] > randomPivot) {
		temp[counter1] = data[i];
		counter1 --;
	    }
	}
	data = temp;
	System.out.println("Pivot: " + randomPivot);
	return answer;
    }

    public static void main(String[] args) {
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(part(ary,0,5) + "\n");
	for (int i = 0; i < 6; i++) {
	    System.out.println(ary[i]);
	}
	/*
	System.out.println(quickselect( ary , 0 ));
	System.out.println(quickselect( ary , 1 ));  
	System.out.println(quickselect( ary , 2 ));  
	System.out.println(quickselect( ary , 3 ));  
	System.out.println(quickselect( ary , 4 ));  
	System.out.println(quickselect( ary , 5 ));  	
	*/
	}
}
