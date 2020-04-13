package challenges.april2020;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{-2}));
        System.out.println(solution.maxSubArray(new int[]{-2, 5}));
        System.out.println(solution.maxSubArray(new int[]{-2, 5, 2}));
        System.out.println(solution.maxSubArray(new int[]{-2, -1}));
        System.out.println(solution.maxSubArray(new int[]{-1, -2}));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {

            // dynamic programming, Kadane's algorithm
            int bestSum = Integer.MIN_VALUE, currentSum = 0;
            for (int num : nums) {
                currentSum = Math.max(num, currentSum + num);
                bestSum = Math.max(bestSum, currentSum);
            }

            return bestSum;
        }
    }
}
