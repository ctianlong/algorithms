package pta.s2.n7_13;

import java.util.*;

/**
 * 7-13 删除有序链表中重复2次以上元素
 * 给出一个升序排序的链表 L，删除链表中重复2次以上出现的元素，只保留原链表中出现一次或重复2次 的元素。
 *
 * 例如：
 *
 * 给出的链表为 1→2→3→3→4→4→4→4→5, 返回 1→2→3→3→5.
 *
 * 给出的链表为1→1→1→2→3, 返回 2→3.
 *
 * 数据范围： 链表长度 0≤size≤100000，链表中的值满足 ∣val∣≤10000。
 *
 *
 *
 * 输入格式:
 * 第一行包含头节点地址，总节点数量 N （1≤N≤100000）
 *
 * 节点地址用一个 5 位非负整数表示（可能有前导 0），NULL 用 −1 表示。
 *
 * 接下来 N 行，每行描述一个节点的信息，格式如下：
 *
 * Address Data Next
 *
 * 其中 Address 是节点地址，Data 是一个绝对值不超过100000的整数，Next 是下一个节点的地址。
 *
 *
 *
 * 输出格式:
 * 输出删除有序链表中重复2次以上元素后的链表。每个结点占一行，按输入的格式输出。
 *
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 00100 10
 * 99999 3 87654
 * 87654 4 11111
 * 55555 8 -1
 * 44444 4 55555
 * 23854 2 00000
 * 11111 4 22222
 * 00100 1 23854
 * 22222 4 33333
 * 00000 3 99999
 * 33333 4 44444
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * 00100 1 23854
 * 23854 2 00000
 * 00000 3 99999
 * 99999 3 55555
 * 55555 8 -1
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        Map<String, Node> nodeMap = new HashMap<>();
        String headAddress = split[0];
        Node head = null;
        int N = Integer.parseInt(split[1]);
        for (int i = 0; i < N; i++) {
            split = in.nextLine().split(" ");
            Node n = new Node(split[0], split[1], split[2]);
            nodeMap.put(n.address, n);
            if (headAddress.equals(n.address)) {
                head = n;
            }
        }
        Map<String, Integer> countMap = new HashMap<>();
        Set<String> del = new HashSet<>();
        for (Node node : nodeMap.values()) {
            if (!"-1".equals(node.nextAddress)) {
                node.next = nodeMap.get(node.nextAddress);
            }
            Integer count = countMap.get(node.data);
            int res = count == null ? 1 : count + 1;
            countMap.put(node.data, res);
            if (res > 2) {
                del.add(node.data);
            }
        }
        Node fake = new Node();
        fake.next = head;
        Node p = head;
        Node pre = fake;
        while (p != null) {
            if (del.contains(p.data)) {
                pre.next = p.next;
            } else {
                pre = p;
            }
            p = p.next;
        }
        head = fake.next;
        p = head;
        while (p != null) {
            System.out.println(p.address + " " + p.data + " " + (p.next != null ? p.next.address : "-1"));
            p = p.next;
        }
    }


    public static class Node {
        String address;
        String data;
        String nextAddress;

        Node next;

        public Node() {

        }

        public Node(String a, String d, String n) {
            address = a;
            data = d;
            nextAddress = n;
        }
    }

}
