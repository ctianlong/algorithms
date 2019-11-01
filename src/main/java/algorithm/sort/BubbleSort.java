package algorithm.sort;

/**
 * 改进的冒泡算法，升序
 * 稳定
 * @author tianlong
 *
 */
public class BubbleSort {

	public static void bubbleSort(int[] list, int n) {
		int i,j,temp;
		//用于记录在某趟冒泡中是否有交换记录，若没有，则说明已有序。
		boolean isExchanged;
		for (i = 0; i < n - 1; i++) {
			isExchanged = false;
			for (j = 0; j < n - 1 - i; j++)
				if (list[j] > list[j + 1]) {
					temp = list[j];list[j] = list[j + 1];list[j + 1] = temp;
					isExchanged = true;
				}
			if(!isExchanged)
				break;
		}
	}

	public static void main(String[] args) {
		int[] list = new int[10000];
		for (int i = 0; i < list.length; i++) {
			list[i] = 10000 - i;
		}
		
		// 计算运行时间
		long start = System.currentTimeMillis();

		bubbleSort(list, list.length);
		// 遍历显示
//		for (int i = 0; i < list.length; i++) {
//			System.out.print(" " + list[i]);
//		}
		long end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));
	}

}
