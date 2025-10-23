package pta.s2.n7_10;

import java.util.Scanner;
import java.util.Stack;

/**
 * 7-10 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 * 输入格式:
 * 第一行为输入序列，第二行为输出序列
 *
 * 输出格式:
 * true 或者 false
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * 1,2,3,4,5
 * 4,5,3,2,1
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * true
 * 解释1:
 * 我们可以按以下顺序执行：
 *
 * push(1), push(2), push(3), push(4), pop() -> 4,
 *
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 *
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 1,2,3,4,5
 * 4,3,5,1,2
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * false
 * 解释2:
 * 1 不能在 2 之前弹出。
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int n = split.length;
        int[] push = new int[n];
        for (int i = 0; i < n; i++) {
            push[i] = Integer.parseInt(split[i]);
        }
        split = in.nextLine().split(",");
        int[] pop = new int[n];
        for (int i = 0; i < n; i++) {
            pop[i] = Integer.parseInt(split[i]);
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < n) {
            stack.push(push[i]);
            i++;
            while (!stack.isEmpty() && stack.peek() == pop[j]) {
                stack.pop();
                j++;
            }
        }
        System.out.println(j == n);
    }

}
