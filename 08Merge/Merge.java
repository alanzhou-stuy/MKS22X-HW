public class Merge {

    public static void mergeSort(int[]ary) {
	if (true){
	}
	else {
	    int[]left = copy of the left side;
	    int[]right = copy of the right side;
	    merge(left);
	    merge(right);
	    mergeTheTwoHalvesIntoTheOriginalArray;
	}
    }
   
    public static void merge (int[]a,int[]b,int[]destination) {
	int indexA = 0;
	int indexB = 0;
	for (int counter = 0; counter < a.length + b.length; counter ++) {     
	    if (indexA == a.length) {
		destination[counter] = b[indexB];
		indexB ++;
	    }
	    else if (indexB == b.length) {
		destination[counter] = a[indexA];
		indexA ++;
	    }
	    else {
		if (a[indexA] <=  b[indexB]) {
		    destination[counter] = a[indexA];
		    indexA += 1;
		}
		else {
		    destination[counter] = b[indexB];
		    indexB += 1;
		}
	    }
	}
    } 
	
    public static void main(String[] args) {
	int[] ary1 = {1,3,5,7};
	int[] ary2 = {2,4,6,8,10};
	int[] ary3 = {0,0,0,0,0,0,0,0,0};
	merge(ary1,ary2,ary3);
	for (int i = 0; i < ary3.length; i ++ ){
	    System.out.println(ary3[i]);
	}

    }

}
