package challenges.april2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findMaxLength(new int[]{1}));
        System.out.println(solution.findMaxLength(new int[]{0, 1}));
        System.out.println(solution.findMaxLength(new int[]{0, 0, 0, 0, 0, 1, 1, 0}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 0}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 0, 1}));
    }

    static class Solution {
        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>(256);
            map.put(0, -1);
            int maxlen = 0, count = 0;
            for (int i = 0; i < nums.length; i++) {
                count = count + (nums[i] == 0 ? -1 : 1);
                if (map.containsKey(count)) {
                    maxlen = Math.max(maxlen, i - map.get(count));
                } else {
                    map.put(count, i);
                }

            }

            return maxlen;
        }
    }
}
