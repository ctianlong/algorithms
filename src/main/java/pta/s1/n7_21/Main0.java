package pta.s1.n7_21;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 7-21 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字符，使得每个字符只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 输入格式:
 * 输入一个字符串，字符串的长度小于1000。字符内容是ASCII码，ASCII码定义了128个字符，包括控制字符（例如换行符、制表符、退格等）和可显示的字符（包括数字、字母、标点符号和一些特殊字符）。
 *
 * 输出格式:
 * 输出处理后的字符串
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * abecbcd
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * abecd
 */
public class Main0 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] cs = in.nextLine().toCharArray();
        int[] visited = new int[128];
        int[] counts = new int[128];



    }

}
