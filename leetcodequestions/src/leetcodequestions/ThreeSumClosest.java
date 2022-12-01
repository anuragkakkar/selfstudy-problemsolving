package leetcodequestions;

import java.util.Arrays;

//3SumClosest - Leetcode
public class ThreeSumClosest {

	public static void main(String[] args) {

		int[] nums = new int[] { -1, 2, 1, -4 };
		int target = 1;
		System.out.println(threeSumClosest(nums, target));

		nums = new int[] { 0, 0, 0 };
		target = 1;
		System.out.println(threeSumClosest(nums, target));

	}

	private static int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int closestSum = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {

			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {

				int sum = nums[i] + nums[left] + nums[right];

				if (sum == target) {
					return sum;
				}

				if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
					closestSum = sum;
				}

				if (sum < target)
					left++;
				else
					right--;
			}
		}
		return closestSum;
	}
}
