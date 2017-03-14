import java.util.*;
public class Quiz2Redux{  

  public static ArrayList<String> combinations(String s){
      ArrayList<String>words = new ArrayList<String>();
      help( words,0, s, "");
      Collections.sort(words);
      return words;
  }
  
    private static void help( ArrayList<String> words,int counter,String s, String empty){
      if (counter == s.length()) {
	  words.add(empty);
	  return;
      }
      String x = empty;
      empty += s.charAt(counter);
      help (words, counter + 1, s, empty);
      help (words,counter + 1, s, x);
  }

    public static void main(String[]args){
	System.out.println(combinations("abcd"));
	System.out.println(combinations("kji"));
    }
}
