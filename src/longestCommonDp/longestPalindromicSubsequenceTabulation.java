package longestCommonDp;

public class longestPalindromicSubsequenceTabulation { //leetcode 516

    /*in this you have been given only one string and we are going to solve it by the lcs approach but as we know that
      in lcs there are two strings in the input, so for the second string, we will reverse the given string and make it our second string
      now if we apply normal lcs we will get the length of the longest palindromic subsequence
      for confirmation you can try and test case of your choice
     */

    public int longestPalindromeSubseq(String s) {
        StringBuilder copyOfs = new StringBuilder(s);
        String t = copyOfs.reverse().toString();

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j< dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];
    }
}
