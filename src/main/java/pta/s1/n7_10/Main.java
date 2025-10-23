package pta.s1.n7_10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(",");
        Node root = buildTree(s);
        System.out.println(checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }


    public static boolean checkBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }

    public static Node buildTree(String[] s) {
        Queue<Node> q = new LinkedList<Node>();
        Node root = new Node(Integer.parseInt(s[0]));
        q.offer(root);
        for(int i = 1; i < s.length; i++) {
            Node n = null;
            Node parent = q.peek();
            if (!"null".equals(s[i])) {
                n = new Node(Integer.parseInt(s[i]));
            }
            if (!parent.leftSet) {
                parent.left = n;
                parent.leftSet = true;
            } else if (!parent.rightSet) {
                parent.right = n;
                parent.rightSet = true;
            }
            if (parent.leftSet && parent.rightSet) {
                q.poll();
            }
            if (n != null) {
                q.offer(n);
            }
        }
        return root;
    }

    public static class Node {
        int val;
        Node left;
        Node right;
        boolean leftSet;
        boolean rightSet;
        public Node(int v) {
            val = v;
        }
    }
}
