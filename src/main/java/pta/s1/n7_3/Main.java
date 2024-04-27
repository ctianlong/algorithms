package pta.s1.n7_3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ctl
 * @createTime 2024/04/25 19:28
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
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


    public static void easyIterate() {
        String s = "4 5\n" +
                "1 1 0 0 0\n" +
                "1 1 0 0 0\n" +
                "0 0 1 0 0\n" +
                "0 0 0 1 1";
        Scanner sc = new Scanner(s);
        String[] mn = sc.nextLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        String[][] grid = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] link = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = link[j];
            }
        }
        int count = 0;
        Set<Integer> remove = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ("1".equals(grid[i][j])) {
                    count++;
                    // 右
                    if (j + 1 < n) {
                        if ("1".equals(grid[i][j + 1])) {
                            if (!remove.contains(i * n + j + 1)) {
                                count--;
                                remove.add(i * n + j + 1);
                            }
                        }
                    }
                    // 下
                    if (i + 1 < m) {
                        if ("1".equals(grid[i + 1][j])) {
                            if (!remove.contains((i + 1) * n + j)) {
                                count--;
                                remove.add((i + 1) * n + j);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

}
