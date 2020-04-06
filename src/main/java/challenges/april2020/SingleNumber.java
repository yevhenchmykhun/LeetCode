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

    static class Solution {

        /**
         * Look at it like math, rather than code; using ^ to mean bit-level xor, we can say that
         * <p>
         * xor is commutative: A ^ B = B ^ A
         * xor is associative: (A ^ B) ^ C = A ^ (B ^ C)
         * xoring with zero does nothing: A ^ 0 = A
         * xoring something twice removes it: A ^ A = 0
         * The first two properties imply that any reordering of a sequence of xors will yield the exact same result.
         * <p>
         * Therefore, given a sequence that contains duplicates, they will all be removed via xor:
         * <p>
         * A ^ B ^ X ^ A ^ B  =  A^A ^ B^B ^ X  =  0 ^ 0 ^ X   =  X
         * Note that this trick only works if there is a single element that is not duplicate.
         * If there were several, the result would be the XOR of all non-evenly-duplicated elements:
         * <p>
         * A ^ B ^ C ^ A  =  A^A ^ B ^ C  =  B ^ C
         *
         * @param nums an array of integers
         * @return unique integer
         */
        public int singleNumber(int[] nums) {
            int i = 0;
            for (int num : nums) {
                i ^= num;
            }

            return i;
        }

    }

}
