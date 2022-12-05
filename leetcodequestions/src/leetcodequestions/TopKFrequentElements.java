package leetcodequestions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
		int[] result = topKFrequent(nums, 2);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

		System.out.println();

		nums = new int[] { 1 };
		result = topKFrequent(nums, 1);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	private static int[] topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
				new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(entry);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		int[] result = new int[k];
		for(int i = 0; i < result.length; i++) {
			result[i] = minHeap.poll().getKey();
		}
		return result;
	}
}
