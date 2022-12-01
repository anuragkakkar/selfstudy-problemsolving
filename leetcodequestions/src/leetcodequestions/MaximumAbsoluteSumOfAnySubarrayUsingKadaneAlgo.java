package leetcodequestions;

public class MaximumAbsoluteSumOfAnySubarrayUsingKadaneAlgo {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, -3, 2, 3, -4 };
		System.out.println(maxAbsoluteSum(nums));

		nums = new int[] { 2, -5, 1, -4, 3, -2 };
		System.out.println(maxAbsoluteSum(nums));

	}

	private static int maxAbsoluteSum(int[] nums) {

		int max = Integer.MIN_VALUE;
		int curSum = 0;
		for (int i = 0; i < nums.length; i++) {
			curSum += nums[i];
			max = Math.max(max, curSum);
			if (curSum < 0)
				curSum = 0;
		}

		int min = Integer.MAX_VALUE;
		curSum = 0;
		for (int i = 0; i < nums.length; i++) {
			curSum += nums[i];
			min = Math.min(min, curSum);
			if (curSum > 0)
				curSum = 0;
		}
		return Math.max(Math.abs(max), Math.abs(min));
	}
}
