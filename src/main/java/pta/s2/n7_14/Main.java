package pta.s2.n7_14;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 7-14 计算岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 * 输入格式:
 * 表达二位数组的字符串，比如：[[1,1,0,0,0];[1,1,0,0,0];[0,0,1,0,0];[0,0,0,1,1]]
 *
 * 输出格式:
 * 岛屿数量。例如：3。
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * [[1,1,1,1,0];[1,1,0,1,0];[1,1,0,0,0];[0,0,0,0,0]]
 * 输出样例1:
 * 在这里给出相应的输出。例如：
 *
 * 1
 *
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * [[1,1,0,0,0];[1,1,0,0,0];[0,0,1,0,0];[0,0,0,1,1]]
 * 输出样例2:
 * 在这里给出相应的输出。例如：
 *
 * 3
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        data = data.substring(2, data.length() - 2);
        String[] lineArr = data.split("];\\[");
        int m = lineArr.length;
        int n = lineArr[0].split(",").length;
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] line = lineArr[i].split(",");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j);
                }
        System.out.println(count);
    }

    public static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1)
            return;
        if (grid[i][j] == 1) {
            grid[i][j] = 2; // 将当前1与周边1置为2
            dfs(grid, i, j + 1);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i - 1, j);
        }
    }

}
