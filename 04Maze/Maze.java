import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private boolean animate;
    private int startingX,startingY,endingX,endingY;
    
    public Maze(String filename){
	//startingX = -1;
	//startingY = -1;
	try {
	    File text = new File(filename); 
	    Scanner inf = new Scanner(text);
	    int x = 0;
	    int y = 0;
	    while (inf.hasNextLine()) {
		    x++;
		    y = inf.nextLine().length();
	    }
	    inf.close();
	    maze = new char[x][y];
	    inf = new Scanner(text);
	    int counter = 0;
	    while(inf.hasNext()){
		String line = inf.nextLine();
		for (int i = 0; i < line.length(); i ++ ) {
		    maze[counter][i] = line.charAt(i);
		    if (line.charAt(i) == 'S') {
			startingX = counter;
			    startingY = i;
		    }
		    if (line.charAt(i) == 'E')  {
			endingX = counter;
			endingY = i;		    
		    }
		}
		    counter += 1;
	    }
	    animate = false;
	    System.out.println(startingX + "," + startingY);
	}
	catch(FileNotFoundException j) {
	    System.out.println("File not found."); 
	    System.exit(0);
	}	       	
    }
    

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }


    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }

    public boolean solve(){
	int startr = startingX;
	int startc = startingY;
	maze[startr][startc] = ' ';
	return solve(startr,startc);
    }

    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	if (maze[row][col] == 'E') {
	    return true;
	}
	if (maze[row][col] == ' ') {
	    maze[row][col] = '@';
	    if (solve(row + 1,col)|| solve(row - 1,col) || solve(row, col + 1) || solve (row, col - 1)) {
		return true;
	    }
	    else{
		maze[row][col] = '.';
	    }
	}
	
	
        return false;
    }

    public String toString(){
	String x = "";
	for(int i = 0; i < maze.length;i++){
	    for(int k = 0; k < maze[0].length;k++){
		layout += maze[i][k];
		if(k == maze[0].length - 1){
		    layout += "\n";
		}
	    }
	}
	return x;
    }



}
