import java.util.*;
import java.io.*;

public class USACO {
    private int[][] lake;
    private int R,C,E,N,R_s,C_s,D_s;

    private int [][] field,field1;
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

    public int silver(String filename) {
	int solution = 0;
	try {
	    File text = new File(filename);
	    Scanner scan = new Scanner(text);
	    // Scanner scan1 = new Scanner(scan.nextLine());
	    N1 = scan.nextInt();
	    M1 = scan.nextInt();
	    time = scan.nextInt();
	    field = new int[N1][M1];
	    field1 = new int[N1][M1];
	    for (int i = 0; i < N1; i++) {
		String x = scan.next();
		for (int j = 0; j < M1; j++) {
	        if (x.charAt(j) == '.') {
		    field[i][j] = 0;
		    field1[i][j] = 0;
		}
	        else{
		    field[i][j] = -1;
		    field1[i][j] = -1;
		}
		}	   
	    }
	    //Scanner scan2 = new Scanner(scan.nextLine());
	    R1 = scan.nextInt() - 1;
	    C1 = scan.nextInt() - 1;
	    //System.out.println(R1 + " " + C1);
	    field[R1][C1] = 1;
	    R2 = scan.nextInt() - 1;
	    C2 = scan.nextInt() - 1;
	    for(int i = 0; i < time; i++){
		if( i % 2 == 1){
		    for (int r = 0; r < N1; r++){
			for(int c = 0; c < M1; c++){
			    if (field1[r][c] > 0){
				helper(r,c,field,field1[r][c]);
				field1[r][c] = 0;
			    }
			}
		    }
		}
		else{
		    for(int r = 0; r < N1; r++){
			for(int c = 0; c < M1; c++){
			    if(field[r][c] > 0){
			        helper(r,c,field1,field[r][c]);
				field[r][c] = 0;
			    }
			}
		    }
		}
	    }
	    /*for (int i = 0; i < N1; i++) {
		for (int j = 0; j < M1; j++) {
		    System.out.print(field[i][j] + " ");
		}
		System.out.println();
		}*/
	    solution = field[R2][C2] + field1[R2][C2];
	    return solution; 
	}
	catch(FileNotFoundException j) {
	    System.out.println("File not found.");
	    System.exit(0);
	}
	return 0 ;
	}

    public static void helper(int r, int c, int[][] field,int n) {
	if (field[r][c] != -1) {
	    if (r > 0) {
		field[r-1][c] += n;
	    }
	    if (c > 0) {
		field[r][c-1] += n;
	    }
	    if (r < field.length - 1) {
		field[r + 1][c] += n;
	    }
	    if (c < field[0].length - 1) {
		field[r][c + 1] += n;
	    }
	    
	}

    }


   
    
    public static void main(String[]args) {
	USACO x = new USACO(); //does not have to do anything. 
	System.out.println(x.bronze("test1.java"));
	System.out.println(x.silver("test2.java"));
    }
}






