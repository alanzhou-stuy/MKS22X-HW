import java.util.*;
import java.io.*;

public class USACO {
    private int[][] lake;
    private int R,C,E,N,R_s,C_s,D_s;

    public int bronze(String filename) {
	File text = new File(filename);
	Scanner scan = new Scanner(text);
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

}






