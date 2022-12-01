package leetcodequestions;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {

		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(nums, 0));

	}

	private static int search(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;

		if (nums[left] < nums[right]) {
			return binarySearch(nums, target, 0, nums.length - 1);
		}

		int pivot = -1;
		while (left <= right) {

			int mid = left + (right - left) / 2;

			if (nums[mid] == target)
				return mid;

			if (nums[mid] > nums[mid + 1]) {
				pivot = mid + 1;
				break;
			}

			if (nums[mid - 1] > nums[mid]) {
				pivot = mid;
				break;
			}

			if (nums[mid] > nums[left]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		int result = binarySearch(nums, target, 0, pivot - 1);
		if (result == -1) {
			result = binarySearch(nums, target, pivot, nums.length - 1);
		}

		return result;
	}

	private static int binarySearch(int[] nums, int target, int left, int right) {
		while (left <= right) {

			int mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

}
