public class Recursion{ 

    public static String name(){
	return "Zhou,Alan";
    }

    public static double sqrt(double n){
	if (n < 0) {
	    throw new IllegalArgumentException(); 
	}
	return helper(n,1);
	     
    }

    public static double helper(double value, double guess) {
	if (isCloseEnough(guess * guess, value)) {
	    return guess;
	}
	guess = ((value / guess + guess) / 2);
	helper(value,guess);
    }

    public static boolean isCloseEnough(double yourAnswer, double actual) {
	return (((yourAnswer - actual) / actual) < 0.000000000001);
    }

    public static void main(String[] args) {
	System.out.println(sqrt(100));
	System.out.println(sqrt(0));
	System.out.println(sqrt(-1));
	System.out.println(sqrt(35));
	System.out.println(sqrt(37));
    }
}
