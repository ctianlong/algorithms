package leetcode.RemoveElement_27;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * Example: Given input array nums = [3,2,2,3], val = 3
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 * 
 * @author Tianlong
 *
 */
public class Solution {

	/**
	 * 自己的写法，适合要删除的元素比较多的情况
	 * 如果要删除的元素比较少，则会有不必要的复制操作，如 nums=[1,2,3,5,4],val=4 或者 nums=[4,1,2,3,5],val=4
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		int j = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != val)
				nums[j++] = nums[i];
		return j;
	}
	
	/**
	 * 另一种做法，利用题目中的条件，可以改变元素的先后顺序，适合要删除的元素比较少的情况下
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement2(int[] nums, int val) {
	    int i = 0;
	    int n = nums.length;
	    while (i < n) {
	        if (nums[i] == val) {
	            nums[i] = nums[n - 1];
	            // reduce array size by one
	            n--;
	        } else {
	            i++;
	        }
	    }
	    return n;
	}

}
