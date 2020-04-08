package challenges.april2020;

import java.util.HashSet;
import java.util.Set;

public class CountingElements {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{1, 2, 3};
        System.out.println(solution.countElements(arr));

        arr = new int[]{1, 1, 3, 3, 5, 5, 7, 7};
        System.out.println(solution.countElements(arr));

        arr = new int[]{1, 3, 2, 3, 5, 0};
        System.out.println(solution.countElements(arr));

        arr = new int[]{1, 1, 2, 2};
        System.out.println(solution.countElements(arr));
    }

    static class Solution {

        public int countElements(int[] arr) {
            Set<Integer> set = new HashSet<>(arr.length);

            for (int i : arr) {
                set.add(i);
            }

            int count = 0;
            for (int i : arr) {
                if (set.contains(i + 1)) {
                    count++;
                }
            }

            return count;
        }
    }
}
