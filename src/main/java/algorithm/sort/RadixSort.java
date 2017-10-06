package algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序，多关键字
 * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
 * 步骤：分配+收集
 * @author tianlong
 *
 */
public class RadixSort {

	public static void radixSort(int[] array, int n) {
		int i,j,x;
		ArrayList<Integer> temp;
		// 首先确定排序的趟数;
		int max = array[0];
		for (i = 1; i < n; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		int time = 0;
		// 判断位数;
		while (max > 0) {
			max /= 10;
			time++;
		}

		// 建立10个队列;
		List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
		for (i = 0; i < 10; i++)
			queue.add(new ArrayList<Integer>());

		// 进行time次分配和收集;
		for (i = 0; i < time; i++) {
			// 分配数组元素;
			for (j = 0; j < n; j++) {
				// 得到数字的第i+1位数,从低位开始;
				x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				queue.get(x).add(array[j]);
			}
			int count = 0;// 元素计数器;
			// 收集队列元素;
			for (int k = 0; k < 10; k++) {
				//网上的某一做法，效率低
//				while (queue.get(k).size() > 0) {
//					ArrayList<Integer> queue3 = queue.get(k);
//					array[count] = queue3.get(0);
//					queue3.remove(0);
//					count++;
//				}
				temp = queue.get(k);
				if(temp.size() > 0){
					for(int ele: temp){
						array[count++] = ele;
					}
					temp.clear();
				}
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

		radixSort(list, list.length);
		// 遍历显示
//		 for (int i = 0; i < list.length; i++) {
//		 System.out.print(" " + list[i]);
//		 }
		
		long end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));
	}
}
