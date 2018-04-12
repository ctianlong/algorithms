package algorithm.search;

/**
 * 
 * @author tianlong 假设数组已经为升序排列 二分查找，找到则返回其下标，否则返回应插入点下标加1的负值 效率高，但要求已经排序
 *
 */
public class BinarySearch {
	
	// 递归
	public static int binarySearch2(int[] list, int low, int high, int key) {
		if (low > high) return -(low + 1);
		int mid = (low + high) / 2;
		if (list[mid] > key)
			return binarySearch2(list, low, mid - 1, key);
		else if (list[mid] < key)
			return binarySearch2(list, mid + 1, high, key);
		else
			return mid;
	}

	// 非递归
	public static int binarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (key < list[mid])
				high = mid - 1;
			else if (key > list[mid])
				low = mid + 1;
			else
				return mid;
		}
		return -(low + 1);
	}

	public static void main(String[] args) {
		int[] list = {1, 2, 3, 4, 6, 7, 8};
		int key = 5;
		System.out.println(BinarySearch.binarySearch(list, key));
		System.out.println(BinarySearch.binarySearch2(list, 0, list.length - 1, key));
	}

}
