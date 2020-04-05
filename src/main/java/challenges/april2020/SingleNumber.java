package challenges.april2020;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int result;
        result = solution.singleNumber(new int[]{3});
        System.out.println(result);

        result = solution.singleNumber(new int[]{2, 2, 1});
        System.out.println(result);

        result = solution.singleNumber(new int[]{4, 1, 2, 1, 2});
        System.out.println(result);
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int i = 0;
        for (int num : nums) {
            i ^= num;
        }

        return i;
    }

}
