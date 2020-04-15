package challenges.april2020;

public class PerformStringShifts {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.stringShift("abc", new int[][]{}));
        System.out.println(solution.stringShift("a", new int[][]{new int[]{0, 7}, new int[]{1, 1}}));
        System.out.println(solution.stringShift("a", new int[][]{new int[]{0, 7}, new int[]{1, 1}}));
        System.out.println(solution.stringShift("abc", new int[][]{new int[]{0, 1}, new int[]{1, 1}}));
        System.out.println(solution.stringShift("abc", new int[][]{new int[]{0, 1}, new int[]{1, 2}}));
        System.out.println(solution.stringShift("abcdefg", new int[][]{
                new int[]{1, 1},
                new int[]{1, 1},
                new int[]{0, 2},
                new int[]{1, 3}
        }));

        // "hcjwpdh"
        System.out.println(solution.stringShift("wpdhhcj", new int[][]{
                new int[]{0, 7},
                new int[]{1, 7},
                new int[]{1, 0},
                new int[]{1, 3},
                new int[]{0, 3},
                new int[]{0, 6},
                new int[]{1, 2}
        }));

        // "yzwcalxvy"
        System.out.println(solution.stringShift("calxvyyzw", new int[][]{
                new int[]{1, 3}
        }));
    }

    static class Solution {
        public String stringShift(String s, int[][] shift) {

            // reduce all rotation to one
            int distance = 0;
            for (int[] ints : shift) {
                distance = ints[0] == 0 ? distance - ints[1] : distance + ints[1];
            }

            if (distance == 0) {
                return s;
            } else {
                char[] chars = s.toCharArray();

                // get rid of cyclic rotations
                distance = distance % chars.length;

                // absorbed negative distance
                if (distance < 0) {
                    distance += chars.length;
                }

                int i;
                char c;
                char tmp;

                // run swapping cycle for each group of related chars (related by position)
                for (int index = 0, moved = 0; moved != chars.length; index++) {
                    // take current index and char
                    i = index;
                    c = chars[index];
                    do {
                        // calculate new index for the current index
                        i = (i + distance) % chars.length;
                        // swap chars
                        tmp = chars[i];
                        chars[i] = c;
                        c = tmp;
                        // increase number of moved chars
                        moved++;
                        // swap chars until we reach the place where we started
                    } while (i != index);
                }

                return new String(chars);
            }
        }
    }
}
