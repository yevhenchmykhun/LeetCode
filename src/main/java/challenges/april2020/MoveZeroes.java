package challenges.april2020;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{0};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0, 1};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int firstZeroIndex = 0;
            int tmp;

            // iterate through all elements
            for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {

                // if current element is not zero
                if (nums[currentIndex] != 0) {

                    // swap elements if two indices are pointing to different elements in the array
                    if (currentIndex != firstZeroIndex) {
                        tmp = nums[currentIndex];
                        nums[currentIndex] = nums[firstZeroIndex];
                        nums[firstZeroIndex] = tmp;
                    }

                    // move "first zero" index froward if current element is not zero
                    // it will always point to the last non zero element or first zero element
                    firstZeroIndex++;
                }
            }
        }
    }

}


