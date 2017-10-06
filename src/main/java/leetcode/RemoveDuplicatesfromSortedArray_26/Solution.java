package leetcode.RemoveDuplicatesfromSortedArray_26;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 * 
 * @author Tianlong
 *
 */
public class Solution {

	/**
	 * 用两个指针，i遍历整个数组，j依次储存不重复元素
	 * 每次i与j相比较，若相同，则i++，若不同，则j+1位置存储i位置元素
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int j = 0;
		for (int i = 1; i < nums.length; i++)
			if (nums[i] != nums[j])
				nums[++j] = nums[i];
		return j + 1;
	}

}
