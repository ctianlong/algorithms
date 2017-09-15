package algorithm.sort;

/**
 * 直接插入排序，升序
 * 
 * @author tianlong
 *
 */
public class InsertionSort {
	
	public static void insertionSort(int[] list, int n) {
		int i,j,currentElem;
		for(i = 1; i < n; i++){
			currentElem = list[i];
			j = i - 1;
			while(j >= 0 && list[j] > currentElem){
				list[j + 1] = list[j];
				j--;
			}
			if(j + 1 != i){
				list[j + 1] = currentElem;
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

		insertionSort(list,list.length);
		// 遍历显示
//		 for (int i = 0; i < list.length; i++) {
//		 System.out.print(" " + list[i]);
//		 }

		long end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));

	}

}
