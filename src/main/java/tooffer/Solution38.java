package tooffer;

/*
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution38 {
	
	public static void main(String[] args) {
		int[] array = {1,2,3,3,3,3,3,5,5,5,6,6,7};
		int k = 3;
		Solution38 s = new Solution38();
		System.out.println(s.GetNumberOfK(array, k));
	}
	
	/*
	 * 采用二分查找思想分别找到第一个k的下标和最后一个k的小标
	 */
	public int GetNumberOfK(int [] array , int k) {
		if (array == null || array.length ==0) {
			return 0;
		}
		int first = getFirstK(array, k);
		int last = getLastK(array, k);
		if (first > -1 && last > -1) {
			return last - first + 1;
		}
		return 0;
    }
	
	public int getFirstK(int[] array, int k) {
		int l = 0;
		int r = array.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (array[m] == k) {
				if (m == 0 || (array[m - 1] != k)) {
					return m;
				} else {
					r = m - 1;
				}
			} else if (array[m] > k) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}
	
	public int getLastK(int[] array, int k) {
		int l = 0;
		int r = array.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (array[m] == k) {
				if (m == array.length - 1 || (array[m + 1] != k)) {
					return m;
				} else {
					l = m + 1;
				}
			} else if (array[m] > k) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}

}
