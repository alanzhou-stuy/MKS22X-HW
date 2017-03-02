import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
	try {
	    int counter,eCounter,sCounter = 0;
	    File text = new File(filename); 
	    Scanner inf = new Scanner(text);
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		for (int i = 0; i < line.length(); i ++ ) {
		    maze[counter][i] = line.charAt(i);
		    if (line.charAt(i) == 'S') {
			sCounter += 1;
		    }
		    if (line.charAt(i) == 'E')  {
			eCounter += 1;
		    }
		}
		counter += 1;
	    }
	    animate = false;
	}
	catch(FilesNotFoundException j) {
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
            int startr=-1,startc=-1;
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
