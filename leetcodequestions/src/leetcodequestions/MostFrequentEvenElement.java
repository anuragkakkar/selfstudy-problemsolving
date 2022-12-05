package leetcodequestions;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement {

	public static void main(String[] args) {

		int[] nums = new int[] { 0, 1, 2, 2, 4, 4, 1 };
		System.out.println(mostFrequentEven(nums));

		nums = new int[] { 4, 4, 4, 9, 2, 4 };
		System.out.println(mostFrequentEven(nums));

		nums = new int[] { 29, 47, 21, 41, 13, 37, 25, 7 };
		System.out.println(mostFrequentEven(nums));

	}

	private static int mostFrequentEven(int[] nums) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			if (num % 2 == 0) {
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
		}

		int result = -1;
		int maxFreq = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (maxFreq < entry.getValue()) {
				maxFreq = entry.getValue();
				result = entry.getKey();
			} else if (maxFreq == entry.getValue()) {
				result = Math.min(result, entry.getKey());
			}
		}
		return result;
	}
}
