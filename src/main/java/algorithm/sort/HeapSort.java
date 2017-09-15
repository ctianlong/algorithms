package algorithm.sort;

/**
 * 堆排序，一种树形选择排序，是对直接选择排序的有效改进。
 * 
 * @author tianlong
 *
 */
public class HeapSort {

	public static void heapSort(int[] list, int n) {
		int i;
		int temp;
		//建初始堆
		for (i = n / 2 - 1; i >= 0; i--) 
			buildMaxHeap(list, n, i);
		//n-1趟堆排序
		for(i = n - 1; i >= 1; i--){
			//将当前堆中第一个记录和最后一个记录互换
			temp = list[0];
			list[0] = list[i];
			list[i] = temp;
			//筛选list[0]节点
			buildMaxHeap(list, i, 0);
		}
	}

	// 对data数组[0:n-1]（n为所取的数组长度，不一定为总长度）中的节点data[t]进行调整，构成以data[t]为根节点的大顶堆
	// 前提:data[t]节点的左右子树已满足堆的定义
	private static void buildMaxHeap(int[] data, int n, int t) {
		int i = t;
		//待筛选节点值data[t]放入辅助单元temp中
		int temp = data[i];
		//data[j]是data[i]的左孩子
		int j = 2 * i + 1;
		//判断左孩子是否存在
		while(j < n){
			//判断右孩子是否存在，并与左孩子进行比较
			if(j < n - 1 && data[j] < data[j + 1])
				j++;  //若右孩子存在且右孩子关键字值大，则j保存右孩子下标
			if(temp < data[j]){  //比较待筛选节点值和左、右孩子中较大值
				//左右孩子中较大值往上冒
				data[i] = data[j];
				//重新开始下一次比较
				i = j;
				j = 2 * i + 1;
			}else
				//若待筛选节点值比左、右孩子值都大，则结束
				break;
		}
		data[i] = temp;
	}
	
	public static void main(String[] args) {
		int[] list = new int[10000];
		for (int i = 0; i < list.length; i++) {
			list[i] = 10000 - i;
		}

		// 计算运行时间
		long start = System.currentTimeMillis();

		heapSort(list,list.length);
		// 遍历显示
//		 for (int i = 0; i < list.length; i++) {
//		 System.out.print(" " + list[i]);
//		 }
		
		long end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));
	}

}
