package pta.s1.n7_18;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] aaaa = "".split(",");
        System.out.println(aaaa);
        System.out.println(aaaa.length);
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] arrs = line.replaceAll("\\[\\[", "").replaceAll("\\]\\]", "").split("],\\[");
        ListNode[] listNode = new ListNode[arrs.length];
        for (int i = 0; i < arrs.length; i++) {
            ListNode head = new ListNode(0);
            ListNode tail = head;
            for (String a : arrs[i].split(",")) {
                tail.next = new ListNode(Integer.parseInt(a));
                tail = tail.next;
            }
            listNode[i] = head.next;
        }
        ListNode res = null;
        for (ListNode n : listNode) {
            res = mergeTwo(res, n);
        }
        StringBuilder sb = new StringBuilder("[");
        ListNode p = res;
        while (p != null) {
            sb.append(p.val).append(", ");
            p = p.next;
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        System.out.println(sb);
    }


    public static ListNode mergeTwo(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode aP = a;
        ListNode bP = b;
        while (aP != null && bP != null) {
            if (aP.val < bP.val) {
                tail.next = aP;
                aP = aP.next;
            } else {
                tail.next = bP;
                bP = bP.next;
            }
            tail = tail.next;
        }
        tail.next = (aP != null ? aP : bP);
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

}
