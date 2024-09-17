package longestCommonDp;

public class minInsertionToMakeStringPalindromeTabulation { //leetcode 1312
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder copy = new StringBuilder(s);
        String t = copy.reverse().toString();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
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
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return n - dp[n][m];
    }
}
