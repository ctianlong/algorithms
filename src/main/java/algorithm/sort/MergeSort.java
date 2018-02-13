package algorithm.sort;

/**
 * 归并排序，较好
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 * @author tianlong
 *
 */
public class MergeSort {

	
	public static void mergeSort(int[] r, int n) {
		int[] t = new int[n];
//		int i;
		int s = 1;
		while(s < n){
			oneMerge(s, n, t, r);
			//在merge方法中已经实现从t复制回r中的操作，故此处不用下列操作
//			for(i = 0; i < n; i++){
//				r[i] = t[i];
//			}
			s = s * 2;
		}
	}

	/**
	 * 相邻有序子表归并算法，二路归并，依次比较各个有序表的第一条记录
	 * @param r
	 * @param h 下标
	 * @param m 下标
	 * @param w 下标
	 * @param t 辅助单元
	 */
	private static void merge(int[] r, int h, int m, int w, int[] t) {
		int i,j,k;
		i = h;
		j = m + 1;
		k = h - 1;
		while((i <= m) && (j <= w)){
			k++;
			if(r[i] <= r[j])
				t[k] = r[i++];
			else 
				t[k] = r[j++];
		}
//		if(i > m)
//			while(j <= w)
//				t[++k] = r[j++];
//		else
//			while(i <= m)
//				t[++k] = r[i++];
		
		//实现从t复制回r中的操作
		if(i > m){
			//从t中复制回r中，但不用从h~w全部复制
			for(int e = h; e < j; e++)
				r[e] = t[e];
		}
		else{
			while(i <= m)
				t[++k] = r[i++];
			//从t中复制回r中
			for(int e = h; e <= w; e++){
				r[e] = t[e];
			}
		}
	}
	
	/**
	 * 一趟归并算法
	 * @param s
	 * @param n
	 * @param t
	 * @param r
	 */
	private static void oneMerge(int s, int n, int[] t, int[] r){
		int i = 0;
		//两两归并长度为s的有序子表
		while(i < (n - 2 * s + 1)){
			merge(r, i, i + s - 1, i + 2 * s - 1, t);
			i = i + 2 * s;
		}
		//剩余两个子表，其中一个长度小于s
		if(i < n - s)
			merge(r, i, i + s - 1, n - 1, t);
//		else 
//			while(i < n)  //把余下的最后一个有序子表复制到t中
//				t[i] = r[i++];
	}
	
	public static void main(String[] args) {
		int[] list = new int[10000];
		for (int i = 0; i < list.length; i++) {
			list[i] = 10000 - i;
		}

		// 计算运行时间
		long start = System.currentTimeMillis();

		mergeSort(list, list.length);
		// 遍历显示
//		 for (int i = 0; i < list.length; i++) {
//		 System.out.print(" " + list[i]);
//		 }
		
		long end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));
	}

}
