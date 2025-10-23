package pta.s2.n7_2;

import java.util.Scanner;

/**
 * @author ctl
 * @createTime 2024/09/11 16:15
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += getChangeNum(getBit(a, i), getBit(b, i), getBit(c, i));
        }
        System.out.println(res);
    }

    public static int getBit(int n, int pos) {
        return (n >> pos) & 1;
    }

    public static int getChangeNum(int a, int b, int c) {
        if (a + b == 2 && c == 0) {
            return 2;
        } else if (a + b == 1 && c == 0) {
            return 1;
        } else if (a + b == 0 && c == 1) {
            return 1;
        } else {
            return 0;
        }
    }

}
