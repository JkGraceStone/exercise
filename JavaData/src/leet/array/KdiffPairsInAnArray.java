package leet.array;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsInAnArray {
	public int findPairs(int[] nums, int k) {
		if (k < 0) {
			return 0;
		}
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (k == 0) {
				if (entry.getValue() > 2)
					count++;
			} else {
				if (map.containsKey(entry.getKey() + k)) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {

		int[] nums = { 3, 1, 4, 1, 5 };
		KdiffPairsInAnArray kdiffPairsInAnArray = new KdiffPairsInAnArray();
		System.out.println(kdiffPairsInAnArray.findPairs(nums, 2));
	}
}
