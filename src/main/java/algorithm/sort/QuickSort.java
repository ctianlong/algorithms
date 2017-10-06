package algorithm.sort;

/**
 * 快速排序，对冒泡排序的改进，找基准值，递归，不稳定
 * @author tianlong
 *
 */
public class QuickSort {

	public static void quickSort(int[] list, int low, int high) {
		if (low < high) {
			int i = low;
			int j = high;
			//temp作为基准值
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
			quickSort(list, low, i - 1);
			quickSort(list, i + 1, high);
		}
	}
	
	public static void main(String[] args) {
		int[] list = new int[10000];
		for (int i = 0; i < list.length; i++) {
			list[i] = 10000 - i;
		}
		
		// 计算运行时间
		long start = System.currentTimeMillis();

		quickSort(list, 0, list.length - 1);
		// 遍历显示
//		for (int i = 0; i < list.length; i++) {
//			System.out.print(" " + list[i]);
//		}
		long end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));
	}

}
