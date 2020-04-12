package challenges.april2020;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
        System.out.println(solution.backspaceCompare("ab##", "c#d#"));
        System.out.println(solution.backspaceCompare("a##c", "#a#c"));
        System.out.println(solution.backspaceCompare("a#c", "b"));
        System.out.println(solution.backspaceCompare("bxj##tw", "bxo#j##tw"));
        System.out.println(solution.backspaceCompare("nzp#o#g", "b#nzp#o#g"));
    }

    static class Solution {
        public boolean backspaceCompare(String S, String T) {
            int iS = S.length() - 1;
            int iT = T.length() - 1;
            while (iS >= 0 || iT >= 0) {
                iS = applyBackspaces(S, iS);
                iT = applyBackspaces(T, iT);

                if (iS >= 0 && iT >= 0) {
                    // if two chars are different
                    if (S.charAt(iS) != T.charAt(iT)) {
                        return false;
                    }
                }

                // if there is nothing to compare
                if ((iS >= 0) != (iT >= 0)) {
                    return false;
                }

                iS--;
                iT--;
            }

            return true;
        }

        private int applyBackspaces(String str, int currentIndex) {
            int backspace = 0;
            while (currentIndex >= 0) {
                if (str.charAt(currentIndex) == '#') {
                    currentIndex--;
                    backspace++;
                } else if (backspace > 0) {
                    currentIndex--;
                    backspace--;
                } else {
                    break;
                }
            }

            return currentIndex;
        }
    }
}
