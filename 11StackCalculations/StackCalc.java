import java.util.Stack;
import java.lang.*;

public class StackCalc {

    public static boolean isOperator(String str) {
	return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("%"));
    }

    public static String apply(String operation, String  c, String d) {
	String ans = " ";
	double a = Double.parseDouble(c);
	double b = Double.parseDouble(d);
	if (operation.equals("+")) {
	    ans += b + a;
	    return ans;
	}
	else if (operation.equals("-")) {
	    ans += b - a;
	    return ans;
	}
	else if (operation.equals("*")) {
	    ans += b * a;
	    return ans;
	}
	else if (operation.equals("/")) {
	    ans += b / a;
	    return ans;
	}
	else {
	    ans += b % a;
	    return ans;
	}
    }

    public static double eval(String str) {
	String[] token = str.split(" ");
	Stack <String> values = new Stack<String>();
	for (String s: token) {
	    if (isOperator(s)) {
		values.push(apply(s," " + values.pop()," " + values.pop()));
	    }
	    else {
		values.push(s);
	    }
	}
	return Double.parseDouble ( " " + values.pop());
    }

    public static void main(String[] args)
{
    System.out.println(StackCalc.eval("10 2 +"));//12.0
    System.out.println(StackCalc.eval("10 2 -"));//8.0
    System.out.println(StackCalc.eval("10 2.0 +"));//12.0
    System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0
    System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//839.0
    System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
}
}
