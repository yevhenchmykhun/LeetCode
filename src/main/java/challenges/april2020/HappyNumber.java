package challenges.april2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isHappy(19));
//        System.out.println(solution.lastStoneWeight(new int[]{3}));
//        System.out.println(solution.lastStoneWeight(new int[]{3, 3}));
//        System.out.println(solution.lastStoneWeight(new int[]{3, 3, 8}));
//        System.out.println(solution.lastStoneWeight(new int[]{5, 8, 8, 8, 9}));
//        System.out.println(solution.lastStoneWeight(new int[]{4, 7, 4, 5, 10, 2, 2, 3}));
    }

    static class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>(32);
            while (true) {
                n = digitSquareSum(n);
                if (n == 1) {
                    return true;
                } else {
                    if (set.contains(n)) {
                        return false;
                    } else {
                        set.add(n);
                    }
                }
            }
        }

        private int digitSquareSum(int n) {
            int sum = 0;
            do {
                int mod = n % 10;
                sum += mod * mod;
            } while ((n /= 10) > 0);

            return sum;
        }
    }
}
