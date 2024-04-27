package pta.s1.n7_1;

import java.util.*;

/**
 * @author ctl
 * @createTime 2024/04/21 22:12
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ops = sc.nextLine().split(",");
        String[] datas = sc.nextLine().split(",");
        MyQueue q = new MyQueue();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "push":
                    q.push(Integer.parseInt(datas[i]));
                    sb.append("null");
                    break;
                case "pop":
                    sb.append(q.pop());
                    break;
                case "peek":
                    sb.append(q.peek());
                    break;
                case "empty":
                    sb.append(q.empty());
                    break;
            }
            if (i < ops.length - 1) {
                sb.append(",");
            }
        }
        System.out.println(sb);
    }


    public static class MyQueue {
        private Stack<Integer> in = new Stack<>();
        private Stack<Integer> out = new Stack<>();

        public void push(int a) {
            in.push(a);
        }

        public int pop() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public int peek() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return in.empty() && out.empty();
        }

    }

}
