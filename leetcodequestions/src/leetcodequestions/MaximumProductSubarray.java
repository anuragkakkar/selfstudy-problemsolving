package leetcodequestions;

public class MaximumProductSubarray {

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 3, -2, 4 };
		System.out.println(maxProduct(nums));

		nums = new int[] { -2, 0, -1 };
		System.out.println(maxProduct(nums));

	}

	private static int maxProduct(int[] nums) {

		int result = Integer.MIN_VALUE;
		int curMax = 1;
		int curMin = 1;
		boolean isZeroPresent = false;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 0) {
				curMax = 1;
				curMin = 1;
				isZeroPresent = true;
				continue;
			}

			int temp = nums[i] * curMax;
			curMax = Math.max(temp, Math.max(nums[i] * curMin, nums[i]));
			curMin = Math.min(temp, Math.min(nums[i] * curMin, nums[i]));
			result = Math.max(result, curMax);
		}
		return isZeroPresent && result < 0 ? 0 : result;
	}

}
