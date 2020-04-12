package challenges.april2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LastStoneWeight {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(solution.lastStoneWeight(new int[]{3}));
        System.out.println(solution.lastStoneWeight(new int[]{3, 3}));
        System.out.println(solution.lastStoneWeight(new int[]{3, 3, 8}));
        System.out.println(solution.lastStoneWeight(new int[]{5, 8, 8, 8, 9}));
        System.out.println(solution.lastStoneWeight(new int[]{4, 7, 4, 5, 10, 2, 2, 3}));
    }

    static class Solution {
        public int lastStoneWeight(int[] stones) {

            int index;
            List<Integer> list = new ArrayList<>(stones.length);
            for (int stone : stones) {
                index = Collections.binarySearch(list, stone);
                index = index >= 0 ? index : -(index + 1);
                list.add(Math.abs(index), stone);
            }

            while (list.size() > 1) {
                Integer y = list.remove(list.size() - 1);
                Integer x = list.remove(list.size() - 1);
                int i = y - x;
                if (i > 0) {
                    index = Collections.binarySearch(list, i);
                    index = index >= 0 ? index : -(index + 1);
                    list.add(Math.abs(index), i);
                }
            }

            return list.isEmpty() ? 0 : list.get(0);
        }
    }
}
