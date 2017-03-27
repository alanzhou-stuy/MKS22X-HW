public class Merge {

     public static void mergeSort(int[]ary){
	if (ary.length == 1){
	    return;
	}
	else{	    
	    int[] left = new int[ary.length / 2];
	    int[] right = new int[ary.length - ary.length / 2];
	    for (int i = 0; i < ary.length / 2; i++){
		left[i] = ary[i];
	    }
	    for (int i = ary.length / 2; i < ary.length; i++){
		right [i - ary.length / 2] = ary[i];
	    }
	    mergeSort(left);
	    mergeSort(right);
	    merge(left,right,ary);
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
	int[] ary4 = {3,5,1,2,4,6,8,1,2,34,5676,45,4,4,22,11001010};
	merge(ary1,ary2,ary3);
	for (int i = 0; i < ary3.length; i ++ ){
	    System.out.println(ary3[i]);
	}
	System.out.println("\n");	
	mergeSort(ary4);
	for (int i = 0; i < ary4.length; i ++ ){
	    System.out.println(ary4[i]);
	}

    }

}
