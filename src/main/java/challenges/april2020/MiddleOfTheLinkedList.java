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
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
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
