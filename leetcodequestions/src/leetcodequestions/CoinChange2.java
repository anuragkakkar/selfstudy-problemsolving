package leetcodequestions;

//https://leetcode.com/problems/coin-change-ii/discuss/1600337/Java-%2B-DP-%2B-Detailed-Explanation
public class CoinChange2 {

	public static void main(String[] args) {

		int[] coins = new int[] { 1, 2, 5 };
		int amount = 5;
		System.out.println(change(amount, coins));

	}

	private static int change(int amount, int[] coins) {

		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++)
				dp[i] += dp[i - coin];
		}
		return dp[amount];

	}

}
