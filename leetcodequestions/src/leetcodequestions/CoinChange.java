package leetcodequestions;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		
		int[] coins = new int[] {1, 2, 5};
		int amount = 11;
		System.out.println(coinChange(coins, amount));
		
		coins = new int[] {2};
		amount = 3;
		System.out.println(coinChange(coins, amount));
		
		coins = new int[] {1};
		amount = 0;
		System.out.println(coinChange(coins, amount));
		
		coins = new int[] {7, 5, 1};
		amount = 18;
		System.out.println(coinChange(coins, amount));

	}

	private static int coinChange(int[] coins, int amount) {

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		return helper(coins, amount, dp);

	}

	private static int helper(int[] coins, int amount, int[] dp) {

		if (amount == 0)
			return 0;

		int minNumCoins = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {

			if (amount - coins[i] >= 0) {

				int numCoins = 0;
				if (dp[amount - coins[i]] != -1) {
					if (dp[amount - coins[i]] == Integer.MAX_VALUE)
						continue;
					numCoins = dp[amount - coins[i]];
				} 
				else {
					numCoins = helper(coins, amount - coins[i], dp);
				}

				if (numCoins != -1 && minNumCoins > numCoins + 1) {
					minNumCoins = numCoins + 1;
				}
			}
		}

		dp[amount] = minNumCoins;
		return minNumCoins != Integer.MAX_VALUE ? minNumCoins : -1;
	}
}
