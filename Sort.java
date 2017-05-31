import java.util.*;
import java.io.*;

public class Sort {
    int part ( int [] data, int start, int end){
	int randomPivot = data[(int)(Math.random() * data.length + 1)];
	int[] temp = new int[data.length];
	int index = 0;
	for (int i = start; i == end; i ++) {
	    if (data[i] > randomPivot) {
		temp[end - 1 - i] = data[i];
	    }
	    if (data[i] < randomPivot) {
		temp[start + i] = data[i];
	    }
	    if (i == end) {
		index = i;
	    }
	}
	data = temp;
	return index;
    }
    public static void main(String[] args) {
    }
}
