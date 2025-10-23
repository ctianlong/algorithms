package pta.s2.n7_16;

import java.util.Scanner;

/**
 * 7-16 Call to your teacher
 * 从实验室出来后，你忽然发现你居然把自己的电脑落在了实验室里，但是实验室的老师已经把大门锁上了。
 *
 * 更糟的是，你没有那个老师的电话号码。你开始给你知道的所有人打电话，询问他们有没有老师的电话，如果没有，他们也会问自己的同学来询问电话号码。
 *
 * 那么，你能联系到老师并且拿到电脑吗？
 *
 *
 * 输入格式:
 * 存在多组测试样例
 *
 * 每组样例的第一行分别是两个整数n(1<n<=50)，m(1<m<=2000)，n是在题目当中出现的人数，其中你的序号是1号，实验室老师的序号是n。
 * 接下来的m行，每行有两个整数x(1<=x<=n)，y(1<=y<=n)，代表x有y的电话号码。
 *
 * 输出格式:
 * 对于每组测试样例，如果你最终能联系到老师，输出“Yes”，否则输出“No”。
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * 5 5
 * 1 3
 * 2 3
 * 3 4
 * 2 4
 * 4 5
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * Yes
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 4 3
 * 1 2
 * 2 3
 * 4 1
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * No
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] way = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            split = in.nextLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            way[x][y] = 1;
        }
    }

}
