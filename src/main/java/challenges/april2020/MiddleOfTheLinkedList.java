package challenges.april2020;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        System.out.println(solution.middleNode(head).val);

        head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 2; i < 3; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        System.out.println(solution.middleNode(head).val);

        head = new ListNode(1);
        tmp = head;
        for (int i = 2; i < 11; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        System.out.println(solution.middleNode(head).val);

        head = new ListNode(1);
        tmp = head;
        for (int i = 2; i < 10; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        System.out.println(solution.middleNode(head).val);
    }

    static class Solution {
        public ListNode middleNode(ListNode head) {
            int index = 1;
            ListNode middle = head;
            do {
                head = head.next;
                if (index % 2 == 0) {
                    middle = middle.next;
                }
                index++;
            } while (head != null);

            return middle;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
