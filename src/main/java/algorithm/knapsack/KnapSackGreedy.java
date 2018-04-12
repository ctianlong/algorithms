package algorithm.knapsack;
 
import java.util.Arrays;  

/* [01背包问题] 此处采用贪心法，其实应该用动态规划
 * 有一个背包，背包容量是M=150。有7个物品，物品可以分割成任意大小。 
要求尽可能让装入背包中的物品总价值最大，但不能超过总容量。 
物品 A  B  C  D  E  F  G 
重量(weight) 35 30 60 50 40 10 25 
价值(value) 10 40 30 50 35 40 30 
*一、首先顶一个权值数组，里面存放的是r[i]=value[i]/weight[i]，在这里表示单位重量。然后定义一个与之对应的index数组 
*r[i]={2/7,4/3,0.5,1,7/8,4,1.2}     index[i]=[0,1,2,3,4,5,6] 
*二、对r数组进行降序排列，同时相应更改index数组 
*r[i]={4,4/3,1.2,1,7/8,0.5,2/7}     index[i]={5,1,6,3,4,2,0} 
*三、根据index数组产生新的weight_new[i]=weight[index[i]],value_new[i]=value[index[i]]可以得到： 
*weight_new[i]={10,30,25,50,40,60,35}   value_new[i]={40,40,30,50,35,30,10}，同时定义一个 
*x[weight_new.length]={0,0,0,0,0,0,0} 
*四、利用新的weight_new做如下操作 
*for(int i=0;i<weight_new.length;i++){ 
*     if(weight_new[i]<M){ 
*         x[i]=1; 
*         M=M-weight_new[i]; 
*     } 
*} 
*此时可以得到一个x数组。 
*五，再根据x[i]从value_new[i]中拿到value相加，和即为价值最大 
*int totalMaxValue=0; 
*for(int i=0;i<value_new.lenght;i++){ 
*    if(x[i] == 1){ 
*        totalMaxValue=totalMaxValue+value_new[i]; 
*    } 
*} 
*/  
public class KnapSackGreedy {
	public static void main(String[] args) {
		int[] weight = new int[] { 35, 30, 60, 50, 40, 10, 25 };
		int[] value = new int[] { 10, 40, 30, 50, 35, 40, 30 };
		KnapSackGreedy.packageGreedy(weight, value, 150);
		KnapSackGreedy.packageGreedy2(weight, value, 150);
	}

	// 利用贪心算法，计算重量为固定值，价值最大可以为多少
	// 要求最后打印出所选物品的原有次序(从1开始)
	public static void packageGreedy(int[] weight, int[] value, int capacity) {
		/* 1、计算单位价值 2、按单位重量价值 r[i]=v[i]/w[i]降序排列 */
		int len = weight.length;
		double[] r = new double[len];
		int[] index = new int[len];
		for (int i = 0; i < len; i++) {
			r[i] = (double) value[i] / (double) weight[i];
			index[i] = i;
		}
		// 降序排列，最好采用稳定排序，如冒泡
		double temp = 0;
		boolean isOrdered;
		for (int i = 0; i < len - 1; i++) {
			isOrdered = true;
			for (int j = 0; j < len - 1 - i; j++)
				if (r[j] < r[j + 1]) {
					temp = r[j];
					r[j] = r[j + 1];
					r[j + 1] = temp;
					int x = index[j];
					index[j] = index[j + 1];
					index[j + 1] = x;
					isOrdered = false;
				}
			if (isOrdered) break;
		}
		/* 选择排序，不稳定
		double temp = 0;
		for (int i = 0; i < len - 1; i++) {
			int maxI = i;
			for (int j = i + 1; j < len; j++)
				if (r[j] > r[maxI])
					maxI = j;
			if (maxI != i) {
				temp = r[i];
				r[i] = r[maxI];
				r[maxI] = temp;
				int x = index[i];
				index[i] = index[maxI];
				index[maxI] = x;
			}
		}
		*/
		/* 排序后的重量和价值分别存到weight_new[]和value_new[]中 */
		int[] weight_new = new int[len];
		int[] value_new = new int[len];
		for (int i = 0; i < len; i++) {
			weight_new[i] = weight[index[i]];
			value_new[i] = value[index[i]];
		}
		/* 打印按单位价值降序之后的物品和物品价值序列 */
//		System.out.println(Arrays.toString(weight_new));
//		System.out.println(Arrays.toString(value_new));
//		System.out.println(Arrays.toString(index));
//		int[] x = new int[len];
		/* 按照贪心策略求解并打印解向量 */
		int[] res = new int[len]; // 记录所选物品的原有次序号（从1开始）
		int cnt = 0; // 记录共选择了几个物品
		int maxValue = 0; // 记录最大总价值
		for (int i = 0; i < len && capacity > 0; i++) {
			if (weight_new[i] <= capacity) {
//				x[i] = 1;
				capacity = capacity - weight_new[i];
				maxValue += value_new[i];
				res[cnt++] = index[i];
			}
		}
		/* 打印01解向量 */
//		System.out.println(Arrays.toString(x));
		Arrays.sort(res, 0, cnt);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt; i++) {
			sb.append(res[i] + 1); // 次序从1开始，所以+1
			sb.append(" ");
		}
		System.out.println(sb.substring(0, sb.length() - 1).toString());
		System.out.println(maxValue);
	}
	
	// 也可以用对象来实现，借助工具API，更简单
	// 要求最后打印出所选物品的原有次序(从1开始)
	public static void packageGreedy2(int[] weight, int[] value, int capacity) {
		int len = weight.length;
		Good[] goods = new Good[len];
		for (int i = 0; i < len; i++) {
			goods[i] = new Good(weight[i], value[i], i);
		}
		// 降序排列，按性价比
		Arrays.sort(goods, (x, y) -> {
			return -Double.compare(x.r, y.r);
		});
		// 开始贪心策略
		int[] res = new int[len]; // 记录所选物品的原有次序号（从1开始）
		int cnt = 0; // 记录共选择了几个物品
		int maxValue = 0; // 记录最大总价值
		for (int i = 0; i < len && capacity > 0; i++) {
			Good g = goods[i];
			if (g.w <= capacity) {
//				g.x = 1;
				capacity -= g.w;
				maxValue += g.v;
				res[cnt++] = g.index;
			}
		}
		Arrays.sort(res, 0, cnt);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt; i++) {
			sb.append(res[i] + 1); // 次序从1开始，所以+1
			sb.append(" ");
		}
		System.out.println(sb.substring(0, sb.length() - 1).toString());
		System.out.println(maxValue);
	}
	
}


class Good {
	int w; // 重量
	int v; // 价值
	double r; // 单位重量价值
	int index; // 物品原有次序（可从0或1开始，看情况而定）
//	int x; // 是否选择该物品
	public Good(int w, int v, int index) {
		this.w = w;
		this.v = v;
		this.r = (double) v / (double) w;
		this.index = index;
//		this.x = 0;
	}
}

