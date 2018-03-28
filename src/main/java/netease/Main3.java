package netease;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 牛牛找工作
 * 
 * 时间限制：2秒

	空间限制：65536K
	
	为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。 
	输入描述:
	每个输入包含一个测试用例。
	每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
	接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
	接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
	保证不存在两项工作的报酬相同。
	
	
	输出描述:
	对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
	
	输入例子1:
	3 3 
	1 100 
	10 1000 
	1000000000 1001 
	9 10 1000000000
	
	输出例子1:
	100 
	1000 
	1001
 * 
 * 网易2018春招（2019实习） https://www.nowcoder.com/discuss/70736?type=0&order=0&pos=14&page=1
 * @author ctl
 *
 */
public class Main3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		Map<Integer, Integer> work = new TreeMap<>(); // 使用treemap对工作难度和能力排序
		for (int i = 0; i < N; i++) {
			int k = in.nextInt();
			int v = in.nextInt();
			// 如果不包含该工作难度，则加入，如果包含，则判断工资是否更高，若更高，则更新工资
			// 去除重复的相同工作难度的工作，且每个工作难度对应的值都是该难度下最高工资
			if (!work.containsKey(k)) {
				work.put(k, v);
			} else if (work.get(k) < v) {
				work.put(k, v);
			}
		}
		int[] a = new int[M];
		// 将能力也加入treemap，但是仅当不包含时才加入
		for (int i = 0; i < M; i++) {
			a[i] = in.nextInt(); // 额外保存，用于最后输出
			if (!work.containsKey(a[i])) work.put(a[i], 0);
		}
		int tmp = 0;
		// 此时treemap中键已经按工作难度（或能力）升序，但是有可能难度高的工资反而小于难度低的工资
		// 因此需要将排在后面的却低的工资补高，让工资不降序，相当于是让每个难度对应的工资是不超过该难度下的最高工资
		for (Map.Entry<Integer, Integer> ent: work.entrySet()) {
			int v = ent.getValue();
			if (v < tmp) {
				ent.setValue(tmp);
			} else {
				tmp = v;
			}
		}
		for (int i = 0; i < M; i++) {
			System.out.println(work.get(a[i]));
		}
	}
}
