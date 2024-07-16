package slidingWindow;

public class LC1358_Number_Of_Substrings_Containing_All_Three_Characters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(numberOfSubstrings(s));

        s = "abcabc";
        System.out.println(numberOfSubstrings(s));

        s = "aaacb";
        System.out.println(numberOfSubstrings(s));

        s = "abc";
        System.out.println(numberOfSubstrings(s));
    }

    static int numberOfSubstrings(String s) {
        int n = s.length();
        int l = 0, r = 0, count = 0;
        int[] map = {0, 0, 0};
        while(r < s.length()) {
            map[s.charAt(r) - 'a']++;
            while( map[0] >=1 && map[1] >= 1 && map[2] >= 1 ) {
                count+=n-r;
                map[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }

        return count;
    }
}
