package strings;

public class validPalindromeTwo { //leetcode 680
    public boolean validPalindrome(String s) {
        int i = 0; // Initialize left pointer
        int j = s.length() - 1; // Initialize right pointer

        // Loop through the string from both ends towards the center
        while(i < j) {
            // If the characters at the current pointers match, move both pointers inward
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                // If characters don't match, check the two possible substrings:
                // 1. Skipping the character at the left pointer
                // 2. Skipping the character at the right pointer
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        // If the loop completes without mismatches, the string is a palindrome
        return true;
    }

    // Helper method to check if a substring of s is a palindrome
    private boolean isPalindrome(String s, int i, int j) {
        // Loop through the substring from both ends towards the center
        while(i < j) {
            // If the characters at the current pointers don't match, it's not a palindrome
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        // If the loop completes without mismatches, the substring is a palindrome
        return true;
    }
}
