package pta.s1.n7_2;

import java.util.*;

/**
 * @author ctl
 * @createTime 2024/04/24 11:35
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split("\\|");
        int n = lines.length;
        DSF dfs = new DSF(n);
        for(int i = 0; i < n; i++) {
            String[] nums = lines[i].split(" ");
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if ("1".equals(nums[j])) {
                    dfs.union(i, j);
                }
            }
        }
        Set<Integer> rootSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            rootSet.add(dfs.find(i));
        }
        System.out.println(rootSet.size());
    }


    public static class DSF {
        private int[] parent;
        private int[] rank;

        public DSF(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                // 路径压缩优化
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            // 未使用合并优化
//            if (rootX != rootY) {
//                parent[rootX] = rootY;
//            }
            // 使用按秩合并优化
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    // 秩相等时任意取一个作为最终根均可
                    parent[rootY] = rootX;
                    rank[rootX] = rank[rootX] + 1;
                }
            }
        }
    }

}
