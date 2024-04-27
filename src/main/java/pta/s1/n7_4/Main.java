package pta.s1.n7_4;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[n];
        for (int i = 0; i < n; i++)
            m[i] = sc.nextInt();
        int start = sc.nextInt();
        // 额外存储版本
        int[] visit = new int[n];
        System.out.println(dfs(m, start, visit) ? "True" : "False");
        // 改值版本
        // System.out.println(dfs2(m, start) ? "True" : "False");
    }
    public static boolean dfs2(int[] m, int x) {
        if (x < 0 || x > m.length - 1)
            return false;
        if (m[x] == 0)
            return true;
        if (m[x] == -1) {
            return false; // 已访问过
        }
        int mx = m[x];
        m[x] = -1;
        return dfs2(m, x + mx) || dfs2(m, x - mx);
    }
    public static boolean dfs(int[] m, int x, int[] visit) {
        if (x < 0 || x > m.length - 1)
            return false;
        if (m[x] == 0)
            return true;
        if (visit[x] == 1) {
            return false; // 已访问过
        }
        visit[x] = 1;
        return dfs(m, x + m[x], visit) || dfs(m, x - m[x], visit);
    }
}
