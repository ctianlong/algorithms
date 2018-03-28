package alibaba;



import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		int[][] ii = new int[][]{{4,6},{3,7},{5,8},{8,9}};
		System.out.println(new Main().countCars(ii));
		
	}
	
	/**
	 * 阿里 停车场 同时最多停几辆
	 * 以下代码错误
	 * @param carArray
	 * @return
	 */
	public int countCars(int[][] carArray) {
        int ans = 0;
        Map<Integer, Integer> r = new HashMap<>();
        for (int i = 0; i < carArray.length; i++) {
        	int start = carArray[i][0];
        	int end = carArray[i][1];
        	for (Map.Entry<Integer, Integer> v: r.entrySet()) {
        		int s = v.getKey();
        		int e = v.getValue();
        		if (start <= s && end > s) {
        			v.setValue(++e);
        		}
        	}
        	if (!r.containsKey(start))
        		r.put(start, 1);
        }
        Collection<Integer> values = r.values();
        for (int i: values) {
        	if (i > ans) ans = i;
        }
        return ans; // 返回计算结果
    }

}
