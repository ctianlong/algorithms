package algorithm.sort;

/**
 * 归并排序2,,没有一趟归并算法，而是使用递归,花费时间长,空间花销大,但代码简单
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 * @author tianlong
 *
 */
public class MergeSort2 {

	public static void mergeSort(int[] data, int left, int right) {
		if (left < right) {
			// 找出中间索引
			int center = (left + right) / 2;
			// 对左边数组进行递归
			mergeSort(data, left, center);
			// 对右边数组进行递归
			mergeSort(data, center + 1, right);
			// 合并
			merge(data, left, center, right);
		}
	}

	/**
	 * 两路归并算法
	 * @param data
	 * @param left
	 * @param center
	 * @param right
	 */
	public static void merge(int[] data, int left, int center, int right) {
		//每调用一次都会new一个数组，空间花销大
		int[] tmpArr = new int[data.length];
		int mid = center + 1;
		// third记录中间数组的索引
		int third = left;
		int tmp = left;
		while (left <= center && mid <= right) {
			// 从两个数组中取出最小的放入中间数组
			if (data[left] <= data[mid]) {
				tmpArr[third++] = data[left++];
			} else {
				tmpArr[third++] = data[mid++];
			}
		}
		// 剩余部分依次放入中间数组
		while (mid <= right) {
			tmpArr[third++] = data[mid++];
		}
		while (left <= center) {
			tmpArr[third++] = data[left++];
		}
		// 将中间数组中的内容复制回原数组
		while (tmp <= right) {
			data[tmp] = tmpArr[tmp];
			tmp++;
		}
	}
	
	public static void main(String[] args) {
		int[] list = new int[10000];
		for (int i = 0; i < list.length; i++) {
			list[i] = 10000 - i;
		}

		// 计算运行时间
		long start = System.currentTimeMillis();

		mergeSort(list, 0, list.length - 1);
		// 遍历显示
//		 for (int i = 0; i < list.length; i++) {
//		 System.out.print(" " + list[i]);
//		 }
		
		long end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));
	}

}
