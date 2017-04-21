import java.util.Stack;
import java.lang.*;

public class HW {

    public boolean isOperator(String str) {
	return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("%"));
    }

    public double apply(String operation, double a, double b) {
	double ans;
	if (operation.equals("+")) {
	    ans = b + a;
	    return ans;
	}
	else if (operation.equals("-")) {
	    ans = b - a;
	    return ans;
	}
	else if (operation.equals("*")) {
	    ans = b * a;
	    return ans;
	}
	else if (operation.equals("/")) {
	    ans = b / a;
	    return ans;
	}
	else {
	    ans = b % a;
	    return ans;
	}
    }

    public double eval(String str) {
	String[] token = str.split(" ");
	Stack values = new Stack<Double>();
	for (String s: token) {
	    if (!isOperator(s)) {
		values.push(Double.parseDouble(s));
	    }
	    else {
		values.push(apply(s,values.pop(),values.pop()));
	    }
	}
	return values.pop();
    }


}
