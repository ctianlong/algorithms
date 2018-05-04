package algorithm.sort;

/**
 * 归并排序2,,没有一趟归并算法，而是使用递归,花费时间长,空间花销大,但代码简单
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 * @author tianlong
 *
 */
public class MergeSort2 {

	/**
	 */
	public static void mergeSort(int[] data, int[] copy, int left, int right) {
		if (left < right) {
			// 找出中间索引
			int center = (left + right) / 2;
			// 对左边数组进行递归
			mergeSort(data, copy, left, center);
			// 对右边数组进行递归
			mergeSort(data, copy, center + 1, right);
			// 合并
			merge(data, copy, left, center, right);
		}
	}

	/**
	 * 两路归并算法
	 */
	public static void merge(int[] data, int[] copy, int left, int center, int right) {
		int i = left;
		int j = center + 1;
		int k = left; // 辅助数组索引
		while (i <= center && j <= right) {
			if (data[i] <= data[j]) { // 从两个数组中取出最小的放入中间数组
				copy[k++] = data[i++];
			} else {
				copy[k++] = data[j++];
			}
		}
		// 剩余部分依次放入中间数组
		while (i <= center) {
			copy[k++] = data[i++];
		}
		while (j <= right) {
			copy[k++] = data[j++];
		}
		// 将中间数组中的内容复制回原数组
		for (int e = left; e <= right; ++e)
			data[e] = copy[e];
	}
	
	
	public static void main(String[] args) {
		int[] list = new int[100];
		for (int i = 0; i < list.length; i++) {
			list[i] = 100 - i;
		}

		// 计算运行时间
		long start = System.currentTimeMillis();
		
		int[] copy = new int[100];
		mergeSort(list, copy, 0, list.length - 1);
		// 遍历显示
		 for (int i = 0; i < list.length; i++) {
		 System.out.print(" " + list[i]);
		 }
		
		long end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));
	}

}
