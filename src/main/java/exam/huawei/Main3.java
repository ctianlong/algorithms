package exam.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * 类似01背包问题，可用贪婪算法
 * 输入第一行总流量，第二行每个应用流量（顺序即为排行数），第三行每个应用金币数
 * 40
 * 12 13 25 36
 * 11 11 20 30
 * @author ctl
 *
 */
public class Main3 {

	private static int maxMoney = 0;// 最大金币值

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = Integer.valueOf(sc.nextLine());
		String next = sc.nextLine();
		String next2 = sc.nextLine();
		String[] range = next.split(" ");
		String[] money = next2.split(" ");
		int[] rangeInt = new int[range.length];// 流量
		int[] moneyInt = new int[money.length];// 钱
		for (int i = 0; i < rangeInt.length; i++) {
			rangeInt[i] = Integer.valueOf(range[i]);
		}
		for (int i = 0; i < money.length; i++) {
			moneyInt[i] = Integer.valueOf(money[i]);
		}
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<>();// 用来存放位置
		dfs(rangeInt, moneyInt, 0, total, 0, 0, map, list);
		ArrayList<Integer> arrayList = map.get(maxMoney);
		for (int i = 0; i < arrayList.size() - 1; i++) {
			System.out.print(arrayList.get(i) + 1 + " ");
		}
		System.out.print(arrayList.get(arrayList.size() - 1) + 1);
	}

	public static void dfs(int[] rangeInt, int[] moneyInt, int index, int total, int thisTotal, int money,
			Map<Integer, ArrayList<Integer>> map, ArrayList<Integer> list) {
		if (index >= rangeInt.length || thisTotal + rangeInt[index] > total) {
			maxMoney = Math.max(money, maxMoney);
			if (!map.containsKey(money))
				map.put(money, new ArrayList<>(list));
			return;
		}
		for (int i = index; i < moneyInt.length; i++) {
			if (thisTotal + rangeInt[i] > total)
				return;
			money = money + moneyInt[i];
			thisTotal = thisTotal + rangeInt[i];
			list.add(i);
			dfs(rangeInt, moneyInt, i + 1, total, thisTotal, money, map, list);
			money = money - moneyInt[i];
			thisTotal = thisTotal - rangeInt[i];
			list.remove(list.size() - 1);
		}
	}

}
