package pta.s2.n7_8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        String headAddress = str[0];
        int N = Integer.parseInt(str[1]);
        int K = Integer.parseInt(str[2]);
        Map<String, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            str = in.nextLine().split(" ");
            Node node = new Node(str[0],str[1],str[2]);
            nodeMap.put(str[0], node);
        }
        Node head = null;
        for (Node n : nodeMap.values()) {
            if (headAddress.equals(n.address)) {
                head = n;
            }
            if (!"-1".equals(n.nextAddress)) {
                n.next = nodeMap.get(n.nextAddress);
            }
        }
        Node newHead = new Node();
        Node newTail = newHead;
        Node kHead = null;
        Node p = null;

        while (true) {
            int cnt = 0;
            p = head;
            kHead = head;
            while (p != null) {
                cnt++;
                if (cnt == K) {
                    head = p.next;
                    break;
                }
                p = p.next;
            }
            if (cnt == K) {
                // 反转kHead-p之间节点
                Node tmp = rev(kHead, p);
                newTail.next = tmp;
                newTail = kHead;
            } else {
                newTail.next = kHead;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        p = newHead.next;
        while (p != null) {
            Node tmp = p.next;
            sb.append(p.address).append(" ").append(p.data)
                    .append(" ").append(p.next != null ? p.next.address : "-1");
            p = tmp;
        }
        System.out.println(sb);
    }

    public static Node rev(Node h, Node t) {
        Node head = new Node();
        Node p = h;
        while (p != null) {
            Node tmp = p.next;
            p.next = head.next;
            head.next = p;
            if (p == t) {
                break;
            }
            p = tmp;
        }
        return head.next;
    }


    public static class Node {
        String address;
        String data;
        String nextAddress;

        Node next;

        public Node() {}

        public Node(String a, String d, String n) {
            address = a;
            data = d;
            nextAddress = n;
        }
    }
}
