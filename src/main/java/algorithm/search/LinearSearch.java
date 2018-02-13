package algorithm.search;
/**
 * 
 * @author tianlong
 * 线性查找法，适合小数组或没有排序的数组，对大数组效率低
 *
 */
public class LinearSearch {
	
	public static int linearSearch(int[] list, int key) {
		for(int i = 0;i < list.length;i++){
			if(key == list[i])
				return i;
		}
		return -1;
	}

}
