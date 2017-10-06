package algorithm.sort;

/**
 * 希尔排序，插入排序类算法，在时间效率上有较大改进，但不稳定
 * @author tianlong
 *
 */
public class ShellSort {
	
	public static void shellSort(int[] list, int n){
		int currentElem,i,j;
		int d = n / 2;
		while(d >= 1){
			for(i = d; i < n; i++){
				currentElem = list[i];
				j = i - d;
				while(j >= 0 && list[j] > currentElem){
					list[j + d] = list[j];
					j -=d;
				}
				if(j + d != i){
					list[j + d] = currentElem;
				}
			}
			d /=2;
		}
	}
	
	public static void main(String[] args) {
		int[] list = new int[10000];
		for (int i = 0; i < list.length; i++) {
			list[i] = 10000 - i;
		}

		// 计算运行时间
		long start = System.currentTimeMillis();

		shellSort(list, list.length);
		 //遍历显示
//		 for (int i = 0; i < list.length; i++) {
//			 System.out.print(" " + list[i]);
//		 }

		long end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));
	}

}
