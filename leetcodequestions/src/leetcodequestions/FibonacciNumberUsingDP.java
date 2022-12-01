package leetcodequestions;

import java.util.Arrays;

public class FibonacciNumberUsingDP {

	public static void main(String[] args) {

		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));

	}

	private static int fib(int n) {

		if (n < 2)
			return n;

		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;

		return calfibonacci(n, dp);
	}

	private static int calfibonacci(int n, int[] dp) {

		int result;
		if (dp[n] != -1) {
			result = dp[n];
		} 
		else {
			result = calfibonacci(n - 1, dp) + calfibonacci(n - 2, dp);
		}

		dp[n] = result;
		return result;
	}

}
