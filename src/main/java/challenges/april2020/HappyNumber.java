package challenges.april2020;

public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isHappy(19));
    }

    // https://leetcode.com/problems/happy-number/discuss/56917/My-solution-in-C(-O(1)-space-and-no-magic-math-property-involved-)
    static class Solution {

        // we can adapt the Floyd Cycle detection algorithm.
        // related to the Linked List Cycle detection problem.
        public boolean isHappy(int n) {
            int slow, fast;
            slow = fast = n;
            do {
                slow = digitSquareSum(slow);
                fast = digitSquareSum(digitSquareSum(fast));
                if (fast == 1) {
                    return true;
                }
            } while (slow != fast);

            return false;
        }

        private int digitSquareSum(int n) {
            int mod;
            int sum = 0;
            do {
                mod = n % 10;
                sum += mod * mod;
            } while ((n /= 10) > 0);

            return sum;
        }
    }
}
