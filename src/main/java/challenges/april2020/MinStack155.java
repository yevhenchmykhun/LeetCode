package challenges.april2020;

import java.util.ArrayList;

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

        private int index;
        private ArrayList<Node> list = new ArrayList<>(128);

        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int x) {
            int min;
            if (index == 0) {
                min = x;
            } else {
                Node element = list.get(index - 1);
                min = element.minValue < x ? element.minValue : x;
            }
            list.add(index++, new Node(x, min));
        }

        public void pop() {
            list.remove(--index);
        }

        public int top() {
            return list.get(index - 1).value;
        }

        public int getMin() {
            return list.get(index - 1).minValue;
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
