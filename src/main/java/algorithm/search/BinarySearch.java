package algorithm.search;
/**
 * 
 * @author tianlong
 * 假设数组已经为升序排列
 * 二分查找，找到则返回其下标，否则返回应插入点下标加1的负值
 * 效率高，但要求已经排序
 *
 */
public class BinarySearch {

	public static int binarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;
		while(high >= low){
			int mid = (high + low) / 2;
			if(key < list[mid])
				high = mid -1;
			else if(key > list[mid])
				low = mid + 1;
			else
				return mid;
		}
		return -(low + 1);
	}
	
	public static void main(String[] args) {
		int[] list = new int[]{1,2,3,5,6,7};
		int key = 3;
		System.out.println(BinarySearch.binarySearch(list, key));
	}
	
}
