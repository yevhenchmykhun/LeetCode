package challenges.april2020;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{-2}));
        System.out.println(solution.maxSubArray(new int[]{-2, 5}));
        System.out.println(solution.maxSubArray(new int[]{-2, 5, 2}));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = nums[0];
            for (int end = 1; end < nums.length; end++) {
                for (int start = 0; start <= end; start++) {
                    int sum = 0;
                    for (int index = start; index <= end; index++) {
                        sum += nums[index];
                    }

                    maxSum = Math.max(sum, maxSum);
                }
            }

            return maxSum;
        }
    }
}
