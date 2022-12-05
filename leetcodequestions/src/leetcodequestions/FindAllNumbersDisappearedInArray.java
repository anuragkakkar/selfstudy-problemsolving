package leetcodequestions;

import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {

	public static void main(String[] args) {

		int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDisappearedNumbers(nums));

		nums = new int[] { 1, 1 };
		System.out.println(findDisappearedNumbers(nums));

	}

	private static List<Integer> findDisappearedNumbers(int[] nums) {

		int[] arr = new int[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]] = 1;
		}

		List<Integer> result = new LinkedList<>();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 0) {
				result.add(i);
			}
		}
		return result;
	}

}
