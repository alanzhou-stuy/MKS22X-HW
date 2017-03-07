import java.util.*;
import java.io.*;

public class USACO {
    private int[][] lake;
    private int R,C,E,N,R_s,C_s,D_s;

    private int [][] field;
    private int N1,M1,time,R1,C1,R2,C2;


    public USACO(){
    }


    public int bronze(String filename) {
	try {
	    File text = new File(filename);
	    Scanner scan = new Scanner(text);
	    R = scan.nextInt();
	    C = scan.nextInt();
	    E = scan.nextInt();
	    N = scan.nextInt();
	    lake = new int[R][C];
	    for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
		    lake[i][j] = scan.nextInt();
		}	   
	    }
	    for (int y = 0; y < N; y++) {
		R_s = scan.nextInt();
		C_s = scan.nextInt();
		D_s = scan.nextInt();
		int large = returnLargest(R_s,C_s,lake);
		stomp(R_s,C_s,lake,large,D_s);
	    }	
	    return volume(E,lake);
	}
	catch(FileNotFoundException e) {
	    System.out.println("File not found.");
	    System.exit(0);
	}
	return 0;
    }

    private int returnLargest(int row,int col, int[][] lake) {
	int answer = 0;
	for (int i = row - 1; i < row + 2; i ++ ){
	    for (int j = col - 1; j < col + 2; j++) {
		if (lake[i][j] >= answer) {
		    answer = lake[i][j];
		}
	    }
	}
	return answer;
    }

    private void stomp(int row, int col, int[][] lake, int largestNum, int subtract) {
	largestNum -= subtract;
	for (int i = row - 1; i < row + 2; i ++ ){
	    for (int j = col - 1; j < col + 2; j++) {
		if (lake[i][j] > largestNum) {
		    lake[i][j] = largestNum;
		    }
	    }
	}
    }

    private int volume(int num, int[][] lake){
	int answer = 0;
	for (int i = 0; i < lake.length; i++) {
	    for (int j = 0; j <lake[0].length; j++) {
		if (num - lake[i][j] > 0) {
		    answer += num - lake[i][j];
		}else{
		}
	    }
	}
	return answer * 72 * 72;
    }

    
	    
	/*int counter = 1;
	while(scan.hasNextLine()) {
	    if (counter == 1) {
		String store = scan.nextLine();
		R = store.substring(0,store.indexOf(" ") + 1);
		store = store.substring(store.indexOf(" ") + 1);
		C = store.substring(0,store.indexOf(" ") + 1);
		store = store.substring(store.indexOf(" ") + 1);
		E = store.substring(0,store.indexOf(" ") + 1);
	        store = store.substring(store.indexOf(" ") + 1);
		N = store.substring(0,store.indexOf(" ") + 1);
	    }
	    if (counter > 1 && counter <= R + 1) {
		String store1 = scan.nextLine();
		

	    }
	    counter += 1;

	    }*/

    /*public int silver(String filename) {
	int solution = 0;
	try {
	    File text = new File(filename);
	    Scanner scan = new Scanner(text);
	    N1 = scan.nextInt();
	    M1 = scan.nextInt();
	    time = scan.nextInt();
	    field = new int[N1][M1];
	    for (int i = 0; i < N1; i++) {
		String x = scan.next();
		for (int j = 0; j < M1; j++) {
	        if (x.charAt(j) == '.') {
		    field[i][j] = 0;
		}
		if (x.charAt(j) == '*') {
		    field[i][j] = 1;
		}
		}	   
	    }
	    R1 = scan.nextInt();
	    C1 = scan.nextInt();
	    R2 = scan.nextInt();
	    C2 = scan.nextInt();
	   


	    return solution;
	}
	catch(FileNotFoundException j) {
	    System.out.println("No file found.");
	}
	}*/


   
    
    public static void main(String[]args) {
	USACO x = new USACO(); //does not have to do anything. 
	System.out.println(x.bronze("test1.java"));
    }
}






