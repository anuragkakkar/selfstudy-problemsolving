package leetcodequestions;

public class MaximumSubarray {

	public static void main(String[] args) {

		int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));

		nums = new int[] { 1 };
		System.out.println(maxSubArray(nums));

		nums = new int[] { 5, 4, -1, 7, 8 };
		System.out.println(maxSubArray(nums));

	}

	private static int maxSubArray(int[] nums) {

		int currentSum = nums[0];
		int maxSum = nums[0];

		for (int i = 1; i < nums.length; i++) {

			if (currentSum < 0)
				currentSum = 0;

			currentSum += nums[i];

			maxSum = Math.max(maxSum, currentSum);

		}

		return maxSum;

	}

}
