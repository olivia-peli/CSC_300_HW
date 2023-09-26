package fibonacci;

public class Driver {

	public static void main(String[] args) {
		int n = 8;
		
		//print the sequence up to n
		for(int i = 0; i < n; i++) {
			System.out.println(fib(i));
		}

	}

	static int fib(int n) {
		//since the first number of the sequence is 1
		if(n <= 1) {
			return n;
		}
		//using the recursive call
		return fib(n - 1) + fib(n - 2);
	}
}
