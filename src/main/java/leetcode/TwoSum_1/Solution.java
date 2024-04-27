package leetcode.TwoSum_1;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * <p>
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * @author Tianlong
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return null;
        // user java map
//		HashMap<Integer, Integer> map = new HashMap<>();
//		int len = nums.length;
//		for (int i = 0; i < len; i++) {
//			if (map.containsKey(target - nums[i])) {
//				return new int[] { map.get(target - nums[i]), i };
//			}
//			map.put(nums[i], i);
//		}
//		return null;
    }
}
