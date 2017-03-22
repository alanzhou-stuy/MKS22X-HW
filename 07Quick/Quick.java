import java.util.*;
import java.io.*;

public class Quick {

    public static void swap (int[] data, int first, int second) {
	int temp = data[first];
	data[first] = data[second];
	data[second] = temp;
    }
    
    public static int quickselectSlow(int []data, int k){
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

    /*public static int part ( int [] data, int start, int end){
	int randomPivot = data[(int)(start + Math.random() * (end - start + 1) )];
	//int randomPivot = 0;
	int counter1 = start;
	int counter = end;
	for (int i = start; i <= end ; i ++) {
	    if (data[i] < randomPivot) {
		//System.out.println(i + ":" + counter1);
		data[counter1] = data[i];
		counter1 += 1;
	    }
	    if (data[i] > randomPivot) {
		int temp = data[counter];
		data[counter] = data[i];
		counter -= 1;
		data[i] = temp;
		i --;
	    }
	    if (counter + (end - counter1) == end) {
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
	    if (counter + (end - counter1) == end) {
		temp[counter] = randomPivot;
		for (int j = start; j <= end; j++) {
		    data[j] = temp[j];
		}
		answer = counter;
	    }		    
	}
	//System.out.println("Pivot: " + randomPivot);
	return answer;
    }
    
    public static void quickSortH( int [] data, int start, int end){
	if ( end <= start + 1) {
	}
	else {
	int i = start;
	int lt = start;
	int gt = end;
	int v1 = (int)(lt + Math.random() * (gt - lt + 1) );
	int v = data[v1];
	swap(data,start,v1);
	while (i <= gt) {
	    if (data[i] < v) {
		swap(data,i,lt);
		lt++;
		i++;
	    }
	    else if (data[i] > v) {
		swap(data,i,gt);
		gt--;
	    }
	    else {
		i++;
	    }
	}
	quickSortH(data,gt,end);
	quickSortH(data,start,lt);
	}
    }

    public static void quickSort(int[] data){
	quickSortH(data,0,data.length - 1);
    }

    public static int quickSelectH (int[]data, int start, int end, int k) {
	if (data[start] == k) {
	    return data[k];
	}
	else {
	int i = start;
	int lt = start;
	int gt = end;
	int v1 = (int)(lt + Math.random() * (gt - lt + 1) );
	int v = data[v1];
	swap(data,start,v1);
	while (i <= gt) {
	    if (data[i] < v) {
		swap(data,i,lt);
		lt++;
		i++;
	    }
	    else if (data[i] > v) {
		swap(data,i,gt);
		gt--;
	    }
	    else {
		i++;
	    }
	}
	if (k > v) {
	    quickSelectH(data,gt,end,k);
	}
	if (k < v) {
	    quickSelectH(data,start,lt,k);
	}
	}
	return -1;
    }

    public static int quickSelect(int[]a,int k) {
	return quickSelectH(a,0,a.length - 1, k);
    }
    
    public static void main(String[] args) {
	int[]ary = { 2, 10, 15, 23, 0,  5};
	int[]ary1 = {999,999,999,4,1,0,3,2,999,999,999};
	int[]ary2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	//System.out.println(part(ary,0,5) + "\n");
	//System.out.println(part(ary1,3,7) + "\n");
	//	for (int i = 0; i < ary.length;i++) {
	//    System.out.println(ary[i]);
	//}
	
	//System.out.println(quickselect( ary , 0 ));
	//System.out.println(quickselect( ary , 1 ));  
	//System.out.println(quickselect( ary , 2 ));  
	//System.out.println(quickselect( ary , 3 ));  
	//System.out.println(quickselect( ary , 4 ));  
	//System.out.println(quickselect( ary , 5 ));  	
	//quickSort(ary2);
	System.out.println(quickSelect(ary,1));
	//for (int i = 0; i < ary.length;i++) {
	//    System.out.println(ary2[i]);
	//}
	}
}
