package leetcodequestions;

public class ThirdMaximumNumber {

	public static void main(String[] args) {

		int[] nums = new int[] { 3, 2, 1 };
		System.out.println(thirdMax(nums));

		nums = new int[] { 2, 1 };
		System.out.println(thirdMax(nums));

		nums = new int[] { 1, 2 };
		System.out.println(thirdMax(nums));

		nums = new int[] { 2, 2, 3, 1 };
		System.out.println(thirdMax(nums));

		nums = new int[] { 1, 1, 2 };
		System.out.println(thirdMax(nums));

		nums = new int[] { 1, 2, Integer.MIN_VALUE };
		System.out.println(thirdMax(nums));
	}

	private static int thirdMax(int[] nums) {

		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);

		long max = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == max || nums[i] == secondMax || nums[i] == thirdMax)
				continue;

			if (max < nums[i]) {
				thirdMax = secondMax;
				secondMax = max;
				max = nums[i];
			} else if (secondMax < nums[i]) {
				thirdMax = secondMax;
				secondMax = nums[i];
			} else if (thirdMax < nums[i]) {
				thirdMax = nums[i];
			}
		}

		if (thirdMax == Long.MIN_VALUE) {
			return (int) max;
		}
		return (int) thirdMax;
	}

}
