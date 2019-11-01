package algorithm.sort;


/**
 * 快速排序，对冒泡排序的改进，找基准值，递归，
 * 不稳定
 * @author tianlong
 *
 */
public class QuickSort {

	// 注意：每次以序列中的第一个元素作为基准值，可能出现最坏情况，如序列本身已有序，而每轮排序都以第一个值（或最后一个）作为基准值
	public static void quickSort(int[] list, int low, int high) {
		if (low < high) {
			/* 改进，不要选取第一个（或最后一个）元素作为基准值，可以随机在low和high之间选取一个值，再将这个值和第一个元素（或最后一个）的值进行交换 */
			int pivotIndex = (low + high) / 2; // 此处模拟随机，采用取中间值作为基准值
//			int pivotIndex = low; // 若采用头或尾元素作为基准值，则容易出现最坏情况
			/* partition操作，两种 */
			int pivotNewIndex = partition1(list, low, high, pivotIndex);
//			int pivotNewIndex = partition2(list, low, high, pivotIndex);
			/* 递归调用 */
			quickSort(list, low, pivotNewIndex - 1);
			quickSort(list, pivotNewIndex + 1, high);
		}
	}
	
	/*
	 * 将基准值换到头部，然后进行前后交换
	 */
	public static int partition1(int[] list, int low, int high, int pivotIndex) {
		// 将基准值换到头部
		swap(list, low, pivotIndex);
		int i = low;
		int j = high;
		//temp保存基准值
		int temp = list[i];
		while (i < j) {
			while (i < j && list[j] >= temp)
				j--;
			if (i < j) {
				list[i] = list[j];
				i++;
			}
			while(i < j && list[i] <= temp)
				i++;
			if(i < j){
				list[j] = list[i];
				j--;
			}
		}
		list[i] = temp;
		// 返回基准值新下标
		return i;
	}
	
	/*
	 * 另一种partition操作，将基准值换到尾部，然后从头遍历，将小于基准的值放在前部，大于基准的值放在后部，
	 * 最后将尾部的基准值插到中间
	 */
	public static int partition2(int[] list, int low, int high, int pivotIndex) {
		int pivotValue = list[pivotIndex];
		swap(list, pivotIndex, high);
		int storeIndex = low;
		for (int i = low; i < high; ++i) {
			if (list[i] < pivotValue) {
				swap(list, storeIndex, i);
				storeIndex++;
			}
		}
		swap(list, storeIndex, high);
		return storeIndex;
	}
	
	public static void swap(int[] list, int i, int j) {
		int t = list[i];
		list[i] = list[j];
		list[j] = t;
	}
	
	public static void main(String[] args) {
		final int N = 10000;
		int[] list = new int[N];
		for (int i = 0; i < list.length; i++) {
			list[i] = N - i;
//			list[i] = i;
		}
		// 计算运行时间
		long start = System.currentTimeMillis();
		exam(list, 0, list.length - 1);
		long end = System.currentTimeMillis();
		// 遍历显示
		for (int i = 0; i < list.length; i++) {
			System.out.print(" " + list[i]);
		}
		System.out.println("\n所花时间ms：" + (end - start));
	}


	public static void exam(int[] list, int low, int high) {
		if (low < high) {
			int pivotIndex = (low + high) / 2; // 随机比较好
			swap(list, pivotIndex, low);
			int i = low;
			int j = high;
			int pivotValue = list[low];
			while (i < j) {
				while (i < j && list[j] >= pivotValue)
					j--;
				if (i < j) {
					list[i] = list[j];
					i++;
				}
				while (i < j && list[i] <= pivotValue)
					i++;
				if (i < j) {
					list[j] = list[i];
					j--;
				}
			}
			list[i] = pivotValue;
			exam(list, low, i -1);
			exam(list, i + 1, high);
		}
	}

}
