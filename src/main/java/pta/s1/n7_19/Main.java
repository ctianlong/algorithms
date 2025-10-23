package pta.s1.n7_19;

import java.util.*;
import java.util.stream.*;

/**
 * 7-19 奖励最顶尖的 K 名学生
 * 给定两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和负面的。
 * positive_feedback = ["smart","brilliant","studious"]
 * negative_feedback = ["not"]
 *
 * 一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减  1 分。
 *
 * 给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中 student_id[i] 表示这名学生的 ID ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
 *
 * 给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。
 *
 * 输入格式:
 * 五部分：正向评语数组positive_feedback，负向评价数组negative_feedback，评语数组report，学生ID数组ID，输出top几名k
 *
 * 以-连接：
 *
 * 输出格式:
 * 最顶尖学生的ID数组
 * 注：拼接字符串时，如果是多个学生的情况，如[1, 2, 3]，需要拼接 ‘, ‘，逗号后面要带上空格
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * ["smart","brilliant","studious"]-["not"]-["this student is studious","the student is smart"]-[1,2]-1
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * [1]
 * 解析：
 *
 * 两名学生都有 1 个正面词汇，都得到 3 分，学生 1 的 ID 更小所以排名更前。
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split("-");
        Set<String> pos = new HashSet<>(Arrays.asList(s[0].replaceAll("[\\[\\]\"]", "").split(",")));
        Set<String> neg = new HashSet<>(Arrays.asList(s[1].replaceAll("[\\[\\]\"]", "").split(",")));
        String[] rep = s[2].replaceAll("[\\[\\]\"]", "").split(",");
        int[] ids = conv(s[3].substring(1, s[3].length() - 1).split(","));
        int k = Integer.parseInt(s[4]);
        List<P> ps = new ArrayList<>();
        for (int i = 0; i < rep.length; i++) {
            int score = 0;
            for (String word : rep[i].split(" ")) {
                if (pos.contains(word)) {
                    score += 3;
                } else if (neg.contains(word)) {
                    score -= 1;
                }
            }
            ps.add(new P(score, ids[i]));
        }
        ps.sort((x, y) -> x.score != y.score ? y.score - x.score : x.id - y.id);
        String res = ps.stream().map(p -> p.id).limit(k).map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("[" + res + "]");
    }

    public static int[] conv(String[] s) {
        int[] res = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            res[i] = Integer.parseInt(s[i]);
        }
        return res;
    }

    public static class P {
        int score;
        int id;
        public P (int s, int i) {
            score = s;
            id = i;
        }
    }

}
