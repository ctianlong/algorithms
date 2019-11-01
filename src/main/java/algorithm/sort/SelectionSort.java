package algorithm.sort;

/**
 * 直接选择排序法，升序
 * 不稳定
 * 
 * @author tianlong
 *
 */
public class SelectionSort {

	public static void selectionSort(int[] list, int n) {
		int i,j,temp;
		for (i = 0; i < n - 1; i++) {
			int minI = i;
			for (j = i + 1; j < n; j++)
				if (list[minI] > list[j])
					minI = j;
			if (minI != i) {
				temp = list[minI];
				list[minI] = list[i];
				list[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] list = new int[10000];
		for (int i = 0; i < list.length; i++) {
			list[i] = 10000 - i;
		}

		// 计算运行时间
		long start = System.currentTimeMillis();

		selectionSort(list, list.length);
		// 遍历显示
//		 for (int i = 0; i < list.length; i++) {
//		 System.out.print(" " + list[i]);
//		 }
		
		long end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));
	}

}
