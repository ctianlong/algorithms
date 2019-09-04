package algorithm.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 广度优先搜索
 * 参考：https://blog.csdn.net/raphealguo/article/details/7523411
 * @author ctl
 *
 */
public class BFS {
	
	public static void main(String[] args) {
		BFS bfs = new BFS();
		System.out.println(bfs.solution1("123456", "654321", 2));
	}
	
	/**
	 * 题目：给定序列1 2 3 4 5 6，再给定一个k，我们给出这样的操作：对于序列，我们可以将其中k个连续的数全部反转过来，
	 * 例如k = 3的时候，上述序列经过1步操作后可以变成：3 2 1 4 5 6 ，如果再对序列 3 2 1 4 5 6进行一步操作，可以变成3 4 1 2 5 6.
	 * 问：给定初始序列，以及结束序列，以及k的值，求出从初始序列到结束序列的转变至少需要几步操作？
	 * 
	 * 思路：给定初始状态和目标状态，求最短操作，采用BFS
	 * 把每次操作完的序列当做一个状态节点。那每一次操作就产生一条边，这个操作就是规则。
	 * 简化：用字符串表示该序列
	 */
	public int solution1(String origin, String target, int k) {
		if (origin.equals(target))
			return 0;
		if (origin == null || target == null || origin.length() != target.length() || origin.length() == 0 || k <= 1 || origin.length() < k)
			return -1;
		ArrayDeque<String> queue = new ArrayDeque<>();
		ArrayDeque<Integer> depth = new ArrayDeque<>(); // 辅助记录层数
		HashMap<String, Boolean> visit = new HashMap<>(); // 记录节点是否被访问过（有些情况下，也可以额外定义一个对象，加入visit属性来记录）
		HashMap<String, String> prev = new HashMap<>(); // 记录前驱节点，用来打印路径
		queue.add(origin); // 初始状态节点放进队列
		depth.add(0);
		visit.put(origin, true); // 设置节点已经访问过
		while (!queue.isEmpty()) {
			String vn = queue.remove(); // 取出队列头节点
			int step = depth.remove();
			for (int i = 0; i < origin.length() - k + 1; ++i) { // 遍历该节点的相邻节点
				String vw = reversePart(vn, i, k);
				if (!visit.containsKey(vw)) { // 如果该节点没有被访问过
					if (vw.equals(target)) { // 判断是否为目标节点
						// 利用前驱节点打印路径
						ArrayList<String> path = new ArrayList<>(); // 保存打印路径
						path.add(vw);
						String p = vn;
						while (!p.equals(origin)) {
							path.add(p);
							p = prev.get(p);
						}
						path.add(origin);
						for (int j = path.size() - 1; j >= 0; --j)
							System.out.println(path.get(j));
						// 返回层数，origin为0层
						return step + 1;
					}
					queue.add(vw);
					depth.add(step + 1);
					prev.put(vw, vn); // 记录前驱节点
					visit.put(vw, true);
				}
			}
		}
		return -1;
	}
	
	private String reversePart(String s, int startIndex, int length) {
		char[] c = s.toCharArray();
		char t;
		for (int i = startIndex, j = startIndex + length - 1; i < j; ++i, --j) {
			t = c[i];
			c[i] = c[j];
			c[j] = t;
		}
		return new String(c);
	}

}
