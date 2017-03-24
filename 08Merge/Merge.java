public class Merge {

    public static void mergeSort(int[]ary) {
	if (true){
	}
	else {
	    int[]left = copy of the left side;
	    int[]right = copy of the right side;
	    mergesort(left);
	    mergesort(right);
	    mergeTheTwoHalvesIntoTheOriginalArray;
	}
    }

    /*
    Postcondition:
    destination contains all of the elements of a and b, and is sorted. 
    Preconditions:
    a is sorted, b is sorted
    destination.length == a.length + b.length
    */
    public static void merge (int[]a,int[]b,int[]destination) {
	int indexA = 0;
	int indexB = 0;
	if (indexA == a.length) {
	    for (int b1 = 0; b < b.length - indexB; b1++) {
		destination[indexA + indexB + b1] = b[indexB];
	    }
	}
	else if (indexB == b.length) {
	    for (int a1 = 0; a < a.length - indexA; a1++) {
		destination[indexA + indexB + a1] = a[indexA];
	    }
	}
	else {
	    if (a[indexA] > b[indexB]) 
	    
	}
	
    }

}
