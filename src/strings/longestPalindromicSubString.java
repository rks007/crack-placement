package strings;

public class longestPalindromicSubString { //leetcode 5
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String res = "";
        int resLen = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd length palindrome
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > resLen) {
                    res = s.substring(l, r + 1);
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }

            // even length palindrome
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > resLen) {
                    res = s.substring(l, r + 1);
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
        }

        return res;
    }
}
