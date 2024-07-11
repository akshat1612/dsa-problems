package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

        s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));

        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> position = new HashMap<>();
        int l = 0, r = 0, n = s.length();
        int ans = 0;
        for (char ch: s.toCharArray()) {
            position.put(ch,-1);
        }
        while(r < n) {
            char ch = s.charAt(r);
            int pos = position.get(ch);
            if(pos >= l) {
                l = pos+1;
            } else if (r-l+1 > ans) {
                ans = r-l+1;
            }
            position.put(ch,r);
            r++;
        }
        return ans;
    }
}
