package pta.s1.n7_16;

import java.util.Scanner;

/**
 * 7-16 给定数字组成最大时间
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 *
 * 24 小时格式为HH:MM ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大的是 23:59。
 *
 * 以长度为 5 的字符串，按 HH:MM 格式返回答案。如果不能确定有效时间，则返回空字符串。
 *
 * 输入格式:
 * 4个0~9之间的数字，以,分隔。例如4,2,3,1
 *
 * 输出格式:
 * 23:41
 */
public class Main {

    public static int res = -1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split(",");
        quanPaiLie(arr, 0);
        String x = res > -1 ? (String.format("%02d", res / 100) + ":" + String.format("%02d", res % 100)) : "";
        System.out.println(x);
    }

    public static void quanPaiLie(String[] arr, int n) {
        if (n == arr.length - 1) {
            compareSet(arr);
            return;
        }
        for (int i = n; i < arr.length; i++) {
            swap(arr, n, i);
            quanPaiLie(arr, n + 1);
            swap(arr, n, i);
        }
    }

    public static void swap(String[] arr, int x, int y) {
        if (x != y) {
            String tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }
    }

    public static void compareSet(String[] arr) {
        int hh = Integer.parseInt(arr[0] + arr[1]);
        int mm = Integer.parseInt(arr[2] + arr[3]);
        if (hh <= 23 && mm <= 59) {
            res = Math.max(hh * 100 + mm, res);
        }
    }

}
