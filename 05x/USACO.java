import java.util.*;
import java.io.*;

public class USACO {
    private int[][] lake;
    private int R,C,E,N,R_s,C_s,D_s;

    private int [][] field;
    private int N1,M1,time,R1,C1,R2,C2;

    /*public int bronze(String filename) {
	File text = new File(filename);
	Scanner scan = new Scanner(text);
	R = scan.nextInt();
	C = scan.nextInt();
	E = scan.nextInt();
	N = scan.nextInt();
	int counter = 1;
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

	}
	

	
    }
*/


    public int silver(String filename) {
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
    }


   
    
    public static void main(String[]args) {

    }
}






