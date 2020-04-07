package challenges.april2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = new String[]{};
        System.out.println(solution.groupAnagrams(strs));

        strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));

        strs = new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        System.out.println(solution.groupAnagrams(strs));

        strs = new String[]{"tao", "pit", "cam", "aid", "pro", "dog"};
        System.out.println(solution.groupAnagrams(strs));
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            char[] arr;
            for (String str : strs) {
                arr = new char[26];
                for (char c : str.toCharArray()) {
                    arr[c - 'a']++;
                }

                String key = new String(arr);
                if (map.containsKey(key)) {
                    map.get(key).add(str);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(key, list);
                }
            }

            return new ArrayList<>(map.values());
        }
    }
}
