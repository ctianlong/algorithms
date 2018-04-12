package algorithm.knapsack;

/* 参考链接：https://blog.csdn.net/crayondeng/article/details/15784093
 * 关于背包问题，其实可以分为两种类型：0-1背包问题 和 部分背包问题。
有一个窃贼在偷窃一家商店时发现有n件物品，第i件物品价值为vi元，重量为wi，假设vi和wi都为整数。他希望带走的东西越值钱越好，但他的背包中之多只能装下W磅的东西，W为一整数。他应该带走哪几样东西？
0-1背包问题：每件物品或被带走，或被留下，（需要做出0-1选择）。小偷不能只带走某个物品的一部分或带走两次以上同一个物品。
部分背包问题：小偷可以只带走某个物品的一部分，不必做出0-1选择。
更通俗点理解，0-1背包问题的一件物品可以想象成是一个金锭；而部分背包问题中的一件物品可以想象成是金粉。

这两个问题的解决策略也是不同的。
关于0-1背包问题，采用的是动态规划的解决方法；而部分背包问题采用的是贪心法。

0-1背包问题：
在选择是否要把一个物品加到背包中，必须把该物品加进去的子问题的解与不取该物品的子问题的解进行比较。这种方式形成的问题导致了许多重叠子问题，满足动态规划的特征。

部分背包问题：
总是选择每一磅价值 (Vi / Wi) 最大的物品添加进背包中。那么其解决过程是：对每磅价值进行排序，依次从大到小选择添加进背包中。
 * 
 * [01背包问题] 用动态规划
 * 有一个背包，背包容量是M=150。有7个物品，物品可以分割成任意大小。
 * 要求尽可能让装入背包中的物品总价值最大，但不能超过总容量。 
 *  物品 A  B  C  D  E  F  G 
 *  重量(weight) 35 30 60 50 40 10 25 
 *  价值(value) 10 40 30 50 35 40 30 
 *  
*/
public class KnapSackDp {
	public static void main(String[] args) {
		int[] weight = new int[] { 35, 30, 60, 50, 40, 10, 25 };
		int[] value = new int[] { 10, 40, 30, 50, 35, 40, 30 };
		knapSackDp(weight, value, 150);
	}
	
	// 要求打印出所选物品的原有次序(从1开始)
	public static void knapSackDp(int[] weight, int[] value, int capacity) {
		int N = weight.length;
		int[][] V = new int[N + 1][capacity + 1];
		for (int col = 0; col <= capacity; col++)
			V[0][col] = 0;
		for (int row = 0; row <= N; row++)
			V[row][0] = 0;
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= capacity; w++) {
				if (weight[i - 1] <= w) {
					V[i][w] = Math.max(value[i - 1] + V[i -1][w - weight[i - 1]], V[i -1][w]);
				} else {
					V[i][w] = V[i - 1][w];
				}
			}
		}
		// 所选物品序号
		int[] res = new int[N]; // 记录所选物品的原有次序号（从1开始）
		int cnt = 0; // 记录共选择了几个物品
		int remain = capacity;
		for (int i = N; i >= 1; i--) {
			if (remain >= weight[i - 1] && V[i][remain] - V[i - 1][remain - weight[i - 1]] == value[i - 1]) {
				remain -= weight[i - 1];
				res[cnt++] = i; // 记录序号
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = cnt - 1; i >= 0; i--) {
			sb.append(res[i]);
			sb.append(" ");
		}
		System.out.println(sb.substring(0, sb.length() - 1).toString());
		// 最大价值
		System.out.println(V[N][capacity]);
		// 最优解矩阵
		for (int[] row: V) {
			for (int col: row) {
				System.out.format("%5d", col);
			}
			System.out.println();
		}
	}
	
	
}
