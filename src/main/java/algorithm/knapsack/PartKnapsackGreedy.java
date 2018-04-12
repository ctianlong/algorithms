package algorithm.knapsack;

import java.util.Arrays;

public class PartKnapsackGreedy {
	
	public static void main(String[] args) {
		int[] weight = new int[] { 35, 30, 60, 50, 40, 10, 25 };
		int[] value = new int[] { 10, 40, 30, 50, 35, 40, 30 };
		PartKnapsackGreedy.partKnapsackGreedy(weight, value, 150);
	}
	
	/*
	 * 部分背包：可以拿走某物品的一部分，采用贪心法
	 */
	public static void partKnapsackGreedy(int[] weight, int[] value, int capacity) {
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
		int[] weight_new = new int[len];
		int[] value_new = new int[len];
		for (int i = 0; i < len; i++) {
			weight_new[i] = weight[index[i]];
			value_new[i] = value[index[i]];
		}
		int[] res = new int[len]; // 记录所选物品的原有次序号（从1开始）
		int cnt = 0; // 记录共选择了几个物品
		int maxValue = 0; // 最大总价值
		boolean hasPart = false; int partIndex = -1; double partRatio = 0.0; // 记录部分拿取的物品信息
		for (int i = 0; i < len; i++) {
			if (weight_new[i] < capacity) {
				capacity = capacity - weight_new[i];
				maxValue += value_new[i];
				res[cnt++] = index[i];
			} else if (weight_new[i] == capacity) {
				maxValue += value_new[i];
				res[cnt++] = index[i];
				break;
			} else {
				hasPart = true;
				res[cnt++] = index[i];
				partIndex = index[i];
				partRatio = (double) capacity / (double) weight_new[i];
				maxValue += partRatio * (double) value_new[i];
				break;
			}
		}
		Arrays.sort(res, 0, cnt);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt; i++) {
			sb.append(res[i] + 1); // 次序从1开始，所以+1
			sb.append(" ");
		}
		System.out.println(sb.substring(0, sb.length() - 1).toString());
		if (hasPart) {
			System.out.println("partIndex: " + (partIndex + 1));
			System.out.println("partRatio: " + partRatio);
		}
		System.out.println(maxValue);
		
	}

}
