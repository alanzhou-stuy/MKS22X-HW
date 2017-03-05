import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private boolean animate;
    private int startingX,startingY,endingX,endingY;
    
    public Maze(String filename){
	startingX = -1;
	startingY = -1;
	try {
	    File text = new File(filename); 
	    Scanner inf = new Scanner(text);
	    int x = 0;
	    int y = 0;
	    while (inf.hasNextLine()) {
		    x++;
		    y = inf.nextLine().length();
	    }
	    maze = new char[x][y];
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

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	else {

	}
        return false; //so it compiles
    }


}
