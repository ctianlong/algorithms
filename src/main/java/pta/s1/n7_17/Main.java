package pta.s1.n7_17;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 7-17 交换和
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。
 * 若有多个答案，返回所有满足条件的答案。若无满足条件的数值，不输出。
 *
 *
 * 输入格式:
 * 第一行输入第一个整数数组元素，以空格分开（结尾无空格）；
 *
 * 第二行输入第二个整数数组元素，以空格分开（结尾无空格）。
 *
 * 输入两个数组长度大于1，且小于10000
 *
 *
 * 输出格式:
 * 输出数组，长度为2，输出的数组第一个元素表示第一个数组中需要交换的元素值，第二个元素表示第二个数组中需要交换的元素值。且元素之间以空格分开（结尾无空格）。
 * 若有多个答案，请返回所有答案，多组答案输出顺序按每组答案的第一个元素进行升序输出（若第一个元素相同，则继续按照每组第二个元素升序输出），每组答案单独一行显示，如果结果中有重复答案，请仅显示一组。
 *
 * 若无满足条件的数值，不输出。
 *
 *
 * 输入样例1:
 * 在这里给出一组输入。例如：
 *
 * 4 1 2 1 1 2
 * 3 6 3 3
 * 输出样例1:
 * 在这里给出相应的输出。
 * 例如：多组答案输出顺序按照每组第一个元素由小到大顺序输出，如果第一个元素相同，则继续按照第二个元素由小到大输出
 *
 * 1 3
 * 4 6
 * 输入样例2:
 * 在这里给出一组输入。例如：
 *
 * 10 20 30 40 55
 * 60 70 5 9 99
 * 输出样例2:
 * 在这里给出相应的输出。
 *
 * 55 99
 * 输入样例3:
 * 在这里给出一组输入。例如：
 *
 * 11 22 33 44 55
 * 66 77 88 99 110
 * 输出样例3:
 * 在这里给出相应的输出。
 */
public class Main {

    public static void w1() {
        Scanner in = new Scanner(System.in);
        List<Integer> a = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        List<Integer> b = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        int sumA = a.stream().mapToInt(Integer::valueOf).sum();
        int sumB = b.stream().mapToInt(Integer::valueOf).sum();
        int diff = sumA - sumB;
        if (diff % 2 != 0) {
            return;
        }
        diff = diff / 2;
        Set<String> res = new LinkedHashSet<>();
        for (Integer x : a) {
            for (Integer y : b) {
                if (x - y == diff) {
                    res.add(x + " " + y);
                }
            }
        }
        for (String x : res) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s1 = in.nextLine().split(" ");
        String[] s2 = in.nextLine().split(" ");
        int[] n1 = conv(s1);
        int[] n2 = conv(s2);
        int sum1 = 0;
        int sum2 = 0;
        for (int i : n1) {
            sum1 += i;
        }
        for (int i : n2) {
            sum2 += i;
        }
        int diff = sum1 - sum2;
        if (diff % 2 != 0) {
            return;
        }
        Arrays.sort(n1);
        Arrays.sort(n2);
        diff = diff / 2;
        Set<String> res = new LinkedHashSet<>();
        for (int x : n1) {
            for (int y : n2) {
                if (x - y == diff) {
                    res.add(x + " " + y);
                }
            }
        }
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static int[] conv(String[] s) {
        int[] r = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            r[i] = Integer.parseInt(s[i]);
        }
        return r;
    }

}
