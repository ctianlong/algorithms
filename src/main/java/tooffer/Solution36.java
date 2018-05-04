package tooffer;

/*
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 */
public class Solution36 {
	
	public static void main(String[] args) {
		int[] data = {7,5,6,4};
		Solution36 s = new Solution36();
		System.out.println(s.InversePairs(data));
	}
	
	public int InversePairs(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        int[] copy = new int[array.length];
        return InversePairs(array, copy, 0, array.length - 1);
    }
    
    public int InversePairs(int[] array, int[] copy, int start, int end) {
        if (start == end)
            return 0;
        int center = (start + end) / 2;
        int left = InversePairs(array, copy, start, center);
        int right = InversePairs(array, copy, center + 1, end);
        // 开始统计，相当于二路归并，只不过在归并过程中统计逆序对，注意需从尾部开始归并
        int count = 0;
        int i = center;
        int j = end;
        int copyIndex = end;
        while (i >= start && j >= center + 1) {
            if (array[i] > array[j]) {
                count += j - center;
                if (count >= 1000000007)
                    count %= 1000000007;
                copy[copyIndex--] = array[i--];
            } else {
                copy[copyIndex--] = array[j--];
            }
        }
        for (;i >= start; --i)
            copy[copyIndex--] = array[i--];
        for (;j >= center + 1; --j)
            copy[copyIndex--] = array[j--];
        for (int e = start; e <= end; ++e)
            array[e] = copy[e];
        int x = left + right;
        if (x >= 1000000007)
            x %= 1000000007;
        int y = x + count;
        if (y >= 1000000007)
            y %= 1000000007;
        return y;
    }

}
