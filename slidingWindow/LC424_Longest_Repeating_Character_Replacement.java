package slidingWindow;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 * <p>
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
public class LC424_Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));

        s = "AABABBA";
        k = 1;
        System.out.println(characterReplacement(s, k));

        s = "AACABBAAB";
        k = 2;
        System.out.println(characterReplacement(s, k));
    }

    static int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxF = 0, ans = 0;
        int[] map = new int[26];
        while (r < s.length()) {
            map[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, map[s.charAt(r) - 'A']);
            while ((r - l + 1) - maxF > k) {
                map[s.charAt(l++) - 'A']--;
                maxF = 0;
                for (int i = 0; i < 26; i++) {
                    maxF = Math.max(maxF, map[i]);
                }
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
