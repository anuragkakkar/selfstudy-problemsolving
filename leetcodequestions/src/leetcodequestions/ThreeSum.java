package leetcodequestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//3Sum - Leetcode
public class ThreeSum {

	public static void main(String[] args) {

		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums));

		nums = new int[] { 0, 1, 1 };
		System.out.println(threeSum(nums));

		nums = new int[] { 0, 0, 0 };
		System.out.println(threeSum(nums));

		nums = new int[] { 0, 0, 0, 0 };
		System.out.println(threeSum(nums));

	}

	private static List<List<Integer>> threeSum(int[] nums) {

		HashSet<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {

				int sum = nums[i] + nums[left] + nums[right];

				if (sum == 0) {
					set.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return new ArrayList<>(set);
	}

}
