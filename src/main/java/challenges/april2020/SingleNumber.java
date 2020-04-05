package challenges.april2020;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assert 3 == solution.singleNumber(new int[]{3});
        assert 1 == solution.singleNumber(new int[]{2,2,1});
        assert 4 == solution.singleNumber(new int[]{4,1,2,1,2});
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        Counter counter = new Counter();
        for (int num : nums) {
            counter.put(num);
        }

        return counter.getSingle();
    }
}

class Counter {
    private Map<Integer, Integer> counter = new HashMap<>();

    public void put(int value) {
        counter.merge(value, 1, (k, v) -> v + 1);
    }

    public int getSingle() {
        for (Integer key : counter.keySet()) {
            if (counter.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }

}
