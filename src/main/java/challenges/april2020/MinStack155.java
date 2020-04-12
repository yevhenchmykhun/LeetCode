package challenges.april2020;

import java.util.LinkedList;

public class MinStack155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    static class MinStack {

        private LinkedList<Node> list;

        /** initialize your data structure here. */
        public MinStack() {
            list = new LinkedList<>();
        }

        public void push(int x) {
            int min;
            if (list.isEmpty()) {
                min = x;
            } else {
                Node element = list.element();
                min = element.minValue < x ? element.minValue : x;
            }
            list.push(new Node(x, min));
        }

        public void pop() {
            list.pop();
        }

        public int top() {
            return list.element().value;
        }

        public int getMin() {
            return list.element().minValue;
        }

        private static class Node {
            int value;
            int minValue;

            Node(int value, int minValue) {
                this.value = value;
                this.minValue = minValue;
            }
        }
    }
}
