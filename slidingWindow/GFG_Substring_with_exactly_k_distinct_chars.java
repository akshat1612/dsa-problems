package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.
 */
public class GFG_Substring_with_exactly_k_distinct_chars {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestKSubstr(s, k));

        s = "aaaa";
        k = 2;
        System.out.println(longestKSubstr(s, k));
    }

    static int longestKSubstr(String s, int k) {
        int l = 0, r = 0, ans = -1;
        Map<Character, Integer> m = new HashMap<>();
        while (r < s.length()) {
            m.merge(s.charAt(r), 1, Integer::sum);
            if (m.size() > k) {
                m.merge(s.charAt(l), -1, Integer::sum);
                if (m.get(s.charAt(l)) == 0) m.remove(s.charAt(l));
                l++;
            }
            if (m.size() == k) {
                ans = Math.max(ans, r - l + 1);
            }
            r++;
        }
        return ans;
    }
}
