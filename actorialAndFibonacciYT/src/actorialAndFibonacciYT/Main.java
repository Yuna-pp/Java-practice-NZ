package actorialAndFibonacciYT;

public class Main {

	public static void main(String[] args) {
		System.out.println(actorial(5));
		
		for (int i = 0; i <= 7; i++) {
			if (i <= 1) {
		        System.out.println("F(" + i + ") = " + fibonacci(i));
		    } else {
		        System.out.println("F(" + i + ") = F(" + (i-2) + ") + F(" + (i-1) + ") = " + fibonacci(i));
		    }
		}
	}
	
	public static Integer actorial(int n) {	
		if(n==1) {
			return n;
		}
		else {
			int prev = actorial(n-1);
			return prev*n;
		}			
	}
	public static Integer fibonacci(int n) {
		if(n==0||n==1) {	
			return n;
		}
		else {
			int x=fibonacci(n-1);
			int y=fibonacci(n-2);
			return x+y;
		}
	}
}
